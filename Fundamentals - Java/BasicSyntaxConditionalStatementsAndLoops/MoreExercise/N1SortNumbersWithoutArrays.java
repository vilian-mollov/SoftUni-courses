package BasicSyntaxConditionalStatementsAndLoops.MoreExercise;

import java.util.Scanner;

public class N1SortNumbersWithoutArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());

        int maxNumber = Integer.MIN_VALUE;
        int minNumber = Integer.MAX_VALUE;
        int middleNumber;

        if(n>maxNumber){
            maxNumber = n;
        }
        if(n2 > maxNumber){
            maxNumber = n2;
        }
        if(n3 > maxNumber){
            maxNumber = n3;
        }
        if(n<minNumber){
            minNumber = n;
        }
        if(n2 < minNumber){
            minNumber =n2;
        }
        if(n3 < minNumber){
            minNumber =n3;
        }

        middleNumber= (n+n2+n3) - (minNumber+maxNumber);

        System.out.println(maxNumber);
        System.out.println(middleNumber);
        System.out.println(minNumber);


    }
}
