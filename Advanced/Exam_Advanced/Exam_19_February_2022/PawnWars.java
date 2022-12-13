package Exam_19_February_2022;

import java.util.Scanner;

public class PawnWars {
    private static final char[][] matrix = new char[8][8];
    private static final int[] positionsOfWhitePawn = {0, 0};
    private static final int[] positionsOfBlackPawn = {0, 0};
    private static boolean checkLeftDiagonal = true;
    private static boolean checkRightDiagonal = true;
    private static boolean capturedBlackPawn = false;
    private static boolean capturedWhitePawn = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        fillMatrix(scanner);
        getPawnsPositions();

        boolean whiteQueen = false;
        boolean blackQueen = false;
        while (positionsOfWhitePawn[0] != 0 && positionsOfBlackPawn[0] != matrix.length - 1) {
            checkLeftDiagonal = true;
            checkRightDiagonal = true;

            int whiteNextRowPosition = positionsOfWhitePawn[0] - 1;
            int whiteNextColPosition = positionsOfWhitePawn[1];
            int blackNextRowPosition = positionsOfBlackPawn[0] + 1;
            int blackNextColPosition = positionsOfBlackPawn[1];

            validateCheckLeftOrRight(whiteNextColPosition);
            if (checkIfCanCatchBlackPawn(whiteNextRowPosition, whiteNextColPosition)) break;
            moveWhitePawn(whiteNextRowPosition);

            if (positionsOfWhitePawn[0] == 0) {
                whiteQueen = true;
                break;
            }

            validateCheckLeftOrRight(blackNextColPosition);
            if (checkIfCanCatchWhitePawn(blackNextRowPosition, blackNextColPosition)) break;
            moveBlackPawn(blackNextRowPosition);
            if (positionsOfBlackPawn[0] == matrix.length-1) {
                blackQueen = true;
                break;
            }
        }

        String positionOfCapture;

        if (capturedBlackPawn || capturedWhitePawn) {
            String player = capturedBlackPawn ? "White" : "Black";
            char col = capturedBlackPawn ? (char) (97 + positionsOfWhitePawn[1]): (char) (97 + positionsOfBlackPawn[1]);
            int position = capturedBlackPawn ? positionsOfWhitePawn[0] : positionsOfBlackPawn[0];
            positionOfCapture = String.format("%s%d", col, matrix.length - position);
            System.out.printf("Game over! %s capture on %s.%n",player, positionOfCapture);
        }

        if (whiteQueen || blackQueen) {
            String queen = whiteQueen ? "White" : "Black";
            int colPosition = whiteQueen ? positionsOfWhitePawn[1] : positionsOfBlackPawn[1];
            int rankPosition = whiteQueen ? positionsOfWhitePawn[0] : positionsOfBlackPawn[0];
            char col = (char) (97 + colPosition);
            positionOfCapture = String.format("%s%d", col, matrix.length - rankPosition);
            System.out.printf("Game over! %s pawn is promoted to a queen at %s.%n",queen, positionOfCapture);
        }

    }

    private static void moveBlackPawn(int blackNextRowPosition) {
        matrix[positionsOfBlackPawn[0]][positionsOfBlackPawn[1]] = '-';
        positionsOfBlackPawn[0] = blackNextRowPosition;
        matrix[positionsOfBlackPawn[0]][positionsOfBlackPawn[1]] = 'b';
    }

    private static boolean checkIfCanCatchWhitePawn(int blackNextRowPosition, int blackNextColPosition) {
        if (checkLeftDiagonal) {
            if (matrix[blackNextRowPosition][blackNextColPosition - 1] == 'w') {
                capturedWhitePawn = true;
                positionsOfBlackPawn[0] = blackNextRowPosition;
                positionsOfBlackPawn[1] = blackNextColPosition - 1;
                return true;
            }
        }

        if (checkRightDiagonal) {
            if (matrix[blackNextRowPosition][blackNextColPosition + 1] == 'w') {
                capturedWhitePawn = true;
                positionsOfBlackPawn[0] = blackNextRowPosition;
                positionsOfBlackPawn[1] = blackNextColPosition + 1;
                return true;
            }
        }
        return false;
    }

    private static void moveWhitePawn(int whiteNextRowPosition) {
        matrix[positionsOfWhitePawn[0]][positionsOfWhitePawn[1]] = '-';
        positionsOfWhitePawn[0] = whiteNextRowPosition;
        matrix[positionsOfWhitePawn[0]][positionsOfWhitePawn[1]] = 'w';
    }

    private static boolean checkIfCanCatchBlackPawn(int whiteNextRowPosition, int whiteNextColPosition) {
        if (checkLeftDiagonal) {
            if (matrix[whiteNextRowPosition][whiteNextColPosition - 1] == 'b') {
                capturedBlackPawn = true;
                positionsOfWhitePawn[0] = whiteNextRowPosition;
                positionsOfWhitePawn[1] = whiteNextColPosition - 1;
                return true;
            }
        }

        if (checkRightDiagonal) {
            if (matrix[whiteNextRowPosition][whiteNextColPosition + 1] == 'b') {
                capturedBlackPawn = true;
                positionsOfWhitePawn[0] = whiteNextRowPosition;
                positionsOfWhitePawn[1] = whiteNextColPosition + 1;
                return true;
            }
        }
        return false;
    }

    private static void validateCheckLeftOrRight(int nextColPosition) {
        if (nextColPosition - 1 < 0) {
            checkLeftDiagonal = false;
        }
        if (nextColPosition + 1 >= matrix.length) {
            checkRightDiagonal = false;
        }
    }

    private static void getPawnsPositions() {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                if (matrix[r][c] == 'w') {
                    positionsOfWhitePawn[0] = r;
                    positionsOfWhitePawn[1] = c;
                } else if (matrix[r][c] == 'b') {
                    positionsOfBlackPawn[0] = r;
                    positionsOfBlackPawn[1] = c;
                }
            }
        }
    }

    private static void fillMatrix(Scanner scanner) {
        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = scanner.nextLine().toCharArray();
        }
    }
}
