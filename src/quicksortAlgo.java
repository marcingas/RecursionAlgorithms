import java.util.ArrayList;
import java.util.List;

public class quicksortAlgo {
    public static void main(String[] args) {
        List<Integer>arr = new ArrayList<>(List.of(5,5,6,4,3,2,1,1));
        quickSort(arr,0,arr.size()-1);
        System.out.println(arr);
    }
    public static void quickSort(List<Integer> arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    public static int partition(List<Integer> arr, int low, int high) {
        int startValue = arr.get(low);
        int i = low;
        int j = high;
        while ((i < j)) {
            while (arr.get(i) <= startValue && i <= high - 1) {
                i++;
            }
            while (arr.get(j) > startValue && j >= low + 1) {
                j--;
            }
            if (i < j) {
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        int temp = arr.get(low);
        arr.set(low, arr.get(j));
        arr.set(j, temp);
        return j;

    }
}

