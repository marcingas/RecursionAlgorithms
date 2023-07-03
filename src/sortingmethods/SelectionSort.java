package sortingmethods;

import java.util.Arrays;

public class SelectionSort {
    //TC = O((N*(N+1))/2); N*N, SC = O(1);
    public static void main(String[] args) {
        int[]arr={5,6,4,3,2,1};
        System.out.println(Arrays.toString(selection_sort(arr)));
    }

    public static int[] selection_sort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] <= arr[min]) min = j;
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
return arr;
    }

}
