import java.util.Arrays;

public class FrogJumpDynamic {
    public static void main(String[] args) {
        int[] heightTable = {30, 10, 60, 10, 60, 50};
        int n = heightTable.length;
        int[] solveStorage = new int[n];
        Arrays.fill(solveStorage, -1);
//        1.First solution Recurrence:TC=O(N),SC=O(N)subproblems return answer in time O(1),
//        total number of subproblems = n. Recursion stack space O(N) and Array O(N) O(N)+O(N) =~ O(N)
//        System.out.println(countFrogJumps(n-1,heightTable,solveStorage));
//         2.solution Tabulation: TC=O(N),SC=O(N) simple loop. external array
//        System.out.println(countFrogJumpsTabulation(n,heightTable,solveStorage));
        //3. space optimalization solution:TC=O(N),SC=O(1) simple loop and no extra space
        int previous = 0;
        int previous2 = 0;
        for (int i = 1; i < n; i++) {
            int jumpOne = previous + Math.abs(heightTable[i] - heightTable[i - 1]);
            int twoJumps = Integer.MAX_VALUE;
            if (i > 1) twoJumps = previous2 + Math.abs(heightTable[i] - heightTable[i - 2]);

            int currentIndex = Math.min(jumpOne, twoJumps);
            previous2 = previous;
            previous = currentIndex;
        }
        System.out.println(previous);

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

    public static int countFrogJumpsTabulation(int n, int[] heightTable, int[] solveStorage) {
        solveStorage[0] = 0;
        for (int i = 1; i < n; i++) {
            int jumpOne = solveStorage[i - 1] + Math.abs(heightTable[i] - heightTable[i - 1]);
            int twoJumps = Integer.MAX_VALUE;
            if (i > 1) {
                twoJumps = solveStorage[i - 2] + Math.abs(heightTable[i] - heightTable[i - 2]);
            }
            solveStorage[i] = Math.min(jumpOne, twoJumps);
        }
        return solveStorage[n - 1];
    }
}
