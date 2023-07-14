package hashingtechnique;

import java.util.Arrays;

public class HashingTech {
    public static void main(String[] args) {
        int[]arr = new int[]{1,2,3,4,2,1,2};
        //how many times numbers appears in array?
        //hashing:
        //create array with max+1 el in it: fe. 4 +1
        int hashArrLength = maxValue(arr) + 1;
        //init arr with 0:
        int[]hashArr = new int[hashArrLength];
        Arrays.fill(hashArr,0);
//iterate over arr and ++hashArr in numbers from array
        for(int i =0; i < arr.length;i++)hashArr[arr[i]]++;
        //find max repeat:
        int maxRepeat = Integer.MIN_VALUE;
        int index =0;
        for(int i =1; i < hashArr.length; i++){
            maxRepeat = Math.max(maxRepeat,hashArr[i]);
        }
        for(int i =1; i < hashArr.length; i++){
            if(hashArr[i]==maxRepeat) System.out.println(i);
        }
        System.out.println(maxRepeat);

    }

    private static int maxValue(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i]>max) max = arr[i];
        }
        return max;
    }
}
