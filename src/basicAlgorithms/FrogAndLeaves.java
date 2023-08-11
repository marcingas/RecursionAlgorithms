package basicAlgorithms;

public class FrogAndLeaves {
    public static void main(String[] args) {
        int destination = 5;
        int numOfDropingLeaves = 8;
        int[] orderOfFalling = {1, 3, 1, 4, 2, 3, 5, 4};
        System.out.println(countWhen(destination, numOfDropingLeaves, orderOfFalling));
    }

    public static int countWhen(int dest, int numOfDrop, int[] order) {
        int ans = -1;
        int[] count = new int[dest + 1];
        for (int i = 0; i < numOfDrop; i++) {
            if (count[order[i]] == 0)
                dest--;
            if (dest == 0) {
                ans = i + 1;
                break;
            }
            count[order[i]] = 1;

        }
        return ans;
    }

}
