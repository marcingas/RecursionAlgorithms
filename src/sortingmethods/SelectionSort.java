package sortingmethods;

public class SelectionSort {
    public static void main(String[] args) {

    }

    public static int[] selection_sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; i < arr.length; j++) {
                if (arr[j] <= arr[min]) min = j;
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
return arr;
    }

}
