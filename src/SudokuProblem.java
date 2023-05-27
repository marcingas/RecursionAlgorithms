public class SudokuProblem {
    public static void main(String[] args) {

    }
    public static boolean solveSudoku(char[][] sudokuTable) {
        for (int row = 0; row < sudokuTable.length; row++) {
            for (int column = 0; column < sudokuTable[row].length; column++) {
                if (sudokuTable[row][column] == '.') {
                    for (char number = '1'; number <= '9'; number++) {
                        if (isValid(sudokuTable, row, column, number)) {
                            sudokuTable[row][column] = number;
                            if (solveSudoku(sudokuTable)) return true;
                            else sudokuTable[row][column] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(char[][] sudokuTable, int row, int column, char number) {
        for (int i = 0; i < 9; i++) {
            if (sudokuTable[i][column]==number) return false;
            if(sudokuTable[row][i]==number)return false;
            if(sudokuTable[3*(row/3)+ i/3][3*(column/3)+ i%3]==number)return false;
        }
        return true;
    }
}
