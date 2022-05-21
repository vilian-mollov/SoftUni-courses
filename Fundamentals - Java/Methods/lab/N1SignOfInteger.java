package Methods.lab;

import java.util.Scanner;

public class N1SignOfInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        extract(number);
    }

    public static int extract(int n){
        if(n>0){
            System.out.printf("The number %d is positive.",n);
        }else if(n<0) {
            System.out.printf("The number %d is negative.",n);
        }else{
            System.out.printf("The number %d is zero.",n);
        }
        return n;
    }
}
