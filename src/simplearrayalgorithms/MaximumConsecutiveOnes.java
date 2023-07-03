package simplearrayalgorithms;

public class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1};
        System.out.println(findMaxConsecutiveOptimal(arr));//TC=O(n), SC=O(1)
    }

    public static int findMaxConsecutiveOptimal(int[] arr) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
                max = Math.max(max, count);
            } else count = 0;
        }
        return max;
    }
}
