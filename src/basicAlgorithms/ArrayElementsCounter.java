package basicAlgorithms;

public class ArrayElementsCounter {
    public static void main(String[] args) {
        int[] arr = {-1, -1, -5, -5, -4, 1, 1, 2, 3, 4, 5, 6, 7, 5, 6, 4, 8, 9, 5, 5, 8, 7, 7};
        int max = 0;
        int minusMax = 0;

        countVaules(arr, max, minusMax);
    }

    private static void countVaules(int[] arr, int max, int minusMax) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0 && arr[i] > max) max = arr[i];
            else {
                if (arr[i] < minusMax) minusMax = arr[i];
            }
        }
        int[] ans = new int[max + 1];
        int[] ansMinus = new int[Math.abs(minusMax - 1)];

        for (var el : arr) {
            if (el >= 0) ans[el]++;
            else ansMinus[Math.abs(el)]++;
        }

        System.out.println(ans[5]);
        System.out.println(ansMinus[Math.abs(-5)]);
    }
}
