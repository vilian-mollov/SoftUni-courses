package MultidimensionalArrays.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class N2PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);

        int number = Integer.parseInt(scanner.nextLine());
       // boolean cantFoundTheNumber = true;
        List<String> outputs = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == number){
                    //System.out.println(row+" "+col);
                    outputs.add(row+" "+col);
                    //cantFoundTheNumber=false;
                }
            }
        }
       String output = print(outputs);
        System.out.println(output);
//        if(cantFoundTheNumber){
//            System.out.println("not found");
//        }

    }
    public static String print(List<String> outputs){
        return outputs.isEmpty() ?"not found":String.join(System.lineSeparator(),outputs);
    }
    public static int[][] readMatrix(Scanner scanner){
        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] arr= Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row]=arr;
        }



        return  matrix;
    }
}
