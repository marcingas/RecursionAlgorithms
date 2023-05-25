import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
    public static List < List < String >> solutionConstructor(int n) {
        //wypełniamy tabele
        char[][] table = new char[n][n];
        for (int row = 0; row < n; row++)
            for (int column = 0; column < n; column++)
                table[row][column] = '.';
        //inicjalizujemy listę rozwiązań:
        List < List < String >> allSolutions = new ArrayList< List < String >>();
        //wywołujemy metodę szukającą Q: zaczynamy od columny zero, table to nasza tablica w której szukamy  miejsca
        //dla Q a allSolutions to lista w której zapisujemy wszystkie rozwiązania w postaci List<String>
        Queensfinder(0, table, allSolutions);
        return allSolutions;
    }

    static boolean validate(char[][] table, int row, int col) {
        int rowCopy = row;
        int colCopy = col;
        //sprawdzamy czy Q znajduje się po przekątnej w górę jeśli tak to nie zapisujemy Q
        while (row >= 0 && col >= 0) {
            if (table[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = rowCopy;
        col = colCopy;
        //sprawdzamy czy dla danego row Q znajduje się poziomo w lewo w którymś rzędzie
        while (col >= 0) {
            if (table[row][col] == 'Q') return false;
            col--;
        }

        row = rowCopy;
        col = colCopy;
        //sprawdzamy czy Q znajduje się po przekątnej w dół:
        while (col >= 0 && row < table.length) {
            if (table[row][col] == 'Q') return false;
            col--;
            row++;
        }
        return true;
    }
//główne rozwiązanie, zaczynamy od 0 kolumny i sprawdzamy wszytkie wiersze gdzie możemy dodać Q po kolei:
    static void Queensfinder(int col, char[][] table, List < List < String >> allSolutions) {
        if (col == table.length) {
            allSolutions.add(tableToList(table));
            return;
        }
//dla każdej kolumny musimy sprawdzić wszystkie wiersze więc pętla for będzie poruszała się po wierszach:
        //jeśli dane miejsce zostanie sprawdzone że jest ok to dodajemy Q jak dodamy jedno Q do kolumny to
        //przechodzimy do kolejnej kolumny przez funkcję Queensfinder która nas przenosi do kolejnej kolumny jak wyjdziemy
        //z funkcji czyli skończyliśmy kolumnę to usuwamy z naszej tablicy Q żeby nie zaburzyć wyniku.
        //po której znowu iterujemy po wierszach:
        for (int row = 0; row < table.length; row++) {
            if (validate(table, row, col)) {
                table[row][col] = 'Q';
                Queensfinder(col + 1, table, allSolutions);
                table[row][col] = '.';
            }
        }
    }



    static List< String > tableToList(char[][] table) {
        List < String > singleSolution = new LinkedList< String >();
        for (int i = 0; i < table.length; i++) {
            String element = new String(table[i]);
            singleSolution.add(element);
        }
        return singleSolution;
    }

    public static void main(String args[]) {
        int N = 4;
        List < List < String >> queen = solutionConstructor(N);
        int i = 1;
        for (List < String > it: queen) {
            System.out.println("Arrangement " + i);
            for (String s: it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }

    }
}
