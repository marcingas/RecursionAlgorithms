package basicAlgorithms;

public class CheckSumAlgo {
    public static void main(String[] args) {
        //two arrays -> check if exist element such as if switched sum of both tables equals
        int[] arr1 = {3, 7, 9, 2};
        int[] arr2 = {5, 4, 2, 8};
        int max = 9;
        System.out.println(ifExists(arr1, arr2));//Tc=O(n^2)
        System.out.println(ifExistsOptimal(arr1, arr2, max));//Tc=o(n+max);
    }

    public static boolean ifExistsOptimal(int[] arr1, int[] arr2, int max) {
        int sum1 = 0;
        int sum2 = 0;
        boolean ans = false;


        int[] count = new int[max + 1];
        int difference = sum2 - sum1;


        for (int i = 0; i < arr1.length; i++) {
            sum1 += arr1[i];
            sum2 += arr2[i];
        }
        if (difference % 2 == 0) {
            difference /= 2;
            for (int i = 0; i < arr1.length; i++) {
                count[arr1[i]]++;
            }
            for (int i = 0; i < arr2.length; i++) {
                if (arr2[i] - difference >= 0 && arr2[i] - difference <= max && count[arr2[i] - difference] > 0)
                    ans = true;
            }
        }
        return ans;
    }

    public static boolean ifExists(int[] arr1, int[] arr2) {
        int sum1 = 0;
        int sum2 = 0;
        boolean ans = false;

        for (int i = 0; i < arr1.length; i++) {
            sum1 += arr1[i];
            sum2 += arr2[i];
        }
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                int difference = arr2[j] - arr1[i];
                sum1 += difference;
                sum2 -= difference;
                if (sum1 == sum2) ans = true;
            }
        }
        return ans;
    }
}
