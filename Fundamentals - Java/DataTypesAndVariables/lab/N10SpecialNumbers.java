package DataTypesAndVariables.lab;
import java.util.Scanner;
public class N10SpecialNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean flag = false;

        for (int i = 1; i <=n ; i++) {
           int lastNumber= i%10;
           int firstNumber =i-lastNumber;
           if(firstNumber==0){
               if(lastNumber==5){
                   System.out.printf("%d -> True%n",i);
               }else if(lastNumber==7){
                   System.out.printf("%d -> True%n",i);
               }else {
                   System.out.printf("%d -> False%n",i);
               }
           }else {
               firstNumber /= 10;
               if(firstNumber+lastNumber==5){
                   System.out.printf("%d -> True%n",i);
               }else if(firstNumber+lastNumber==7){
                   System.out.printf("%d -> True%n",i);
               }else if(firstNumber+lastNumber==11){
                   System.out.printf("%d -> True%n",i);
               }else {
                   System.out.printf("%d -> False%n",i);
               }

           }

        }

    }
}
