package otheralgo;

import java.util.ArrayList;
import java.util.List;

public class GasienicaTraversal {
    public static void main(String[] args) {
        int[] data = {7, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //given int  table find if exists sum of table elements equal to x;
        System.out.println(searchElements(data, 21));
    }

    public static boolean searchElements(int[] data, int x) {

        int first = 0;
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int last = 0; last < data.length; last++) {
            while (first < data.length && (sum + data[first] <= x)) {
                list.add(data[first]);
                sum += data[first];
                first++;
                if (sum == x) {
                    System.out.println(list);
                    return true;
                }
            }
            sum -= data[last];
            list.remove(0);

        }
        return false;
    }
}
