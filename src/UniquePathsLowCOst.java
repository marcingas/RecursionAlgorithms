import java.util.Arrays;

public class UniquePathsLowCOst {
    public static void main(String[] args) {

        int[][] arr = new int[][]{{5, 9, 6}, {11, 5, 2}};
        int n = arr.length;
        int m = arr[0].length;
        int[][] dp = new int[n][m];

//        for(int[]a : dp){
//            Arrays.fill(a,-1);
//        }

        System.out.println("Best path is " + findPath(arr, arr.length, arr[0].length));


    }

    public static int findPath(int[][] arr, int row, int col) {
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = arr[0][0];
                } else {
                    int up = arr[i][j];
                    if (i > 0) {
                        up += dp[i - 1][j];
                    } else {
                        up += Math.pow(4, 6);
                    }
                    int left = arr[i][j];
                    if (j > 0) {
                        left += dp[i][j - 1];
                    } else {
                        left += Math.pow(4, 6);
                    }
                    dp[i][j]= Math.min(up,left);

                }

            }
        }
//        if(row== 0 && col ==0) return arr[0][0];
//        if(row < 0 || col <0) return (int) Math.pow(5,7);
//        if(dp[row][col]!= -1) return dp[row][col];

//        int up = arr[row][col] + findPath(arr, row - 1, col, dp);
//        int left = arr[row][col] + findPath(arr, row, col - 1, dp);
//        return dp[row][col] =Math.min(up,left);
        return dp[row-1][col-1];
    }

}
