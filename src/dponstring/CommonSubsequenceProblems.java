package dponstring;

import java.util.Arrays;

public class CommonSubsequenceProblems {
    public static void main(String[] args) {
        String s1 = "acda";
        String s2 = "cedba";
        int n = s1.length() - 1;
        int m = s2.length() - 1;

        int[][] dp = new int[n + 2][m + 2];

        int[][] dp1 = new int[n + 1][m + 1];
        for (int[] rows : dp1) {
            Arrays.fill(rows, -1);
        }

        System.out.println(longestCommonS(n, m, s1, s2, dp1));
//        System.out.println(longestCommonSubsequenceRecursively(s1, s2, dp));
//        System.out.println(longestCommonSubsequenceOptimized(s1, s2, dp));
//        System.out.println(largestPalindromeSubsequence(s1,dp));
        System.out.println(minimumInsertsToMakeStringPalindrone(s1, dp));
    }

    public static int longestCommonS(int i, int j, String s1, String s2, int[][] dp) {
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) return dp[i][j] = 1 + longestCommonS(i - 1, j - 1, s1, s2, dp);
        else return dp[i][j] = Math.max(longestCommonS(i - 1, j, s1, s2, dp), longestCommonS(i, j - 1, s1, s2, dp));
    }


    public static int longestCommonSubsequenceRecursively(String s1, String s2, int[][] dp) {

        for (int i = 0; i < s1.length() + 1; i++) dp[i][0] = 0;
        for (int j = 0; j < s2.length() + 1; j++) dp[0][j] = 0;

        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = 0 + Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static int longestCommonSubsequenceOptimized(String s1, String s2, int[][] dp) {

        int[] prev = new int[s2.length() + 1];
        int[] curr = new int[s2.length() + 1];

        for (int j = 0; j < s2.length() + 1; j++) prev[j] = 0;

        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    curr[j] = 1 + prev[j - 1];
                else
                    curr[j] = 0 + Math.max(prev[j], curr[j - 1]);
            }
            prev = curr;
        }
        return prev[s2.length()];
    }

    private static int largestPalindromeSubsequence(String s1, int[][] dp) {
        StringBuilder sb = new StringBuilder(s1).reverse();
        String s2 = sb.toString();
        return longestCommonSubsequenceRecursively(s1, s2, dp);
    }

    private static int minimumInsertsToMakeStringPalindrone(String s1, int[][] dp) {
        return s1.length() - largestPalindromeSubsequence(s1, dp);

    }
}
