import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] data = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==1 && j ==1){
                    data[i][j]= -1;
                }else{
                data[i][j] = 0;}
                System.out.println(i + ", " + j + ", " + data[i][j]);
            }
        }
        System.out.println(findUniqueWays(m, n, data));

    }

    public static int findUniqueWays(int m, int n, int[][] data) {
        int[] prev = new int[n];
        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                int up = 0;
                int left = 0;
                if(i>0 && j > 0 && data[i][j]==-1){
                    temp[j]=0;
                continue;}
                if (i == 0 && j == 0) {
                    temp[j] = 1;
                    continue;
                }

                if (i > 0) up = prev[j];
                if (j > 0) left = temp[j - 1];
                temp[j] = up + left;

            }
            prev = temp;
        }

//        if(i==0 && j ==0) return 1;
//        if(i<0 || j <0) return 0;
//        if(dp[i][j]!= -1)return dp[i][j];
//         int up = findUniqueWays(i-1,j,dp);
//         int left = findUniqueWays(i, j-1,dp);
//         return dp[i][j] = up + left;
        return prev[n - 1];

    }
}
