package basicAlgorithms;

import java.util.Arrays;

public class CountingToy {
    public static void main(String[] args) {
        int n = 5;
        int m = 7;
        int[] data = {3, 4, 4, 6, 1, 4, 4};
        int[] ans = count(data, n, m);
        for (int i = 1; i <= n; i++) {
            System.out.print(ans[i]);
        }
    }

    private static int[] count(int[] data, int n, int m) {
        int minimum = 0;
        int maximum = 0;
        int ans[] = new int[n + 1];
        for (int i = 0; i < data.length; i++) {
            if (data[i] == n + 1) {
                minimum = maximum;
            } else {
                ans[data[i]] = Math.max(minimum, ans[data[i]]) + 1;
                maximum = Math.max(maximum, ans[data[i]]);

            }
        }
        for (int i = 1; i < n; i++) ans[i] = Math.max(minimum, ans[i]);
        return ans;
    }
}
