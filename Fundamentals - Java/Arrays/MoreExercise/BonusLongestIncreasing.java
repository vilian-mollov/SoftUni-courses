package Arrays.MoreExercise;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Scanner;
import java.util.Arrays;

public class BonusLongestIncreasing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbersAsStrings= scanner.nextLine().split("\\s+");

        int[] numbers = new int[numbersAsStrings.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsStrings[i]);
        }
        boolean ok;
        int longest = 0;
        int current =1;
        int[] holder = new int[200];
        for (int i = 0; i < numbers.length-1; i++) {

            if(numbers[i]<numbers[i+1]){
                current++;
                ok=true;
                if(current>longest){
                    longest=current;
                }
            }else {
                ok = false;
            }
            if(ok){
                int[] newIntArray = new int[current];
                for (int j = 0; j < newIntArray.length; j++) {
                    holder[j] = numbers[i];
                    newIntArray[j]=holder[j];
                    System.out.println(newIntArray[j]);
                }
            }else {
                    current=1;
            }
        }









        for (int n : numbers) {
            System.out.print(n+ " ");
        }


    }

}
