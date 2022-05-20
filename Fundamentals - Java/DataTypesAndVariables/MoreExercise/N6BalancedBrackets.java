package DataTypesAndVariables.MoreExercise;

import java.util.Scanner;

public class N6BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        boolean isBalanced = true;
        int openingCollector = 0;
        int closingCollector = 0;

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            char newInput = (char) input.charAt(0);
            if(closingCollector>openingCollector){
                isBalanced=false;
            }
            if(newInput==40){
                openingCollector ++;
            }
            if(newInput==41){
                closingCollector++;
            }


        }

        if(openingCollector != closingCollector){
            isBalanced=false;
        }


        if(isBalanced){
            System.out.println("BALANCED");
        }else{
            System.out.println("UNBALANCED");
        }


    }
}
