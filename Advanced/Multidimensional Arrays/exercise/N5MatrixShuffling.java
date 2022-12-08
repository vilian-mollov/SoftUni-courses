package MultidimensionalArrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class N5MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int row = rowsAndCols[0];
        int col = rowsAndCols[1];

        String[][] matrix = new String[row][col];

        fillMatrix(scanner, matrix, row, col);

        String commandInput = scanner.nextLine();

        while (!commandInput.equals("END")) {
            String[] data = commandInput.split("\\s+");

            if (!validation(data, row, col)) {
                System.out.println("Invalid input!");
                commandInput = scanner.nextLine();
                continue;
            }

            String command = data[0];
            int firstRow = Integer.parseInt(data[1]);
            int firstCol = Integer.parseInt(data[2]);
            int secondRow = Integer.parseInt(data[3]);
            int secondCol = Integer.parseInt(data[4]);

            swapValues(matrix, firstRow, firstCol, secondRow, secondCol);

            printMatrix(matrix);

            commandInput = scanner.nextLine();
        }

        //Input:
        //2 3
        //1 2 3
        //4 5 6
        //swap 0 0 1 1
        //swap 10 9 8 7
        //swap 0 1 1 0
        //END

        //Output:
        //5 2 3
        //4 1 6
        //Invalid input!
        //5 4 3
        //2 1 6

        //Input2:
        //1 2
        //Hello World
        //0 0 0 1
        //swap 0 0 0 1
        //swap 0 1 0 0
        //END

        //Output2:
        //Invalid input!
        //World Hello
        //Hello World
    }

    private static void printMatrix(String[][] matrix){

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }

    }

    private static void swapValues(String[][] matrix, int firstRow, int firstCol, int secondRow, int secondCol) {
        String temp = matrix[firstRow][firstCol];
        matrix[firstRow][firstCol] = matrix[secondRow][secondCol];
        matrix[secondRow][secondCol] = temp;
    }

    private static boolean validation(String[] data, int row, int col) {
        if (data.length < 5) {
            return false;
        }
        if (!data[0].equals("swap")) {
            return false;
        }

        int firstRow;
        int firstCol;
        int secondRow;
        int secondCol;

        try {
            firstRow = Integer.parseInt(data[1]);
            firstCol = Integer.parseInt(data[2]);
            secondRow = Integer.parseInt(data[3]);
            secondCol = Integer.parseInt(data[4]);
        } catch (NumberFormatException ignored) {
            return false;
        }

        if (firstRow > row || firstRow < 0) {
            return false;
        }
        if (firstCol > col || firstCol < 0) {
            return false;
        }
        if (secondRow > row || secondRow < 0) {
            return false;
        }
        if (secondCol > col || secondCol < 0) {
            return false;
        }

        return true;
    }

    private static void fillMatrix(Scanner scanner, String[][] matrix, int row, int col) {

        for (int r = 0; r < row; r++) {
            String[] arr = scanner.nextLine().split("\\s+");
            for (int c = 0; c < col; c++) {
                matrix[r][c] = arr[c];
            }
        }

    }
}
