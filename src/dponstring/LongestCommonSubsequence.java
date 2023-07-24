package dponstring;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "acda";
        String s2 = "cedba";
        int n = s1.length() - 1;
        int m = s2.length() - 1;

        int[][] dp = new int[n + 2][m + 2];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        int[][] dp1 = new int[n + 1][m + 1];
        for (int[] rows : dp1) {
            Arrays.fill(rows, -1);
        }

//        System.out.println(longestCommonS(n, m, s1, s2, dp1));
        System.out.println(longestCommonSShiftedIndex(n + 1, m + 1, s1, s2, dp));
    }

    public static int longestCommonS(int i, int j, String s1, String s2, int[][] dp) {
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) return dp[i][j] = 1 + longestCommonS(i - 1, j - 1, s1, s2, dp);
        else return dp[i][j] = Math.max(longestCommonS(i - 1, j, s1, s2, dp), longestCommonS(i, j - 1, s1, s2, dp));
    }

    public static int longestCommonSShiftedIndex(int i, int j, String s1, String s2, int[][] dp) {
        if (i == 0 || j == 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) return dp[i][j] = 1 + longestCommonS(i - 1, j - 1, s1, s2, dp);
        else return dp[i][j] = Math.max(longestCommonS(i - 1, j, s1, s2, dp), longestCommonS(i, j - 1, s1, s2, dp));
    }

    public static int longestCommonSubsequenceRecursively(int i, int j, String s1, String s2) {
        return 0;
    }
}
