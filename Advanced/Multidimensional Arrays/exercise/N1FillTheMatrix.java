package MultidimensionalArrays.exercise;

import java.util.Scanner;

public class N1FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] data = input.split(", ");
        int n = Integer.parseInt(data[0]);
        String pattern = data[1];
        int[][] matrix = new int[n][n];
        if(pattern.equals("A")) {
            fillTheMatrixByAVariant(n, matrix);
        }else if(pattern.equals("B")){
            fillTheMatrixByBVariant(n, matrix);
        }
        for (int[] ints : matrix) {
            for (int i : ints) {
                System.out.print(i+" ");
            }
            System.out.println();

        }

    }

    private static void fillTheMatrixByBVariant(int n, int[][] matrix) {
        int number;
        int otherNumber = n + n -1;
        int index = 1;
        for (int row = 0; row < n; row++) {
            number=row;
            number++;
            for (int col = 0; col < n; col++) {
                if(col==0) {
                    matrix[row][col] = number;
                }else{
                    if(col%2==0){
                        matrix[row][col] = matrix[row][col-1]+index;
                    }else{
                        matrix[row][col] = matrix[row][col-1]+otherNumber;
                    }

                }
            }
            otherNumber-=2;
            index+=2;
        }
    }

    private static void fillTheMatrixByAVariant(int n, int[][] matrix) {
        int number;
        for (int row = 0; row < n; row++) {
            number=row;
            number++;
            for (int col = 0; col < n; col++) {
                if(col==0) {
                    matrix[row][col] = number;
                }else{
                    number+= n;
                    matrix[row][col] = number;
                }
            }
        }
    }
}
