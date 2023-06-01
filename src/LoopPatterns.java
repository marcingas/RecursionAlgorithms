public class LoopPatterns {
    public static void main(String[] args) {


        //pattern 1
        System.out.println("1");
        for (int row = 0; row < 5; row++) {
            System.out.print("\n");
            for (int col = 0; col < 5; col++) {
                System.out.print("*");
            }
        }

        //pattern 2
        System.out.println("2");
        for (int row = 0; row < 5; row++) {
            System.out.print("\n");
            for (int col = 0; col <= row; col++) {
                System.out.print("*");
            }
        }
        //pattern3
        System.out.println("3");
        for (int row = 0; row <= 5; row++) {
            System.out.print("\n");
            for (int col = 1; col <= row; col++) {
                System.out.print(col);
            }
        }
        //pattern 4
        System.out.println("4");
        for (int row = 0; row <= 5; row++) {
            System.out.print("\n");
            for (int col = 1; col <= row; col++) {
                System.out.print(row);
            }
        }
        //pattern 5
        System.out.println("5");
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
        System.out.println("\n8 \n");

        n = 5;
        for (int row = 0; row < n; row++) {
            System.out.print("\n");
            //blank  0 5 0 9
            //       1 5 2 7
            //       2 5 4 5
            //       3 5 6 3
            for (int col = 0; col < n - row - 1; col++) {
                System.out.print(" ");
            }
            //star
            for (int col = 0; col < 2 * row + 1; col++) {
                System.out.print("*");
            }

            //blank
            for (int col = 0; col < n - row - 1; col++) {
                System.out.print(" ");
            }
        }
        for (int row = 0; row < n; row++) {
            System.out.print("\n");

            //blank  0 5
            //       1 5
            //       2 5
            //       3 5
            for (int col = 0; col < row +1; col++) {
                System.out.print(" ");
            }
            //star 7,5,3,1,
            for (int col = 0; col < 2*n - (2*row+3); col++) {
                System.out.print("*");
            }

            //blank
            for (int col = 0; col < row +1; col++) {
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
        System.out.println("10");
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
        //pattern 17
        for (int row = 0; row < n; row++) {
            System.out.print("\n");
            for (int col = 0; col < n; col++) {
                if (row == 0 || col == 0 || row == n - 1 || col == n - 1) {
                    System.out.print("*");
                }else System.out.print(" ");


            }
        }
        //pattern 18
         n = 4;
        num = 1;
//2*n-1
//        int [][]arr = new int[2*n-1][2*n-1];
        for (int row = 0; row < 2*n-1; row++) {
            System.out.print("\n");
            for (int col = 0; col < 2*n-1; col++) {
                int top = row;
                int left = col;
                int right = (2*n - 2) - col;
                int down = (2*n- 2) - row;
//                arr[row][col] =(n - Math.min(Math.min(top, down), Math.min(right, left)));
                System.out.print(n - Math.min(Math.min(top, down), Math.min(right, left)));
            }
        }
    }
}
