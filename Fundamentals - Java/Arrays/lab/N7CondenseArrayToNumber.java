package Arrays.lab;

import java.util.Scanner;
import java.util.Arrays;

public class N7CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
String[] stringArray = input.split("\\s+");
int[] intArray = new int[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            intArray[i]= Integer.parseInt(stringArray[i]);
        }



        while(intArray.length>1){

       int[] condensed= new int[intArray.length-1];

            for (int i = 0; i < intArray.length-1 ; i++) {

                condensed[i]=intArray[i] + intArray[i+1];
            }
           // intArray = Arrays.copyOf(condensed, condensed.length);
            // Става и по двата начина!!! - Можем да приравняваме един масив към друг!!!
            // !!! ВАЖНО !!!
                intArray = condensed;
        }

        System.out.println(intArray[0]);
    }
}
