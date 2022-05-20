package Arrays.Exercise;

import java.util.Scanner;

public class N8MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
String[] numbersAsString = scanner.nextLine().split(" ");
int[] numbersArr = new int[numbersAsString.length];
//1 7 6 2 19 23
        for (int i = 0; i < numbersArr.length; i++) {
            numbersArr[i]= Integer.parseInt(numbersAsString[i]);
        }

        int magicalNumber = Integer.parseInt(scanner.nextLine());
//8

//HERE - Problem with second for() cycle??
        for (int theNumberIndex = 0; theNumberIndex < numbersArr.length; theNumberIndex++) {//5

            for (int secondNumber = theNumberIndex+1; secondNumber <= numbersArr.length; secondNumber++) {//6  arr[]=6 false
                if(secondNumber==0||secondNumber==numbersArr.length+1||secondNumber==numbersArr.length){
continue;
                }
                if(numbersArr[theNumberIndex]+numbersArr[secondNumber]==magicalNumber){
                    System.out.print(numbersArr[theNumberIndex]+" ");
                    System.out.println(numbersArr[secondNumber]);

                }

            }
        }
    }
}
