import java.util.Stack;

public class LargestRectangleInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 1}, {1, 0, 1}, {0, 1, 1}, {1, 1, 1}};
        System.out.println(largestRectangleCounter(matrix));

    }

    public static int largestRectangleCounter(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = 0;
        int[] histogram = new int[m];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (matrix[row][col] == 1) histogram[col]++;
                else histogram[col] = 0;
            }
            int area = countMaxAreainHistogram(histogram);
            max = Math.max(max, area);

        }
        return max;
    }

    public static int countMaxAreainHistogram(int[] histogram) {
        int maxArea = 0;
        int n = histogram.length;
        Stack<Integer> helperStack = new Stack();
        for (int i = 0; i <= n; i++) {
            while (!helperStack.isEmpty() && (i ==n || histogram[helperStack.peek()]>= histogram[i])) {

                int height = histogram[helperStack.peek()];
                int width;
                helperStack.pop();
                if (helperStack.isEmpty()) width = i;
                else width = i - helperStack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            helperStack.push(i);

        }
        return maxArea;
    }
}
