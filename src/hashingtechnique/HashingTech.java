package hashingtechnique;

import java.util.Arrays;
import java.util.concurrent.LinkedBlockingDeque;


public class HashingTech {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 2, 1, 2};
        char[] charArr = new char[]{'a', 'a', 'b', 'b', 'b', 'c', 'c', 'd'};
        //how many times numbers appears in array?

        hashingInt(arr);
        charHashing(charArr);

    }

    private static void hashingInt(int[] arr) {
        //hashing:
        //create array with max+1 el in it: fe. 4 +1
        int hashArrLength = maxValue(arr) + 1;
        //init arr with 0:
        int[] hashArr = new int[hashArrLength];
        Arrays.fill(hashArr, 0);
//iterate over arr and ++hashArr in numbers from array
        for (int i = 0; i < arr.length; i++) hashArr[arr[i]]++;
        //find max repeat:
        int maxRepeat = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 1; i < hashArr.length; i++) {
            if(hashArr[i]>maxRepeat){
                maxRepeat = hashArr[i];
                index = i;
            }
        }
        System.out.println(maxRepeat);
        if(index!=-1){
            System.out.println(index);
        }
    }

    private static int maxValue(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    private static void charHashing(char[] arr) {
        //corresponfing value = given char - 'a';
        //lower case ->26 size
        //lower and upper -> 256 size
        int[] hash = new int[26];
        //count++ through all charArr:
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i] - 'a']++;
        }
        int max = Integer.MIN_VALUE;
        char letter = 'A';
        int index = -1;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                index = i;
            }
        }
        System.out.println(max);
        if (index != -1) {
            letter = (char) (index + 'a');
            System.out.println(letter);
        }
    }
}
