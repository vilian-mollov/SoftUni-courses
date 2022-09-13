package MultidimensionalArrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class N4MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];

        int[][] matrix = new int[rows][cols];
        fillTheMatrix(scanner, rows, cols, matrix);


        int[][] bestMatrix = new int[3][3];
        int start = 0;
        int end = 0;
        int fist = 0;
        int second = 0;
        int third = 0;

        int sumOfBestMatrix = Integer.MIN_VALUE;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (c + 2 >= cols) {
                    break;
                }
                if (r + 2 >= rows) {
                    break;
                }
                int sum = 0;
                sum += matrix[r][c] + matrix[r][c + 1] + matrix[r][c + 2];
                sum += matrix[r + 1][c] + matrix[r + 1][c + 1] + matrix[r + 1][c + 2];
                sum += matrix[r + 2][c] + matrix[r + 2][c + 1] + matrix[r + 2][c + 2];
                if (sum >= sumOfBestMatrix) {
                    sumOfBestMatrix = sum;

                    int[][] best = new int[][]{
                            {matrix[r][c], matrix[r][c + 1], matrix[r][c + 2]},
                            {matrix[r+1][c], matrix[r+1][c + 1], matrix[r+1][c + 2]},
                            {matrix[r+2][c], matrix[r+2][c + 1], matrix[r+2][c + 2]}
                    };
                  bestMatrix = best;

                }
            }

        }

        System.out.println("Sum = " + sumOfBestMatrix);

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                System.out.print(bestMatrix[r][c] + " ");
            }
            System.out.println();
        }

    }

    private static void fillTheMatrix(Scanner scanner, int rows, int cols, int[][] matrix) {
        for (int r = 0; r < rows; r++) {
            int[] data = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            for (int c = 0; c < cols; c++) {
                matrix[r][c] = data[c];
            }
        }
    }
}
