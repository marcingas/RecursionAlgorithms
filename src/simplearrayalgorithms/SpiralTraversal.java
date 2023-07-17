package simplearrayalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralTraversal {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        System.out.println(createSpiral(arr));

    }

    private static List<Integer> createSpiral(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        List<Integer> list = new ArrayList<>();

        int top = 0;
        int left = 0;
        int bottom = n - 1;
        int right = m - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++)
                list.add(arr[top][i]);
            top++;

            for (int i = top; i <= bottom; i++)
                list.add(arr[i][right]);
            right--;

                for (int i = right; i >= left; i--)
                    list.add(arr[bottom][i]);
                bottom--;


                for (int i = bottom; i >= top; i--)
                    list.add(arr[i][left]);
                left++;

        }
        return list;
    }
}
