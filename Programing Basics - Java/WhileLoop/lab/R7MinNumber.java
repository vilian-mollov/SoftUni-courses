package WhileLoop.lab;

import java.util.Scanner;

public class R7MinNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int min = Integer.MAX_VALUE;
        String text = scanner.nextLine();

        while (!text.equals("Stop")){

            int number = Integer.parseInt(text);

            if(number < min){
                min = number;
            }


            text = scanner.nextLine();


        }
        System.out.println(min);
    }
}
