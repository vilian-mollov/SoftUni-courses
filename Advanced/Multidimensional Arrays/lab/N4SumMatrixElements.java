package MultidimensionalArrays.lab;

import java.util.Scanner;

public class N4SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rowsAndCols = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);

        int[][] matrix = readMatrix(scanner,rows,cols);

        getPrintOutcome(matrix);

    }

    private static void getPrintOutcome(int[][] matrix) {
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        int result =0;
        for (int[] rows : matrix) {
            for (int cols : rows) {
                result+=cols;
            }

        }
        System.out.println(result);

    }

    public  static int[][] readMatrix(Scanner scanner,int rows, int cols){
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            String[] arr = scanner.nextLine().split(", ");
            for (int col = 0; col < matrix[row].length ; col++) {
                matrix[row][col] = Integer.parseInt(arr[col]);
            }
        }
        return matrix;
    }
}
