import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] histogram = {3, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleOptimised(histogram));
    }

    public static int largestRectangleOptimised(int[] histogram) {
        Stack<Integer> stackSupp = new Stack<>();
        int maxArea = 0;
        int n = histogram.length;
        for (int i = 0; i <= n; i++) {
            while (!stackSupp.isEmpty() && (i == n || histogram[stackSupp.peek()] >= histogram[i])) {
                int height = histogram[stackSupp.peek()];
                stackSupp.pop();
                int width;
                if (stackSupp.isEmpty())
                    width = i;
                else width = i - stackSupp.peek() - 1;

                maxArea = Math.max(maxArea, height * width);
            }
            stackSupp.push(i);
        }
        return maxArea;
    }
}
