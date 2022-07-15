package MultidimensionalArrays.lab;

import java.util.Scanner;

public class N3IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        char[][] first = new char[rows][cols];
        for (int row = 0; row < first.length; row++) {
            String s = scanner.nextLine();
            s = s.replaceAll("\\s+","");
            first[row] = s.toCharArray();
        }

        char[][] second = new char[rows][cols];
        for (int row = 0; row < second.length; row++) {
            String st = scanner.nextLine();
            st = st.replaceAll("\\s+","");
            second[row] = st.toCharArray();
        }

        char[][] output = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char firstEl = first[row][col];
                char secondEl = second[row][col];
                char outcome = firstEl == secondEl ? firstEl : '*';
                output[row][col]=outcome;
            }
        }

        for (char[] chars : output) {
            for (char aChar : chars) {
                System.out.print(aChar+" ");
            }
            System.out.println();
        }


    }
}
