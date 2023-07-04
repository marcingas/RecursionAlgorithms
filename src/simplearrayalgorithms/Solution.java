package simplearrayalgorithms;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
int n = 1041;
        System.out.println(solution(n));
    }
    public static int solution(int N) {
        int ans = 0;
        String binary = Integer.toBinaryString(N);
        int[] temp = new int[binary.length()];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = Character.getNumericValue(binary.charAt(i));
        }
        System.out.println(Arrays.toString(temp));

        int max = 0;
        int count = 0;

        for (int i = 1; i < temp.length - 1; i++) {
            if (temp[i] == 0 && temp[i - 1] == 1) {
                count++;
                max = Math.max(max, count);
            } else if(temp[i]==1 && temp[i-1]==0){
                count = 0;
            }else{
                return 0;
            }

        }
        return max;
    }
}
