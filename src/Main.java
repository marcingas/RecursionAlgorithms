import java.util.*;

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
        printAllSubseqenceArray(0, list, arr);
        printAllSubseqenceArrayReverse(0, list, arr);
        int[] array1 = new int[]{1, 2, 1};
        List<Integer> list1 = new ArrayList<Integer>();
        int expectedSum = 2;
        printOneSubseqenceArraySumN(0, list1, array1, expectedSum, 0);
        System.out.println(printNumOfSubseqenceArraySumN(0, array1, 2, 0));
        int[] arr4 = new int[]{2, 3, 6, 7};
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        System.out.println(allCombinations(arr4, 7));
        int[] candidates = new int[]{3, 2, 1};
        System.out.println(solutionPrinter(candidates));
        int[] array2 = new int[]{1, 2, 2, 2, 3, 3};
        System.out.println("solutions:");
        Set<List<Integer>> setSolution = new HashSet<>();
        List<Integer> list3 = new ArrayList<>();
        uniqueAllSubsets(0, setSolution, list3, array2);
        int[] nums = new int[]{1, 2, 2, 2, 3, 3};
        System.out.println("ans printer: ");
        System.out.println(ansPrinter(nums));
        int[] nums3 = new int[]{1, 2, 3};
        List<List<Integer>> answer2 = new ArrayList<>();
        boolean[] elementChecker = new boolean[3];
        List<Integer> storeData = new ArrayList<>();

        allPossiblePermutations(elementChecker, nums3, storeData, answer2);
        System.out.println("all Possible permutations: ");
        System.out.println(answer2);
        int[] nums4 = new int[]{1, 2, 3};
        List<List<Integer>> answer3 = new ArrayList<>();
        List<Integer> storeData2 = new ArrayList<>();
        System.out.println("version2 ");
        allPossiblePermutation2(nums4, 0, answer3);
        System.out.println(answer3);

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
        if (i >= array.length / 2) return;
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

    public static void printAllSubseqenceArray(int ind, List<Integer> list, int[] arr) {
        if (ind == arr.length) {
            System.out.println(list.toString());
            return;
        }
        list.add(arr[ind]);
        printAllSubseqenceArray(ind + 1, list, arr);
        list.remove(list.size() - 1);
        printAllSubseqenceArray(ind + 1, list, arr);
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
        if (currentSum > expectedSum) return 0;
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

    public static void findCombinations(int index, int[] arr, int target, List<List<Integer>> answer, List<Integer> list) {
        if (index == arr.length) {
            if (target == 0) {
                answer.add(new ArrayList<>(list));

            }
            return;
        }
        if (arr[index] <= target) {
            list.add(arr[index]);
            findCombinations(index, arr, target - arr[index], answer, list);
            list.remove(list.size() - 1);
        }
        findCombinations(index + 1, arr, target, answer, list);


    }

    public static void findUniqeCombinationsOncePick(int index, int[] arr, int target, List<List<Integer>> answer, List<Integer> list) {
        if (target == 0) {
            answer.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;

            list.add(arr[i]);
            findUniqeCombinationsOncePick(i + 1, arr, target - arr[i], answer, list);
            list.remove(list.size() - 1);
        }
    }

    public static List<List<Integer>> allCombinations(int[] arr, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        findCombinations(0, arr, target, answer, new ArrayList<>());
        return answer;
    }

    public static List<List<Integer>> allCombinationsUnique(int[] arr, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(arr);
        findUniqeCombinationsOncePick(0, arr, target, answer, new ArrayList<>());
        return answer;
    }

    public static void sumOFSubsets(int i, int[] arr, List<Integer> list, int sum) {
        if (i == arr.length) {
            list.add(sum);
            return;
        }
        sumOFSubsets(i + 1, arr, list, sum + arr[i]);
        sumOFSubsets(i + 1, arr, list, sum);
    }

    public static List<Integer> solutionPrinter(int[] arr) {
        List<Integer> solutionList = new ArrayList<>();
        sumOFSubsets(0, arr, solutionList, 0);
        Collections.sort(solutionList);
        return solutionList;
    }

    public static void uniqueAllSubsets(int i, Set<List<Integer>> subsets, List<Integer> list, int[] array) {
        if (i == array.length) {
            System.out.println(list);
            subsets.add(list);
            return;
        }
        list.add(array[i]);
        uniqueAllSubsets(i + 1, subsets, list, array);
        list.remove(list.size() - 1);
        uniqueAllSubsets(i + 1, subsets, list, array);
    }

    private static Set<List<Integer>> solutionPrinterUnique(int[] array) {
        Set<List<Integer>> solutions = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        uniqueAllSubsets(0, solutions, list, array);
        return solutions;
    }

    public static void findSubsetsUnique(int index, int[] nums, List<Integer> list, List<List<Integer>> answerList) {
        answerList.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            if (i != index && (nums[i] == nums[i - 1])) continue;
            list.add(nums[i]);
            findSubsetsUnique(i + 1, nums, list, answerList);
            list.remove(list.size() - 1);
        }
    }

    public static List<List<Integer>> ansPrinter(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answerList = new ArrayList<>();
        findSubsetsUnique(0, nums, new ArrayList<>(), answerList);
        return answerList;
    }

    public static void allPossiblePermutations(boolean[] elementPresentChecker, int[] nums,
                                               List<Integer> storeData, List<List<Integer>> answer) {
        if (storeData.size() == nums.length) {
            answer.add(new ArrayList<>(storeData));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!elementPresentChecker[i]) {
                elementPresentChecker[i] = true;
                storeData.add(nums[i]);
                allPossiblePermutations(elementPresentChecker, nums, storeData, answer);
                storeData.remove(storeData.size() - 1);
                elementPresentChecker[i] = false;
            }
        }
    }

    public static void allPossiblePermutation2(int[] nums, int index, List<List<Integer>> answer) {
        if (index == nums.length) {
            List<Integer> storeData = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                storeData.add(nums[i]);
            }
            answer.add(new ArrayList<>(storeData));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            allPossiblePermutation2(nums, index + 1, answer);
            swap(i, index, nums);
        }

    }

}