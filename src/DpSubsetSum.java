import java.util.Arrays;

public class DpSubsetSum {
    public static void main(String[] args) {
        //find subset which sums to  k target
        int[] arr = {1, 2, 3, 4};
        int target = 4;
        int[][] dp = new int[arr.length][target+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(findSubsetTarget(arr, target, 3, dp));
    }

    public static boolean findSubsetTarget(int[] arr, int target, int ind, int[][] dp) {
        if (target == 0) return true;
        if (ind == 0) return arr[ind] == target;
        if (dp[ind][target] != -1) return dp[ind][target] != 0;
        boolean taken = false;
        if (target >= arr[ind]) taken = findSubsetTarget(arr, target - ind, ind - 1, dp);
        boolean notTaken = findSubsetTarget(arr, target, ind - 1, dp);
        dp[ind][target] = notTaken || taken ? 1 : 0;

        return taken || notTaken;
    }
}
