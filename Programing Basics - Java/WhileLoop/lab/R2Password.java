package WhileLoop.lab;

import java.util.Scanner;

public class R2Password {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String username = scanner.nextLine();
        String password = scanner.nextLine();


        String writtenPassword = scanner.nextLine();

        while(!writtenPassword.equals(password)){

            writtenPassword = scanner.nextLine();


        }
        System.out.printf("Welcome %s!", username );


    }
}
