package Exam_25_June_2022;

import java.util.Scanner;

public class StickyFingers {
    private static int[] position;
    private static int dillingerMoney;
    private static int moves;
    private static char[][] matrix;
    private static boolean isCaught;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String[] commands = scanner.nextLine().split(",");

        matrix = new char[n][n];
        fillMatrix(scanner, n, matrix);

        position = new int[2];
        findDilinger(n, matrix);

        dillingerMoney = 0;
        moves = 0;
        isCaught = false;

        while (moves < commands.length) {
            if(isCaught){
                break;
            }
            String command = commands[moves];
            int colMove = 0;
            int rowMove = 0;
            switch (command) {

                case "left":
                    colMove = -1;
                    if (!validate(colMove, false)) continue;
                    moveDillingerSideways(rowMove, colMove);
                    break;
                case "right":
                    colMove = 1;
                    if (!validate(colMove, false)) continue;
                    moveDillingerSideways(rowMove, colMove);
                    break;
                case "up":
                    rowMove = -1;
                    if (!validate(rowMove, true)) continue;
                    moveDillingerSideways(rowMove, colMove);
                    break;
                case "down":
                    rowMove = 1;
                    if (!validate(rowMove, true)) continue;
                    moveDillingerSideways(rowMove, colMove);
                    break;
            }

            moves++;
        }

        if (!isCaught) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", dillingerMoney);
        }

        printMatrix();

        //Input
        //5
        //up,right,down,down,left
        //+ + + D +
        //+ + + P +
        //+ + + $ +
        //P + + P +
        //+ + $ + +

        //Output
        //You cannot leave the town, there is police outside!
        //You successfully stole 6$.
        //Your last theft has finished successfully with 6$ in your pocket.
        //+ + + + +
        //+ + + P +
        //+ + + D +
        //P + + P +
        //+ + $ + +

        //Input2
        //4
        //right,down,down,left,up,down
        //+ + D $
        //+ + P $
        //+ P $ +
        //+ + + +

        //Output2
        //You successfully stole 0$.
        //You successfully stole 3$.
        //You successfully stole 4$.
        //Your last theft has finished successfully with 7$ in your pocket.
        //+ + + +
        //+ + # +
        //+ P + +
        //+ + + +
    }

    private static void printMatrix() {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static void moveDillingerSideways(int rowMove, int colMove) {
        if (matrix[position[0] + rowMove][position[1] + colMove] == 'P') {
            matrix[position[0]][position[1]] = '+';
            matrix[position[0]+rowMove][position[1] + colMove] = '#';
            isCaught = true;
            System.out.printf("You got caught with %d$, and you are going to jail.%n", dillingerMoney);
            return;
        }
        if (matrix[position[0] + rowMove][position[1] + colMove] == '$') {
            int stolenMoneyFromHouse = (position[0] + rowMove) * (position[1] + colMove);
            dillingerMoney += stolenMoneyFromHouse;
            System.out.printf("You successfully stole %d$.%n", stolenMoneyFromHouse);
        }
        matrix[position[0]][position[1]] = '+';
        matrix[position[0] + rowMove][position[1] + colMove] = 'D';
        position[1] = position[1] + colMove;
        position[0] = position[0] + rowMove;
    }

    private static boolean validate(int singleMove, boolean upDown) {
        boolean isValid = true;
        if (!upDown) {
            if (position[1] + singleMove >= matrix.length || position[1] + singleMove < 0) {
                System.out.println("You cannot leave the town, there is police outside!");
                moves++;
                isValid = false;
            }
        }
        if (upDown) {
            if (position[0] + singleMove >= matrix.length || position[0] + singleMove < 0) {
                System.out.println("You cannot leave the town, there is police outside!");
                moves++;
                isValid = false;
            }
        }


        return isValid;
    }

    private static void findDilinger(int n, char[][] matrix) {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 'D') {
                    position[0] = r;
                    position[1] = c;
                }
            }
        }
    }

    private static void fillMatrix(Scanner scanner, int n, char[][] matrix) {
        for (int r = 0; r < n; r++) {
            String[] str = scanner.nextLine().split(" ");
            for (int c = 0; c < n; c++) {
                matrix[r][c] = str[c].charAt(0);
            }
        }
    }
}
