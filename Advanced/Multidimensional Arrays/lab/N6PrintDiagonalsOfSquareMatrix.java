package MultidimensionalArrays.lab;

import java.util.Scanner;

public class N6PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(scanner,n);
        String firstDiagonal = findDiagonal(matrix);
        String secondDiagonal = findSecondDiagonal(matrix);
        System.out.println(firstDiagonal);
        System.out.println(secondDiagonal);


    }

    private static String findSecondDiagonal(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        int diagonal = 0;
        for (int row = matrix.length-1; row >= 0 ; row--) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(col == diagonal){
                    sb.append(matrix[row][diagonal]+" ");
                }
            }
            diagonal++;
        }
        return String.format(sb.toString());
    }

    private static String findDiagonal(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        int diagonal =0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(col == diagonal){
                    sb.append(matrix[row][diagonal]+" ");
                }
            }
            diagonal++;
        }
        return String.format(sb.toString());
    }

    public static int[][] readMatrix(Scanner scanner,int n){
        int[][] matrix = new int[n][n];
        for (int row = 0; row < matrix.length; row++) {
            String[] arr = scanner.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col]=Integer.parseInt(arr[col]);
            }
        }
        return matrix;
    }
}
