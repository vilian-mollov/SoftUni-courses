package Exam_22_October_2022;

import java.util.Scanner;

public class RallyRacing {

    private static char[][] matrix;
    private static int[] position = {0, 0};
    private static int[] tunnelPositionOne = {0, 0};
    private static int[] tunnelPositionTwo = {0, 0};
    private static int kilometersPassed = 0;
    private static boolean finished = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine()); // size of square matrix

        int carNumb = Integer.parseInt(scanner.nextLine()); // number of tracked car
        matrix = new char[n][n];
        fillMatrix(scanner, n);
        findTunnels();


        String input = scanner.nextLine();
        while (!input.equals("End")) {
            int yPosition = position[0];
            int xPosition = position[1];

            switch (input) {

                case "up":
                    yPosition--;
                    travelToEmptySquare(yPosition, xPosition);
                    travelThroughTunnelIfReached(yPosition, xPosition);
                    travelToFinishLine(yPosition, xPosition);
                    break;
                case "down":
                    yPosition++;
                    travelToEmptySquare(yPosition, xPosition);
                    travelThroughTunnelIfReached(yPosition, xPosition);
                    travelToFinishLine(yPosition, xPosition);
                    break;
                case "left":
                    xPosition--;
                    travelToEmptySquare(yPosition, xPosition);
                    travelThroughTunnelIfReached(yPosition, xPosition);
                    travelToFinishLine( yPosition, xPosition);
                    break;
                case "right":
                    xPosition++;
                    travelToEmptySquare(yPosition, xPosition);
                    travelThroughTunnelIfReached(yPosition, xPosition);
                    travelToFinishLine( yPosition, xPosition);
                    break;
            }

            if (finished) {
                break;
            }
            input = scanner.nextLine();
        }
        matrix[position[0]][position[1]] = 'C';

        if (finished) {
            System.out.println("Racing car " + carNumb + " finished the stage!");
        } else {
            System.out.println("Racing car " + carNumb + " DNF.");
        }

        System.out.println("Distance covered " + kilometersPassed + " km.");

        printMatrix();

    }

    private static void travelToFinishLine(int yPosition, int xPosition) {
        if (matrix[yPosition][xPosition] == 'F') {
            kilometersPassed += 10;
            position[0] = yPosition;
            position[1] = xPosition;
            finished = true;
        }
    }

    private static void travelToEmptySquare(int yPosition, int xPosition) {
        if (matrix[yPosition][xPosition] == '.') {
            kilometersPassed += 10;
            position[0] = yPosition;
            position[1] = xPosition;
        }
    }

    private static void travelThroughTunnelIfReached(int yPosition, int xPosition) {
        if (matrix[yPosition][xPosition] == 'T') {

            if (yPosition == tunnelPositionOne[0] && xPosition == tunnelPositionOne[1]) {
                //move car to the second tunnel
                //add 30 km
                kilometersPassed += 30;
                position[0] = tunnelPositionTwo[0];
                position[1] = tunnelPositionTwo[1];
                matrix[tunnelPositionOne[0]][tunnelPositionOne[1]] = '.';
                matrix[tunnelPositionTwo[0]][tunnelPositionTwo[1]] = '.';
            }
            if (yPosition == tunnelPositionTwo[0] && xPosition == tunnelPositionTwo[1]) {
                //move car to the first tunnel
                //add 30 km
                kilometersPassed += 30;
                position[0] = tunnelPositionOne[0];
                position[1] = tunnelPositionOne[1];
                matrix[tunnelPositionOne[0]][tunnelPositionOne[1]] = '.';
                matrix[tunnelPositionTwo[0]][tunnelPositionTwo[1]] = '.';
            }

        }
    }

    private static void printMatrix() {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static void findTunnels() {
        boolean firstFound = false;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                if (firstFound && matrix[r][c] == 'T') {
                    tunnelPositionTwo[0] = r;
                    tunnelPositionTwo[1] = c;
                }
                if (!firstFound && matrix[r][c] == 'T') {
                    tunnelPositionOne[0] = r;
                    tunnelPositionOne[1] = c;
                    firstFound = true;
                }
            }
        }


    }

    private static void fillMatrix(Scanner scanner, int n) {
        for (int r = 0; r < n; r++) {
            matrix[r] = scanner.nextLine().replace(" ", "").toCharArray();
        }
    }
}
