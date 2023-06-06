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
        int[]previous = new int[arr.length];

        for (int j = 0; j < arr.length; j++) {
//            dp[arr.length - 1][j] = arr[arr.length - 1][j];
            previous[j] = arr[arr.length-1][j];
        }
        for (int i = arr.length - 2; i >= 0; i--){
            int []temp = new int[arr.length];
            for (int j = i; j>=0; j--){
                int down = arr[i][j] + previous[j];
        int diagonal = arr[i][j] + previous[j+1];
        temp[j]=Math.min(diagonal,down);
            }
            previous = temp;
        }


//        if (i == arr.length - 1) {
//            return arr[arr.length - 1][j];
//        }
//        if(dp[i][j]!=-1)return dp[i][j];

//        int down = arr[i][j] + findTrianglePath(i + 1, j, arr);
//        int diagonal = arr[i][j] + findTrianglePath(i + 1, j + 1, arr);


            return previous[0];
    }
}
