package NestedLoop.lab;

import java.util.Scanner;

public class N6Building {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int h = Integer.parseInt(scanner.nextLine());
        int r = Integer.parseInt(scanner.nextLine());

        for (int i = h; i >= 1 ; i--) {


                if(i != h){

                    if(i % 2 == 0) {
                        for (int j = 0; j < r; j++) {
                            System.out.printf("O%d%d", i, j);

                            System.out.print(" ");
                        }
                    }else {
                        for (int j = 0; j < r; j++) {
                            System.out.printf("A%d%d", i, j);

                            System.out.print(" ");
                        }


                    }


                }else {
                    for (int k = 0; k < r; k++) {

                        System.out.printf("L%d%d", h,k );
                        System.out.print(" ");
                    }
                }


            System.out.println("");
        }
    }
}
