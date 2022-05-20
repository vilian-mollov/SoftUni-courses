package Arrays.lab;

import java.util.Scanner;

public class N4ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        String[] arrayOfString = n.split("\\s+");
int count =1;
        for (int i = 0; i <= (arrayOfString.length - 1) /2; i++) {

            String holder = arrayOfString[i];
            arrayOfString[i]=arrayOfString[arrayOfString.length-count];
            arrayOfString[arrayOfString.length-count]=holder;
            count++;
        }
        for (int i = 0; i <= arrayOfString.length-1 ; i++) {

            System.out.print(arrayOfString[i] + " ");
        }
    }
}
