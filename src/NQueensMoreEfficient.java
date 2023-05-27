import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueensMoreEfficient {
    public static List<List<String>> solutionConstructor(int n) {
        //wypełniamy tabele
        char[][] table = new char[n][n];
        for (int row = 0; row < n; row++)
            for (int column = 0; column < n; column++)
                table[row][column] = '.';
        //inicjalizujemy listę rozwiązań:
        List<List<String>> allSolutions = new ArrayList<List<String>>();
        int[] leftRowChecker = new int[n];
        int[] upperDiagonalCheck = new int[2 * n - 1];
        int[] lowerDiagonalCheck = new int[2 * n - 1];
        Queensfinder(0, table, allSolutions, leftRowChecker, upperDiagonalCheck, lowerDiagonalCheck);
        return allSolutions;
    }


    //główne rozwiązanie, zaczynamy od 0 kolumny i sprawdzamy wszytkie wiersze gdzie możemy dodać Q po kolei:
    static void Queensfinder(int col, char[][] table, List<List<String>> allSolutions,
                             int[] leftRow, int[] upperDiagCheck, int[] lowerDiagCheck) {

        if (col == table.length) {
            allSolutions.add(tableToList(table));
            return;
        }

        for (int row = 0; row < table.length; row++) {

            if (leftRow[row] == 0 && lowerDiagCheck[row + col] == 0 && upperDiagCheck[table.length - 1 + col - row] == 0) {
                table[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagCheck[row + col] = 1;
                upperDiagCheck[table.length - 1 + col - row] = 1;
                Queensfinder(col + 1, table, allSolutions, leftRow, upperDiagCheck, lowerDiagCheck);
                table[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagCheck[row + col] = 0;
                upperDiagCheck[table.length - 1 + col - row] = 0;
            }
        }
    }


    static List<String> tableToList(char[][] table) {
        List<String> singleSolution = new LinkedList<String>();
        for (int i = 0; i < table.length; i++) {
            String element = new String(table[i]);
            singleSolution.add(element);
        }
        return singleSolution;
    }

    public static void main(String args[]) {
        int N = 4;
        List<List<String>> queen = solutionConstructor(N);
        int i = 1;
        for (List<String> it : queen) {
            System.out.println("Arrangement " + i);
            for (String s : it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }

    }
}
