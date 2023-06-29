public class SubsetWithMin {
    //given an arr with n positive integers. We need to partition the array into two subsets such that the absolute
    //difference of the sum of elements is minimum
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int n = arr.length;
        System.out.println(minSubsetSumDifference(arr, n));


    }

    public static boolean subsetSumEqualsTarget(int index, int target, int[] arr, boolean[][] dp) {

        for(int i =0; i<index;i++){
            dp[i][0]=true;
        }

        if (arr[0] <= target) {
           dp[0][arr[0]] = true;
        }

        for (int i = 1; i < index; i++) {
            for (int tar=1;tar<=target;tar++) {
                boolean notTake = dp[i-1][tar];
                boolean take = false;
                if (arr[i] <= tar) take = dp[i-1][tar - arr[i]];
                dp[i][tar]= take || notTake;
            }
        }
        return dp[index-1][target];
    }

    public static int minSubsetSumDifference(int[] arr, int n) {
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }
        int target = totalSum;
        boolean[][]dp = new boolean[n][target + 1];
        subsetSumEqualsTarget(n, target, arr, dp);
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i <= totalSum / 2; i++) {
            if (dp[n-1][i]) {
                int diff = Math.abs(i - (totalSum - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }
}
