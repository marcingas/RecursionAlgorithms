package simplearrayalgorithms;

public class FindSingleElement {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 4, 4, 5, 5};
        System.out.println(findSingleBruteSol(arr));//TC=O(NxN), SC=O(1)
    }

    public static int findSingleBruteSol(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (num== arr[j]) count++;
            }
            if (count == 1) return num;
        }
        return -1;
    }
}
