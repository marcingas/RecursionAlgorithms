import java.util.Arrays;

public class FrogJumpDynamic {
    public static void main(String[] args) {
        int[] heightTable = {30, 10, 60, 10, 60, 50};
        int n = heightTable.length;
        int[] solveStorage = new int[n];
        Arrays.fill(solveStorage,-1);
        System.out.println(countFrogJumps(n-1,heightTable,solveStorage));
    }

    public static int countFrogJumps(int index, int[] heightTable, int[] solveStorage) {
        if (index == 0) return 0;
        if (solveStorage[index] != -1) return solveStorage[index];
        int oneJump = countFrogJumps(index - 1, heightTable, solveStorage) +
                Math.abs(heightTable[index] - heightTable[index - 1]);
        int twoJumps = Integer.MAX_VALUE;
        if (index > 1) twoJumps = countFrogJumps(index - 2, heightTable, solveStorage) +
                Math.abs(heightTable[index] - heightTable[index - 2]);
        return solveStorage[index] = Math.min(oneJump, twoJumps);
    }
}
