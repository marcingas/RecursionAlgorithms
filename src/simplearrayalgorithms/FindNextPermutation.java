package simplearrayalgorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindNextPermutation {
    //    Given an array Arr[] of integers, rearrange the numbers of the given array
//    into the lexicographically next greater permutation of numbers.
//If such an arrangement is not possible, it must rearrange to the lowest possible order
// (i.e., sorted in ascending order).
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[]{2, 1, 5, 4, 3, 0, 0});
        System.out.println(nextPermutation(list));
    }

    public static List<Integer> nextPermutation(List<Integer> list) {
        //find breakpoint :
        int ind = -1;
        for (int i = list.size() - 2; i >= 0; i--) {
            if (list.get(i) < list.get(i + 1)) {
                ind = i;
                break;
            }
        }
        //if breakpoint doesn't exist reverse array:
        if (ind == -1) {
            Collections.reverse(list);
            return list;
        }
        //find next greater element in right side of ind and swap it:
        for (int i = list.size() - 1; i > ind; i--) {
            if (list.get(i) > list.get(ind)) {
                int temp = list.get(i);
                list.set(i, list.get(ind));
                list.set(ind, temp);
                break;
            }
        }
        //reverse right half after breakpoint:
        List<Integer>sublistToReverse = list.subList(ind+1,list.size());
        Collections.reverse(sublistToReverse);
        return list;
    }
}

