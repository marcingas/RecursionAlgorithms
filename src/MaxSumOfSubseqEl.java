import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumOfSubseqEl {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 4, 3};
        int[] answer = new int[arr.length];
        Arrays.fill(answer, -1);
        System.out.println(pickAllPossibleSubseq(arr, arr.length - 1, answer));
        Arrays.fill(answer, 0);
        System.out.println(pickAllPossibleSubTabulation(arr,answer));

        //space optimalization:
        int previous = arr[0];
        int previous2 = 0;
        for(int i = 1; i < answer.length; i++) {

            int pick = arr[i];
            if(i>1)pick += previous2;
            int notPick = 0 + previous;
            int actualiInd = Math.max(pick, notPick);
            previous2=previous;
            previous=actualiInd;
        }
        System.out.println(previous);

    }

    public static int pickAllPossibleSubseq(int[] arr, int index, int[] answer) {
        if (index == 0) return arr[index];
        if (index < 0) return 0;
        if(answer[index]!=-1)return answer[index];


        int pick = arr[index] + pickAllPossibleSubseq(arr, index - 2, answer);
        int notPick = 0 + pickAllPossibleSubseq(arr, index - 1, answer);

        return answer[index] = Math.max(pick, notPick);
    }
    public static int pickAllPossibleSubTabulation(int[] arr, int[] answer){
        answer[0]= arr[0];
        int negative = 0;
        for(int i = 1; i < answer.length; i++) {

            int pick = arr[i];
            if(i>1)pick += answer[i-2];
            int notPick = 0 + answer[i-1];
            answer[i] = Math.max(pick, notPick);
        }

        return answer[answer.length-1];
    }
}
