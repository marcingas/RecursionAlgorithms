import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        count(1, 3);
        System.out.println();
        countBackward(3, 3);
        System.out.println();
        countMinus(3, 3);
        System.out.println();
        countPlus(1, 3);
        System.out.println();
        sumN(3, 0);
        System.out.println();
        System.out.println(sumNFunctional(3));
        factorialN(4, 1);
        System.out.println(factorialNFunctiona(4));
        int[] array = new int[]{1, 2, 3, 4, 5};
        reverseArrayElements(0, array.length - 1, array);
        System.out.println(Arrays.toString(array));
        reverseArrayOneParam(0, array);
        System.out.println(Arrays.toString(array));
        System.out.println(palindromeCheck(0, "12321"));
        System.out.println(fibonacciElementCount(7));
        int[] arr = new int[]{3, 1, 2};
        List<Integer> list = new ArrayList<>();
//        printAllSubseqenceArray(0, list, arr);
//        printAllSubseqenceArrayReverse(0,list,arr);
        int[] array1 = new int[]{1, 2, 1};
        List<Integer> list1 = new ArrayList<Integer>();
        int expectedSum = 2;
        printOneSubseqenceArraySumN(0, list1, array1, expectedSum, 0);
        System.out.println(printNumOfSubseqenceArraySumN(0,array1,2,0));
    }

    public static void count(int i, int n) {
        if (i > n)
            return;
        System.out.print(i);
        count(i + 1, n);
    }

    public static void countBackward(int i, int n) {
        if (i < 1)
            return;
        System.out.print(i);
        countBackward(i - 1, n);
    }

    public static void countMinus(int i, int n) {
        if (i < 1)
            return;
        countMinus(i - 1, n);
        System.out.print(i);

    }

    public static void countPlus(int i, int n) {
        if (i > n)
            return;
        countPlus(i + 1, n);
        System.out.print(i);
    }

    public static void sumN(int i, int sum) {
        if (i < 1) {
            System.out.print(sum);
            return;
        }
        sumN(i - 1, sum + i);
    }

    public static int sumNFunctional(int n) {
        if (n == 0)
            return 0;
        return n + sumNFunctional(n - 1);

    }

    public static void factorialN(int n, int factorial) {
        if (n < 1) {
            System.out.println(factorial);
            return;
        }
        factorialN(n - 1, factorial * n);
    }

    public static int factorialNFunctiona(int n) {
        if (n == 1)
            return 1;
        return n * factorialNFunctiona(n - 1);
    }

    public static void reverseArrayElements(int i, int j, int[] array) {
        if (i >= j) return;
        swap(i, j, array);
        reverseArrayElements(i + 1, j - 1, array);

    }

    public static void reverseArrayOneParam(int i, int[] array) {
        if (i > array.length / 2) return;
        swap(i, (array.length - 1 - i), array);
        reverseArrayOneParam(i + 1, array);
    }

    public static int[] swap(int index1, int index2, int[] arr) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        return arr;
    }

    public static boolean palindromeCheck(int i, String word) {
        if (i >= word.length() / 2) return true;
        if (word.charAt(i) != word.charAt(word.length() - 1 - i)) return false;
        return palindromeCheck(i + 1, word);


    }

    public static int fibonacciElementCount(int n) {
        if (n <= 1) return n;
        return fibonacciElementCount(n - 1) + fibonacciElementCount(n - 2);

    }

    public static void printAllSubseqenceArray(int index, List<Integer> list, int[] arr) {
        if (index == arr.length) {
            System.out.println(list.toString());
            return;
        }
        list.add(arr[index]);
        printAllSubseqenceArray(index + 1, list, arr);
        list.remove(list.size() - 1);
        printAllSubseqenceArray(index + 1, list, arr);
    }

    public static void printAllSubseqenceArrayReverse(int index, List<Integer> list, int[] arr) {
        if (index == arr.length) {
            System.out.println(list.toString());
            return;
        }
        printAllSubseqenceArrayReverse(index + 1, list, arr);
        list.add(arr[index]);
        printAllSubseqenceArrayReverse(index + 1, list, arr);
        list.remove(list.size() - 1);

    }

    public static Boolean printOneSubseqenceArraySumN(int index, List<Integer> list, int[] arr,
                                                      int expectedSum, int currentSum) {

        if (index == arr.length) {
            if (currentSum == expectedSum) {
                System.out.println(list.toString());
                return true;
            }
            return false;
        }
        list.add(arr[index]);
        currentSum += arr[index];

        if (printOneSubseqenceArraySumN(index + 1, list, arr, expectedSum, currentSum) == true) {
            return true;
        }

        currentSum -= arr[index];
        list.remove(list.size() - 1);

        if (printOneSubseqenceArraySumN(index + 1, list, arr, expectedSum, currentSum) == true) {
            return true;
        }
        return false;
    }

    public static int printNumOfSubseqenceArraySumN(int index, int[] arr, int expectedSum, int currentSum) {
        if(currentSum>expectedSum) return 0;
        if (index == arr.length) {
            if (currentSum == expectedSum) return 1;
            return 0;
        }
        currentSum += arr[index];

        int countL = printNumOfSubseqenceArraySumN(index + 1, arr, expectedSum, currentSum);
        currentSum -= arr[index];

        int countR = printNumOfSubseqenceArraySumN(index + 1, arr, expectedSum, currentSum);
        return countL + countR;
    }
}