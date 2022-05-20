package Arrays.Exercise;

import java.util.Scanner;

public class N9ArrayModifier {
    public static void main(String[] args) {
//use long not int
        Scanner scanner = new Scanner(System.in);
        String[] numbersAsString = scanner.nextLine().split(" ");
        //"23" "-2" "321" "87" "42" "90" "-123"
        long[] numbers =new long[numbersAsString.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i]=Integer.parseInt(numbersAsString[i]);
        }//23 -2 321 87 42 90 -123
String secondInput = scanner.nextLine();

        while(!secondInput.equals("end")){
            String[] testAction = secondInput.split(" ");
            // "swap" "1" "3"
            switch(testAction[0]){
                case "swap":
                    int[] theTwoNumbers = new int[testAction.length-1];
                    for (int i = 1; i < testAction.length; i++) {
                        theTwoNumbers[i-1]=Integer.parseInt(testAction[i]);
                    }
                    long firstNumber = numbers[theTwoNumbers[0]];
                    numbers[theTwoNumbers[0]]=numbers[theTwoNumbers[1]];
                    numbers[theTwoNumbers[1]]=firstNumber;
                    break;

                case "multiply":
                    int[] theTwoNumbersMultiply = new int[testAction.length-1];
                    for (int i = 1; i < testAction.length; i++) {
                        theTwoNumbersMultiply[i-1]=Integer.parseInt(testAction[i]);
                    }
                    numbers[theTwoNumbersMultiply[0]] = numbers[theTwoNumbersMultiply[0]]*numbers[theTwoNumbersMultiply[1]];


                    break;
                case "decrease":
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] -= 1;
                    }
                    break;

            }
            secondInput=scanner.nextLine();
        }
String[] finalStringArr = new String[numbers.length];
        for (int i = 0; i < finalStringArr.length; i++) {
            if(i== finalStringArr.length-1){
                finalStringArr[i]= numbers[i]+"";
                break;
            }
            finalStringArr[i]= numbers[i]+", ";
        }
        for (String s : finalStringArr) {
            System.out.print(s);
        }


    }
}
