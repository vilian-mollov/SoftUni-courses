package Arrays.Exercise;

import java.util.Scanner;

public class N6EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbersAsString = scanner.nextLine().split("\\s+");
        int[] numbers = new int[numbersAsString.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsString[i]);
        }
        int leftSum = 0;
        int rightSum = 0;
        int counter=0;
        boolean flag = false;

        for (int theNumber = 0; theNumber < numbers.length; theNumber++) {

            for (int j = 0; j < numbers.length; j++) {

                if (j < theNumber) {
                    leftSum += numbers[j];
                } else if (j == theNumber) {
                } else {
                    rightSum += numbers[j];
                }


            }
            if (leftSum == rightSum) {
                System.out.println(theNumber);
            } else if(counter == numbers.length-1) {
                flag = true;
            }else{
                counter++;
            }

            leftSum = 0;
            rightSum = 0;
        }

        if (flag) {
            System.out.println("no");
        }

    }
}
