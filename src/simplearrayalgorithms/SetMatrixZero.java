package simplearrayalgorithms;

import java.util.Arrays;

public class SetMatrixZero {
    //Problem Statement: Given a matrix if an element in the matrix is 0
    // then you will have to set its entire column and row to 0 and then return the matrix.
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int n = arr.length;
        int m = arr[0].length;
//        for(var el : setMatrixToZerosBRute(arr,m,n))
//        for (var el : setMatrixToZerosBetter(n, m, arr))
        for (var el : setMatrixToZerosOptimal(arr,n,m))
            System.out.println(Arrays.toString(el));
    }

    public static void markRows(int m, int[][] arr, int i) {
        for (int j = 0; j < m; j++) {
            if (arr[i][j] != 0) {
                arr[i][j] = -1;
            }
        }
    }

    public static void markColums(int n, int[][] arr, int j) {
        for (int i = 0; i < n; i++) {
            if (arr[i][j] != 0) {
                arr[i][j] = -1;
            }
        }
    }

    public static void markMatrix(int[][] arr, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    markRows(m, arr, i);
                    markColums(n, arr, j);
                }
            }
        }
    }

    public static int[][] setMatrixToZerosBRute(int[][] arr, int m, int n) {
        markMatrix(arr, n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == -1) {
                    arr[i][j] = 0;
                }
            }
        }
        return arr;
    }

    public static int[][] setMatrixToZerosBetter(int n, int m, int[][] arr) {
        int[] row = new int[n];
        int[] col = new int[m];
        Arrays.fill(row, 0);
        Arrays.fill(col, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    arr[i][j] = 0;
                }
            }
        }
        return arr;
    }

    public static int[][] setMatrixToZerosOptimal(int[][] arr, int n, int m) {
        int col0 = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    if (i != 0)
                        arr[i][0] = 0;
                    else col0 = 0;

                    arr[0][j] = 0;
                }
            }
        }
        for(int i =1; i < n; i++){
            for(int j =1; j < m; j++){
                if(arr[i][0]==0 || arr[0][j]==0){
                    arr[i][j]=0;
                }
            }
        }
        if(arr[0][0]==0){
            for(int j =0; j<m; j++){
                arr[0][j]=0;
            }
        }
        if(col0==0){
            for(int i =0; i < n; i++){
                arr[i][0]=0;
            }

        }
        return arr;
    }

}
