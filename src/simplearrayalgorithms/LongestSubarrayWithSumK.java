package simplearrayalgorithms;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 1, 2, 1, 2};
        long k = 3;
        int length = betterHashingApproach(arr, k);
        int length2 = optimalApproach(arr,k);
        System.out.println(length2);
        System.out.println(length);


    }

    public static int getLongestSubarray(int[] arr, long k) {
        int n = arr.length;
        int length = 0;
        for (int startIndex = 0; startIndex < n; startIndex++) {
            long sum = 0;
            for (int endIndex = 0; endIndex < n; endIndex++) {
                sum += arr[endIndex];
                if (sum == k) length = Math.max(length, endIndex - startIndex + 1);
            }
        }
        return length;
    }

    public static int betterHashingApproach(int[] arr, long k) {
        long sum = 0;
        int length = 0;
        Map<Long, Integer> mapSum = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) length = Math.max(length, i + 1);
            long remainingSum = sum - k;
            if (mapSum.containsKey(remainingSum)) length = Math.max(length, i - mapSum.get(remainingSum));
            if (!mapSum.containsKey(sum)) mapSum.put(sum, i);
        }
        return length;
    }

    public static int optimalApproach(int[] arr, long k) {
        int length = 0;
        int left = 0, right = 0;
        long sum = arr[0];
        while (right < arr.length) {
            while (left <= right && sum > k) {
                sum-=arr[left];
                left++;
            }
            if(sum==k)length= Math.max(length,right-left+1);
            right++;
           if(right<arr.length) sum+=arr[right];
        }
        return length;
    }
}
