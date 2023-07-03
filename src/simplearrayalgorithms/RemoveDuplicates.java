package simplearrayalgorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1,2,2,2,3,3,4,4,4};
        removeBruteSollution(arr);
        twoPointersApproach(arr);
    }
    public static void removeBruteSollution(int[]arr){
        Set<Integer>helpSet = new HashSet<>();
        for(int i=0; i< arr.length;i++){
            helpSet.add(arr[i]);
        }
        int i = 0;
        int []ans = new int[helpSet.size()];
        for (var el: helpSet){
            ans[i]=el;
            i++;
        }
        System.out.println(Arrays.toString(ans));
    }

    public static void twoPointersApproach(int []arr){
        int i=0;

        for(int j =0; j<arr.length;j++){
            if(arr[j]!=arr[i]){
                    arr[i+1]=arr[j];
                    i++;
            }
        }

        int[]ans = new int[i+1];
        for(int a = 0; a<=i; a++){
            ans[a]=arr[a];
        }
        System.out.println(Arrays.toString(ans));


    }
}
