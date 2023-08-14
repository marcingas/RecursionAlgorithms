package basicAlgorithms;

public class SumationInRranges {
    public static void main(String[] args) {
        int[] data = {1, 3, 5, 6, 7, 8};
        System.out.println(sumInRanges(0, 5, data));
        System.out.println(sumInRanges(0, 3, data));

    }

    private static int sumInRanges(int left, int right, int[] data) {
        int[] sum = new int[data.length + 1];
        int s = 0;
        for (int i = 0; i < data.length; i++) {
            s += data[i];
            sum[i + 1] += s;
        }

        return sum[right + 1] - sum[left];

    }
}


