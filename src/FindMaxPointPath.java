import java.util.Arrays;

public class FindMaxPointPath {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 10, 4}, {100, 3, 2, 1}, {1, 1, 20, 2}, {1, 2, 2, 1}};
        System.out.println(getMaxPointPath(arr));
    }

    public static int maxPointPath(int i, int j, int[][] arr, int[][] dp) {
        if (i == 0) return arr[0][1];
        if (j > arr[0].length - 1 || j < 0) return (int) Math.pow(-2, 6);
        if (dp[i][j] != -1) return dp[i][j];
        int leftDiagonal = arr[i][j] + maxPointPath(i - 1, j - 1, arr, dp);
        int up = arr[i][j] + maxPointPath(i - 1, j, arr, dp);
        int rightDiagonal = arr[i][j] + maxPointPath(i - 1, j + 1, arr, dp);

        return dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
    }

    public static int getMaxPointPath(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int max = Integer.MIN_VALUE;
        int [][]dp = new int[n][m];
        for(int[]table : dp){
            Arrays.fill(table,-1);
        }
        for (int j = 0; j < m; j++) {
            int points = maxPointPath(n - 1, j, arr,dp);
            max = Math.max(max, points);
        }
        return max;
    }
}
