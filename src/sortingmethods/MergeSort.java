package sortingmethods;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 5, 7, 8, 1, 2};
        mergeSortMethod(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSortMethod(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        mergeSortMethod(arr, low, mid);
        mergeSortMethod(arr, mid + 1, high);
        merge(arr, low, high, mid);
    }

    public static void merge(int[] arr, int low, int high, int mid) {
        ArrayList<Integer> tempList = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                tempList.add(arr[left]);
                left++;
            } else {
                tempList.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            tempList.add(arr[left]);
            left++;
        }
        while (right <= high) {
            tempList.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = tempList.get(i - low);
        }
    }
}
