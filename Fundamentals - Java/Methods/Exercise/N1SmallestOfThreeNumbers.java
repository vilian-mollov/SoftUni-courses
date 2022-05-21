package Methods.Exercise;
import java.util.Scanner;
public class N1SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOne = Integer.parseInt(scanner.nextLine());
        int numberTwo = Integer.parseInt(scanner.nextLine());
        int numberThree = Integer.parseInt(scanner.nextLine());
        int result=0;
        result=getTheSmalestNumber(numberOne,numberTwo,numberThree);

        System.out.println(result);
    }

    private static int getTheSmalestNumber(int numberOne, int numberTwo, int numberThree) {
       int result = Integer.MAX_VALUE;

       result= Math.min(numberOne,numberTwo);
       result = Math.min(result,numberThree);

        return result;
    }
}
