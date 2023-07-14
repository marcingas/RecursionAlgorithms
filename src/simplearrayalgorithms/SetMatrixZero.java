package simplearrayalgorithms;

import java.util.Arrays;

public class SetMatrixZero {
    //Problem Statement: Given a matrix if an element in the matrix is 0
    // then you will have to set its entire column and row to 0 and then return the matrix.
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int n = arr.length;
        int m = arr[0].length;

//        bruteSolution(arr, n, m);
//
//        betterSolution(arr, n, m);

        optimalSolution(arr, n, m);


    }

    private static void optimalSolution(int[][] arr, int n, int m) {
        int colZero = 1;
        optimalFillArrWithZero(arr, n, m, colZero);
        optimalFillFromOneWithZero(arr, n, m);
        optimalFillFirstRowColWithZero(arr, n, m, colZero);
        printAns(arr);
    }

    private static void optimalFillFirstRowColWithZero(int[][] arr, int n, int m, int colZero) {
        if (arr[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                arr[0][j] = 0;
            }
        }
        if (colZero == 0) {
            for (int i = 0; i < n; i++) {
                arr[i][0] = 0;
            }
        }
    }

    private static void optimalFillFromOneWithZero(int[][] arr, int n, int m) {
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr[i][j] != 0) {
                    if (arr[i][0] == 10 || arr[0][j] == 0) {
                        arr[i][j] = 0;
                    }
                }
            }
        }
    }

    private static void optimalFillArrWithZero(int[][] arr, int n, int m, int colZero) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    if (j != 0) {
                        arr[0][j] = 0;
                    } else {
                        colZero = 0;
                    }
                }
            }
        }
    }

    private static void betterSolution(int[][] arr, int n, int m) {
        int[] row = new int[n];
        int[] col = new int[m];
        fillRowCol(arr, n, m, row, col);
        fillArrWithZeros(arr, n, m, row, col);
        printAns(arr);
    }

    private static void fillArrWithZeros(int[][] arr, int n, int m, int[] row, int[] col) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    arr[i][j] = 0;
                }
            }
        }
    }

    private static void fillRowCol(int[][] arr, int n, int m, int[] row, int[] col) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
    }

    private static void bruteSolution(int[][] arr, int n, int m) {
        markMinusOne(arr, n, m);
        markZero(arr, n, m);
        printAns(arr);
    }

    private static void printAns(int[][] arr) {
        for (var el : arr) {
            System.out.println(Arrays.toString(el));
        }
    }

    private static void markZero(int[][] arr, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == -1) arr[i][j] = 0;
            }
        }
    }

    private static void markMinusOne(int[][] arr, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    markRow(arr, n, j);
                    markCol(arr, m, i);
                }
            }
        }
    }

    private static void markCol(int[][] arr, int m, int i) {
        for (int col = 0; col < m; col++) {
            if (arr[i][col] != 0) arr[i][col] = -1;
        }
    }

    private static void markRow(int[][] arr, int n, int j) {
        for (int row = 0; row < n; row++) {
            if (arr[row][j] != 0) arr[row][j] = -1;
        }
    }
}
