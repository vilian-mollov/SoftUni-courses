package Exam_18_August_2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
    private static char[][] matrix;
    private static long[] position;
    private static List<String> path;
    private static boolean onTreasure = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = dimensions[0];
        int m = dimensions[1];

        matrix = new char[n][];
        fillTheMatrix(scanner, n, matrix);
        position = new long[]{0, 0};
        getYourPosition(n, m);

        path = new ArrayList<>();

        String command = scanner.nextLine();

        while (!command.equals("Finish")) {
            long moveUpDown;
            long moveLeftRight;
            int upDown;
            int leftRight;
            switch (command) {

                case "up":
                    moveUpDown = position[0] - 1;
                    moveLeftRight = position[1];
                    if (moveUpDown < 0) {
                        command = scanner.nextLine();
                        continue;
                    }
                     upDown = (int)moveUpDown;
                     leftRight = (int)moveLeftRight;

                    moveUP_Or_Down(command, upDown, leftRight);
                    break;

                case "down":
                    moveUpDown = position[0] + 1;
                    moveLeftRight = position[1];

                    if (moveUpDown >= n) {
                        command = scanner.nextLine();
                        continue;
                    }
                     upDown = (int)moveUpDown;
                     leftRight = (int)moveLeftRight;

                    moveUP_Or_Down(command, upDown, leftRight);

                    break;
                case "left":
                    moveUpDown = position[0];
                    moveLeftRight = position[1] - 1;
                    if (moveLeftRight < 0) {
                        command = scanner.nextLine();
                        continue;
                    }
                    upDown = (int)moveUpDown;
                    leftRight = (int)moveLeftRight;

                    moveLeftOrRight(command, upDown, leftRight);

                    break;
                case "right":
                    moveUpDown = position[0];
                    upDown = (int)moveUpDown;
                    moveLeftRight = position[1] + 1;
                    if (moveLeftRight >= matrix[upDown].length) {
                        command = scanner.nextLine();
                        continue;
                    }

                    upDown = (int)moveUpDown;
                    leftRight = (int)moveLeftRight;

                    moveLeftOrRight(command, upDown, leftRight);

                    break;
            }

            command = scanner.nextLine();
        }

        if (onTreasure) {
            System.out.println("I've found the treasure!");
            System.out.print("The right path is ");
                for (int i = 0; i < path.size(); i++) {
                    if (i == path.size() - 1) {
                        System.out.println(path.get(i));
                        break;
                    }
                    System.out.print(path.get(i) + ", ");
                }

        } else {
            System.out.println("The map is fake!");
        }


    }

    private static void moveLeftOrRight(String command, int moveUpDown, int moveLeftRight) {
        if(matrix[moveUpDown][moveLeftRight] == 'T'){
            return;
        }
        if (matrix[moveUpDown][moveLeftRight] == 'X') {
            onTreasure = true;
            path.add(command);
            position[1] = moveLeftRight;
        }
        if (matrix[moveUpDown][moveLeftRight] == '-') {
            onTreasure = false;
            path.add(command);
            position[1] = moveLeftRight;
        }
    }

    private static void moveUP_Or_Down(String command, int moveUpDown, int moveLeftRight) {
        if(matrix[moveUpDown][moveLeftRight] == 'T'){
            return;
        }
        if (matrix[moveUpDown][moveLeftRight] == 'X') {
            onTreasure = true;
            path.add(command);
            position[0] = moveUpDown;
        }

        if (matrix[moveUpDown][moveLeftRight] == '-') {
            onTreasure = false;
            path.add(command);
            position[0] = moveUpDown;
        }
    }

    private static void getYourPosition(int n, int m) {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (matrix[r][c] == 'Y') {
                    position[0] = r;
                    position[1] = c;
                }
            }
        }
    }

    private static void fillTheMatrix(Scanner scanner, int n, char[][] matrix) {
        for (int r = 0; r < n; r++) {
           matrix[r] = scanner.nextLine().replace(" ", "").toCharArray();
        }
    }
}
