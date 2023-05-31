import java.util.Arrays;

public class FrogJumpN {
    public static void main(String[] args) {
        int[] heightTable = {30, 10, 60, 10, 60, 50};
        int n = heightTable.length;
        int[] solveStorage = new int[n];
        int stepsAllowed = 2;
        Arrays.fill(solveStorage, -1);
        System.out.println(countFrogJumpsEnergyN(n - 1, heightTable, solveStorage, stepsAllowed));
        Arrays.fill(solveStorage, -1);
        System.out.println(countFrogJumpsEnergyNTabulation(n,heightTable,solveStorage,stepsAllowed));

    }

    public static int countFrogJumpsEnergyN(int index, int[] heightTable, int[] solveStorage, int stepsAllowed) {
        if (index == 0) return 0;
        if (solveStorage[index] != -1) return solveStorage[index];

        int minJumpsEnergy = Integer.MAX_VALUE;
        for (int i = 1; i <= stepsAllowed; i++) {
            if (index - i >= 0) {
                int jumpsEnergy = countFrogJumpsEnergyN(index - i, heightTable, solveStorage, stepsAllowed) +
                        Math.abs(heightTable[index] - heightTable[index - i]);
                minJumpsEnergy = Math.min(jumpsEnergy, minJumpsEnergy);
            }
        }
        return solveStorage[index] = minJumpsEnergy;
    }

    public static int countFrogJumpsEnergyNTabulation(int n, int[] heightTable, int[] solveStorage, int stepsAllowed) {
        solveStorage[0] = 0;
        for (int j = 1; j < solveStorage.length; j++) {

            int minJumpsEnergy = Integer.MAX_VALUE;
            for (int i = 1; i <= stepsAllowed; i++) {
                if (j - i >= 0) {
                    int jumpsEnergy = solveStorage[j-i] +
                            Math.abs(heightTable[j] - heightTable[j - i]);
                    minJumpsEnergy = Math.min(jumpsEnergy, minJumpsEnergy);
                }
            }
            solveStorage[j]= minJumpsEnergy;
        }
        return solveStorage[n-1];
    }
}
