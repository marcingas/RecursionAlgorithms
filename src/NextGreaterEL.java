import java.util.Arrays;
import java.util.Stack;

public class NextGreaterEL {
    public static void main(String[] args) {
int[]arr = {5,7,1,2,6,0};
int[]arr2=nextGreater(arr);
        for(int i = 0; i < arr2.length; i++){
            System.out.println(arr2[i]+ " ");
        }
    }

    public static int[] nextGreater(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i % n]) {
                st.pop();
            }
            if (i < n) {
                if (!st.isEmpty()) nge[i] = st.peek();
                else nge[i]=-1;
            }
            st.push(nums[i%n]);
        }
        return nge;
    }
}
