package WhileLoop.exercises;

import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wight = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int high = Integer.parseInt(scanner.nextLine());
        int space = wight * length * high;
        boolean enough = true;


        String boxes = scanner.nextLine();

        while (!boxes.equals("Done")) {
            int n = Integer.parseInt(boxes);
            space -= n;

            if (space <= 0) {
                enough = false;
                break;
            }


            boxes = scanner.nextLine();
        }

        if (enough) {
            System.out.printf("%d Cubic meters left.", space);

        } else {
            System.out.printf("No more free space! You need %d Cubic meters more.", Math.abs(space) );
        }


    }
}
