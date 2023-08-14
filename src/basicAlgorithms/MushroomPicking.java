package basicAlgorithms;

public class MushroomPicking {
    public static void main(String[] args) {
        int startPosition = 4;
        int maxMoves = 6;
        int[] mushroomsNum = {2, 3, 7, 5, 1, 3, 9};
        System.out.println(pickMaxMushrooms(mushroomsNum, startPosition, maxMoves));

    }

    private static int pickMaxMushrooms(int[] mushroomsNum, int startPosition, int maxMoves) {
        int maxMushrooms = 0;
        for (int moves = 0; moves <= Math.min(maxMoves, startPosition); moves++) {
            int leftPosition = startPosition - moves;
            int rightPosition = Math.min(mushroomsNum.length - 1,
                    Math.max(startPosition, startPosition + maxMoves - 2 * moves));
            maxMushrooms = Math.max(maxMushrooms, SumationInRranges.sumInRanges(leftPosition, rightPosition, mushroomsNum));
        }

        for (int moves = 0; moves <= Math.min(maxMoves, mushroomsNum.length - 1 - startPosition); moves++) {
            int rightPosition = startPosition + moves;
            int leftPosition = Math.max(0, Math.min(startPosition, startPosition - (maxMoves - 2 * moves)));
            maxMushrooms = Math.max(maxMushrooms, SumationInRranges.sumInRanges(leftPosition, rightPosition, mushroomsNum));

        }
        return maxMushrooms;
    }
}
