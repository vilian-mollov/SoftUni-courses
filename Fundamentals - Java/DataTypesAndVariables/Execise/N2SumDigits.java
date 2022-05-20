package DataTypesAndVariables.Execise;
import java.util.Scanner;
public class N2SumDigits {
    public static void main(String[] arguments){
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine(); // maybe String and separate it by some method ?????
int theSum = 0;
        for (int i = 0; i <= number.length()-1; i++) {
            int nextNumber = Integer.parseInt(number.charAt(i)+"");

            theSum += nextNumber;
        }
        System.out.println(theSum);








    }
}
