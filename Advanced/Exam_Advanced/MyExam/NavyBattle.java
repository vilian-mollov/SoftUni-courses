package MyExam;

import java.util.Scanner;

public class NavyBattle {
    private static char[][] matrix;
    private static final int[] positionOfSubmarine = {0, 0};
    private static int health = 3;
    private static int targetDestroyed = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        matrix = new char[n][n];
        fillMatrix(scanner, n);
        findPositionOfSubmarine();

        String command = scanner.nextLine();
        while (true) {
            int row = positionOfSubmarine[0];
            int col = positionOfSubmarine[1];

            switch (command) {
                case "up":
                    row--;
                    moveSubmarineInsideTheField(row, col);
                    break;
                case "down":
                    row++;
                    moveSubmarineInsideTheField(row, col);
                    break;
                case "left":
                    col--;
                    moveSubmarineInsideTheField(row, col);
                    break;
                case "right":
                    col++;
                    moveSubmarineInsideTheField(row, col);
                    break;

            }

            if (health <= 0) {
                break;
            }
            if(targetDestroyed >= 3){
                break;
            }

            command = scanner.nextLine();
        }

        if(health <= 0){
            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n",positionOfSubmarine[0],positionOfSubmarine[1]);
        }

        if(targetDestroyed >= 3){
            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
        }

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }

    }

    private static void moveSubmarineInsideTheField(int row, int col) {
        if (matrix[row][col] == '*') {
            health--;
            matrix[positionOfSubmarine[0]][positionOfSubmarine[1]] = '-';
            positionOfSubmarine[0] = row;
            positionOfSubmarine[1] = col;
            matrix[positionOfSubmarine[0]][positionOfSubmarine[1]] = 'S';
        } else if (matrix[row][col] == 'C') {
            targetDestroyed++;
            matrix[positionOfSubmarine[0]][positionOfSubmarine[1]] = '-';
            positionOfSubmarine[0] = row;
            positionOfSubmarine[1] = col;
            matrix[positionOfSubmarine[0]][positionOfSubmarine[1]] = 'S';
        } else if (matrix[row][col] == '-') {
            matrix[positionOfSubmarine[0]][positionOfSubmarine[1]] = '-';
            positionOfSubmarine[0] = row;
            positionOfSubmarine[1] = col;
            matrix[positionOfSubmarine[0]][positionOfSubmarine[1]] = 'S';
        }
    }

    private static void findPositionOfSubmarine() {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                if (matrix[r][c] == 'S') {
                    positionOfSubmarine[0] = r;
                    positionOfSubmarine[1] = c;
                    return;
                }
            }
        }
    }

    private static void fillMatrix(Scanner scanner, int n) {
        for (int r = 0; r < n; r++) {
            matrix[r] = scanner.nextLine().toCharArray();
        }
    }
}
