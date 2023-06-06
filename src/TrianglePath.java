import java.util.Arrays;

public class TrianglePath {
    public static void main(String[] args) {
        int[][] arr = {{1}, {2, 3}, {3, 6, 7}, {8, 9, 6, 10}};
        int n = arr.length;

//        int[][] dp = new int[n][n];
//        for (int[] row : dp){
//            Arrays.fill(row,-1);
//        }

//            System.out.println(findTrianglePath(0, 0, arr,dp));
        System.out.println(findTrianglePath(arr));

    }

    public static int findTrianglePath(int[][] arr) {
        int[][] dp = new int[arr.length][arr.length];
        for (int j = 0; j < arr.length; j++) {
            dp[arr.length - 1][j] = arr[arr.length - 1][j];
        }
        for (int i = arr.length - 2; i >= 0; i--){
            for (int j = i; j>=0; j--){
                int down = arr[i][j] + dp[i+1][j];
        int diagonal = arr[i][j] + dp[i+1][j+1];
        dp[i][j]=Math.min(diagonal,down);
            }
        }


//        if (i == arr.length - 1) {
//            return arr[arr.length - 1][j];
//        }
//        if(dp[i][j]!=-1)return dp[i][j];

//        int down = arr[i][j] + findTrianglePath(i + 1, j, arr);
//        int diagonal = arr[i][j] + findTrianglePath(i + 1, j + 1, arr);


            return dp[0][0];
    }
}
