package Methods.lab;
import java.util.Scanner;
public class N11MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOne = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int numberTwo = Integer.parseInt(scanner.nextLine());
        double result =0.0;
       result= makingOperations(numberOne,operator,numberTwo);
       if(result % 1 == 0){
           System.out.printf("%.0f",result);
       }else{
           System.out.printf("%.2f",result);

       }


    }

    private static double makingOperations(int numberOne, String operator, int numberTwo) {
        double result = 0.0;
        switch(operator){
            case "/":
                result = 1.0 * numberOne / numberTwo;
                break;
            case "*":
                result= 1.0 * numberOne * numberTwo;
                break;
            case "+":
                result = numberOne+numberTwo;
                break;
            case "-":
                result = numberOne-numberTwo;
                break;
        }


        return result;
    }
}
