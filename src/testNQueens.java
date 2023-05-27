import java.util.List;

public class testNQueens {

    public static void queenSolver(int col, char[][] table, List<char[][]> solution, int[] leftrow,
                                   int[] upperdiagcheck, int[] lowerdiagcheck) {
        if (col == table.length) {
            solution.add(table);
            return;
        }
        for (int row = 0; row < table.length; row++) {
            if (leftrow[row] == 0
                    && upperdiagcheck[table.length-1 + col-row] == 0 && lowerdiagcheck[row+ col] == 0) {


                table[row][col] = 'Q';
                leftrow[row]=1;
                upperdiagcheck[table.length-1+col-row]=1;
                lowerdiagcheck[row+col]=1;

                queenSolver(col + 1, table, solution, leftrow, upperdiagcheck, lowerdiagcheck);
                table[row][col] = '.';
                leftrow[row]=0;
                upperdiagcheck[table.length-1+col-row]=0;
                lowerdiagcheck[row+col]=0;
            }
        }
    }
}
