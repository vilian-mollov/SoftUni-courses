package MultidimensionalArrays.lab;

import java.util.Scanner;

public class N1CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

       // printMatrix(firstMatrix);
       // printMatrix(secondMatrix);
       boolean isEqual = compareMatrixes(firstMatrix,secondMatrix);
       if(isEqual){
           System.out.println("equal");
       }else{
           System.out.println("not equal");
       }

    }
    public static int[][] readMatrix(Scanner scanner){
        String[] dimensions = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);


        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col]=Integer.parseInt(input[col]);
            }

        }


        return matrix;
    }

    public static void printMatrix(int[][] matrix){

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }


    }
    public static boolean compareMatrixes(int[][] firstMatrix, int[][] secondMatrix){
        if(firstMatrix.length != secondMatrix.length){
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
                if(firstMatrix[row].length!=secondMatrix[row].length){
                    return false;
                }
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int cols = 0; cols < firstMatrix[row].length; cols++) {
                if(firstMatrix[row][cols] != (secondMatrix[row][cols])){
                    return false;
                }
            }
        }




        return  true;
    }
}
