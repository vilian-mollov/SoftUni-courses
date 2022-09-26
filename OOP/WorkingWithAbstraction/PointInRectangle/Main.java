package WorkingWithAbstraction.PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] coordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Point bottomLeft = getPointCoordinatesOfRectangle(coordinates, 0, 1);

        Point topRight = getPointCoordinatesOfRectangle(coordinates, 2, 3);

        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            Point test = getPointToTest(scanner);
            System.out.println(rectangle.contains(test));
        }


    }

    private static Point getPointToTest(Scanner scanner) {
        int[] pointToTest = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int x = pointToTest[0];
        int y = pointToTest[1];

        return new Point(x, y);
    }

    private static Point getPointCoordinatesOfRectangle(int[] coordinates, int x, int y) {
        int pointX = coordinates[x];
        int pointY = coordinates[y];
        return new Point(pointX, pointY);
    }
}
