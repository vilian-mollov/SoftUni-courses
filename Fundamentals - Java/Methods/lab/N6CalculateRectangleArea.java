package Methods.lab;

import java.util.Scanner;

public class N6CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());

       int area = calculatingRectangleArea(width,length);
        System.out.println(area);
    }

    private static int calculatingRectangleArea(int width, int length) {
       int area=width*length;
        return area;
    }
}
