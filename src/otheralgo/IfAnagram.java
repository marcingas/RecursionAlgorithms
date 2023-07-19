package otheralgo;

public class IfAnagram {
    public static void main(String[] args) {
        String word1 = "1HELLO[]a";
        String word2 = "a[LEHLO]1";
        System.out.println(optimalChecker(word1,word2));
    }

    public static boolean optimalChecker(String word1, String word2) {

        if (word1.length() != word2.length())
            return false;
        int[] freq = new int[73];
        for (int i = 0; i < word1.length(); i++) {
            freq[word1.charAt(i) - '1']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            freq[word2.charAt(i) - '1']--;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) return false;
        }

        return true;
    }
}
