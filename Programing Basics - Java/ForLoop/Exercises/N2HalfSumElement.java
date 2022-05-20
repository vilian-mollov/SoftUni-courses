package ForLoop.Exercises;

import java.util.Scanner;

public class N2HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        int max= Integer.MIN_VALUE;
        int wholeNumbers = 0;



        for (int i = 1; i <= count; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            if(number > max){
                max = number;
            }
            wholeNumbers += number;


        }

        wholeNumbers -= max;

        if(wholeNumbers == max){
            System.out.println("Yes");
            System.out.printf("Sum = %d",max);

        }else {
            System.out.println("No");
            System.out.printf("Diff = %d", Math.abs(wholeNumbers-max));

        }





    }
}
