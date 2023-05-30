public class LoopPatterns {
    public static void main(String[] args) {


        //pattern 1
        for (int row = 0; row < 5; row++) {
            System.out.print("\n");
            for (int col = 0; col < 5; col++) {
                System.out.print("*");
            }
        }

        //pattern 2
        for (int row = 0; row < 5; row++) {
            System.out.print("\n");
            for (int col = 0; col <= row; col++) {
                System.out.print("*");
            }
        }
        //pattern3

        for (int row = 0; row <= 5; row++) {
            System.out.print("\n");
            for (int col = 1; col <= row; col++) {
                System.out.print(col);
            }
        }
        //pattern 4
        for (int row = 0; row <= 5; row++) {
            System.out.print("\n");
            for (int col = 1; col <= row; col++) {
                System.out.print(row);
            }
        }
        //pattern 5
        int n = 4;
        for (int row = 0; row <= n; row++) {
            System.out.print("\n");
            for (int col = 0; col < n - row + 1; col++) {
                System.out.print("*");
            }
        }
        //pattern 6
        int c = 5;
        for (int row = 0; row <= c; row++) {
            System.out.print("\n");
            for (int col = 1; col < c - row + 1; col++) {
                System.out.print(col);
            }
        }
        //pattern 7:
        int d = 5;
        for (int row = 0; row < d; row++) {
            System.out.print("\n");
            for (int col = 0; col < d - row - 1; col++) {
                System.out.print(" ");
            }
            for (int col = 0; col < 2 * row + 1; col++) {
                System.out.print("*");
            }
            for (int col = 0; col < d - row - 1; col++) {
                System.out.print(" ");
            }
        }
        //pattern 8
        for (int row = 0; row < d; row++) {
            System.out.print("\n");
            for (int col = 0; col < row; col++) {
                System.out.print(" ");
            }
            for (int col = 0; col < 2 * row + 1; col++) {
                System.out.print("*");
            }
            for (int col = 0; col < row; col++) {
                System.out.print(" ");
            }
        }
        //pattern 9
        for (int row = 0; row < d; row++) {
            System.out.print("\n");
            for (int col = 0; col < row; col++) {
                System.out.print(" ");
            }
            for (int col = 0; col < 2 * d - (2 * row + 1); col++) {
                System.out.print("*");
            }
            for (int col = 0; col < row; col++) {
                System.out.print(" ");
            }
        }
        //pattern 10
        for (int row = 0; row < d; row++) {
            System.out.print("\n");
            for (int col = 0; col < d - row - 1; col++) {
                System.out.print(" ");
            }
            for (int col = 0; col < 2 * row + 1; col++) {
                System.out.print("*");
            }
            for (int col = 0; col < d - row - 1; col++) {
                System.out.print(" ");
            }
        }
        for (int row = 0; row < d; row++) {
            System.out.print("\n");
            for (int col = 0; col < row; col++) {
                System.out.print(" ");
            }
            for (int col = 0; col < 2 * d - (2 * row + 1); col++) {
                System.out.print("*");
            }
            for (int col = 0; col < row; col++) {
                System.out.print(" ");
            }
        }
        //pattern 11:
        for (int i = 1; i <= 2 * n - 1; i++) {
            System.out.print("\n");
            int stars = i;
            if (i > n) stars = 2 * n - i;
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
        }
        //pattern 12
        int start = 1;
        for (int row = 0; row < 5; row++) {
            System.out.print("\n");
            if (row % 2 == 0) start = 1;
            else start = 0;
            for (int col = 0; col <= row; col++) {
                System.out.print(start);
                start = 1 - start;
            }
        }
        //pattern 13
        int point = 5;
        int space = 2 * (point - 1);
        for (int row = 1; row < point; row++) {
            System.out.print("\n");
            for (int col = 1; col <= row; col++) {
                System.out.print(col);
            }
            for (int col = 1; col <= space; col++) {
                System.out.print(" ");
            }
            for (int col = row; col >= 1; col--) {
                System.out.print(col);
            }
            space -= 2;
        }
        //pattern 14
        int num = 1;
        for (int row = 0; row <= 5; row++) {
            System.out.print("\n");
            for (int col = 1; col <= row; col++) {
                System.out.print(num);
                num += 1;
            }
        }
        //pattern 15

        for (int row = 0; row <= 5; row++) {
            System.out.print("\n");
            for (char ch = 'A'; ch <= 'A' + row; ch++) {
                System.out.print(ch);

            }
        }
        //pattern 16
        for (int row = 0; row <= 5; row++) {
            System.out.print("\n");
            char ch = (char) ('A' + row);
            for (int col = 0; col <= row; col++) {
                System.out.print(ch);

            }
        }
    }
}
