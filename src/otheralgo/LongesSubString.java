package otheralgo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongesSubString {
    public static void main(String[] args) {
        //given String, find the longest substring without repeating char.
        String string = "abcdaabbabcde";
        System.out.println(findTheLongestBrute(string));//TC= O(N^2)
        System.out.println(findTheLongest(string));//TC=O(N)
        System.out.println(findTheLongestOptimal(string));//TC=O(N), faster

    }

    private static int findTheLongestBrute(String string) {
        int max = 0;
        for (int i = 0; i < string.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < string.length(); j++) {
                if (set.contains(string.charAt(j))) {
                    max = Math.max(max, j - i + 1);
                    break;
                }
                set.add(string.charAt(j));
            }
        }
        return max;
    }

    private static int findTheLongestOptimal(String string) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int length = 0;
        while (right < string.length()) {
            if (map.containsKey(string.charAt(right)))
                left = Math.max(map.get(string.charAt(right)) + 1, left);

            map.put(string.charAt(right), right);
            length = Math.max(length, right - left + 1);
            right++;
        }
        return length;
    }

    public static int findTheLongest(String string) {
        int left = 0;
        int right = 1;
        int max = 0;

        Set<Character> tempSet = new HashSet<>();
        tempSet.add(string.charAt(0));
        while (right < string.length()) {
            if (tempSet.add(string.charAt(right))) {
                right++;
            } else {
                max = Math.max(right - left, max);
                while (left < right && tempSet.contains(string.charAt(right))) {
                    tempSet.remove(string.charAt(right));
                    left++;
                }
            }


        }
        max = Math.max(right - left, max);

        return max;
    }
}
