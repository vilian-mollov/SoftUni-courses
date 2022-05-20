package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class N6StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        int numberOutcome = 0;
        int n=0;
        for (int i = 0; i < number.length(); i++) {

             n = Integer.parseInt(String.valueOf(number.charAt(i)));
            int reset = 0;
            if (n != 1 && n !=0) {
                for (int factor = n; factor > 0; factor--) {

                    if (n == factor) {
                        reset = n * (factor - 1);
                    } else if(factor==0){
                        numberOutcome += reset;
                    } else if(factor==1){
                        numberOutcome += reset;
                    }else{
                        reset = reset * (factor - 1);
                    }

                }
            } else {
                numberOutcome++;
            }
        }
        int x = Integer.parseInt(number);
       if(x == numberOutcome){
           System.out.println("yes");
       }else{
           System.out.println("no");
       }


    }
}
