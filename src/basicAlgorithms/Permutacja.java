package basicAlgorithms;

public class Permutacja {
    public static void main(String[] args) {
        //check if permutation of 1,2,...n-1
        int[] arr = {1, 3, 4, 5, 2};
        System.out.println(ifPermute(arr));//Tc = O(n)

    }

    public static boolean ifPermute(int[] arr) {
        int max = 0;
        boolean ans = true;
        for (int i = 0; i < arr.length; i++) if (max < arr[i]) max = arr[i];
        int[] count = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr.length || count[arr[i]] == 1) ans = false;
            else count[arr[i]] = 1;
        }

        return ans;
    }
}
