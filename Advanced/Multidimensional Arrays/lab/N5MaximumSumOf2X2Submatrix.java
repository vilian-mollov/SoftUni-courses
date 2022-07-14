package MultidimensionalArrays.lab;

import java.util.Scanner;

public class N5MaximumSumOf2X2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(arr[0]);
        int cols = Integer.parseInt(arr[1]);

        int[][] matrix = readMatrix(scanner, rows, cols);
        int[][] bestMatrix = findMax2X2Submatrix(matrix);
        printResult(bestMatrix);
    }
    public static int[][] readMatrix(Scanner scanner,int rows,int cols){
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            String[] arr = scanner.nextLine().split(", ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(arr[col]);
            }

        }
        return matrix;
    }
    public  static int[][] findMax2X2Submatrix(int[][] matrix){
        int maximum = Integer.MIN_VALUE;
        int [][] bestMatrix = new int[2][2];
        for (int row = 0; row < matrix.length-1; row++) {
            for (int col = 0; col < matrix[row].length -1; col++) {
                int currentPower = 0;
               currentPower = matrix[row][col]+matrix[row][col+1]+matrix[row+1][col]+matrix[row+1][col+1];
               if(currentPower > maximum){
                   maximum = currentPower;
                   bestMatrix[0][0]=matrix[row][col];
                   bestMatrix[0][1]=matrix[row][col+1];
                   bestMatrix[1][0]=matrix[row+1][col];
                   bestMatrix[1][1]=matrix[row+1][col+1];
               }
            }
        }
        return bestMatrix;
    }
    public static void printResult(int[][] bestMatrix){
        int sum = 0;
        for (int row = 0; row < bestMatrix.length; row++) {
            for (int col = 0; col < bestMatrix[row].length; col++) {
                sum+=bestMatrix[row][col];
                System.out.print(bestMatrix[row][col]+" ");
            }
            System.out.println();
        }
        System.out.println(sum);
    }
}
