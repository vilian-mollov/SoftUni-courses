package Exam_13_April_2022;

import java.util.Scanner;

public class Armory {

    private static char[][] matrix;
    private static final int[] position = {0, 0};
    private static final int[] mirrorPositionFirst = {0, 0};
    private static final int[] mirrorPositionSecond = {0, 0};
    private static boolean outOfArmory = false;
    private static int kingPaidGold = 0;



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        matrix = new char[n][n];

        fillTheMatrix(scanner, n);
        findArmyOfficer();
        findMirrors();

        String input = scanner.nextLine();

        while (true) {

            int yPosition = position[0];
            int xPosition = position[1];

            switch (input) {
                case "up":
                    yPosition--;
                    if (validate(yPosition)) break;
                    if (teleportingIfReachedMirrors(yPosition, xPosition)) break;
                    movingAndCollectingGold(yPosition, xPosition);
                    break;
                case "down":
                    yPosition++;
                    if (validate(yPosition)) break;
                    if (teleportingIfReachedMirrors(yPosition, xPosition)) break;
                    movingAndCollectingGold(yPosition, xPosition);
                    break;
                case "left":
                    xPosition--;
                    if (validate(xPosition)) break;
                    if (teleportingIfReachedMirrors(yPosition, xPosition)) break;
                    movingAndCollectingGold(yPosition, xPosition);
                    break;
                case "right":
                    xPosition++;
                    if (validate(xPosition)) break;
                    if (teleportingIfReachedMirrors(position[0], position[1] + 1)) break;
                    movingAndCollectingGold(yPosition, xPosition);
                    break;
            }

            if (kingPaidGold >= 65 || outOfArmory) {
                break;
            }

            input = scanner.nextLine();
        }

        if (!outOfArmory) {
            matrix[position[0]][position[1]] = 'A';
        } else {
            System.out.println("I do not need more swords!");
        }
        if (kingPaidGold >= 65) {
            System.out.println("Very nice swords, I will come back for more!");
        }

        System.out.println("The king paid " + kingPaidGold + " gold coins.");

        printMatrix();

    }

    private static boolean teleportingIfReachedMirrors(int yPosition, int xPosition) {
        if (matrix[yPosition][xPosition] == 'M') {
            if (yPosition == mirrorPositionFirst[0] && xPosition == mirrorPositionFirst[1]) {
                matrix[mirrorPositionSecond[0]][mirrorPositionSecond[1]] = '-';
                matrix[mirrorPositionFirst[0]][mirrorPositionFirst[1]] = '-';
                position[0] = mirrorPositionSecond[0];
                position[1] = mirrorPositionSecond[1];

            } else if (yPosition == mirrorPositionSecond[0] && xPosition == mirrorPositionSecond[1]) {
                matrix[mirrorPositionSecond[0]][mirrorPositionSecond[1]] = '-';
                matrix[mirrorPositionFirst[0]][mirrorPositionFirst[1]] = '-';
                position[0] = mirrorPositionFirst[0];
                position[1] = mirrorPositionFirst[1];
            }
            return true;
        }
        return false;
    }

    private static void movingAndCollectingGold(int yPosition, int xPosition) {
        if (matrix[yPosition][xPosition] != '-') {
            kingPaidGold += matrix[yPosition][xPosition] - 48;
            matrix[yPosition][xPosition] = '-';
        }
        position[0] = yPosition;
        position[1] = xPosition;
    }

    private static boolean validate(int position) {
        if (position >= matrix.length || position < 0) {
            outOfArmory = true;
            return true;
        }
        return false;
    }

    private static void printMatrix() {
        for (char[] chars : matrix) {
            for (int c = 0; c < matrix.length; c++) {
                System.out.print(chars[c]);
            }
            System.out.println();
        }
    }

    private static void findArmyOfficer() {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                if (matrix[r][c] == 'A') {
                    position[0] = r;
                    position[1] = c;
                    matrix[r][c] = '-';
                    return;
                }
            }
        }
    }

    private static void fillTheMatrix(Scanner scanner, int n) {
        for (int r = 0; r < n; r++) {
            matrix[r] = scanner.nextLine().replace(" ", "").toCharArray();
        }
    }

    private static void findMirrors() {
        boolean firstFound = false;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                if (firstFound && matrix[r][c] == 'M') {
                    mirrorPositionSecond[0] = r;
                    mirrorPositionSecond[1] = c;
                }
                if (!firstFound && matrix[r][c] == 'M') {
                    mirrorPositionFirst[0] = r;
                    mirrorPositionFirst[1] = c;
                    firstFound = true;
                }
            }
        }
    }
}
