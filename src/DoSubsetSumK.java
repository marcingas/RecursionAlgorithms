import java.util.Arrays;

public class DoSubsetSumK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int target = 6;
        int index = arr.length;

//        int[][] dp = new int[index + 1][target + 1];
//        for (var el : dp) {
//            Arrays.fill(el, -1);
//        }
//        System.out.println(subsetSumEqualsK(arr, target, index,dp));
        System.out.println(subsetSumEqualsK(arr, target, index));
    }

    public static boolean subsetSumEqualsK(int[] arr, int target, int n) {
//        if (target == 0) return true;
//        if (index == 0) return arr[0] == target;
//        if (dp[index][target] != -1) return dp[index][target] != 0;
        //1. same size array
        boolean[][] dp = new boolean[n][target + 1];
        boolean[]prev = new boolean[target+1];
        //2.base case:
//        for (int i = 0; i < n; i++) {
//            dp[i][0] = true;
//        }
        prev[0]=true;
//        if (arr[0] <= target) dp[0][arr[0]] = true;
        if (arr[0] <= target) prev[arr[0]]= true;
        //3. rewrite recursion:
        for (int i = 1; i < n; i++) {
            boolean[]temp = new boolean[target+1];
            temp[0]= true;
            for (int tar = 1; tar <= target; tar++) {
//                boolean notTake = dp[i - 1][tar];
                boolean notTake = prev[tar];
                boolean take = false;
                if (arr[i]<=tar) {
//                    take = dp[i - 1][tar - arr[i]];
                    take = prev[tar - arr[i]];
                }
//                dp[i][tar] = take || notTake;
                temp[tar] = take || notTake;
            }
            prev=temp;
        }
//        boolean notTake = subsetSumEqualsK(arr, target, index - 1);
//        boolean take = false;
//        if (target >= arr[index]) {
//            take = subsetSumEqualsK(arr, target - arr[index], index - 1);
//        }
//        dp[index][target] = take || notTake ? 1 : 0;
//        return notTake || take;
//        return dp[n - 1][target];
        return prev[target];
    }
}
