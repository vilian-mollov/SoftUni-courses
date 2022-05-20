package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class N5Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password = scanner.nextLine();
        String realPassword = "";
        boolean flag = false;
        for (int j = username.length() - 1; j >= 0; j--) {
            char n;
            n = username.charAt(j);
            realPassword += n;
        }


        for (int i = 0; i < 3; i++) {

            if (password.equals(realPassword)) {
                System.out.printf("User %s logged in.",username);
                break;
            } else {
                System.out.println("Incorrect password. Try again.");
            }
            password = scanner.nextLine();

        }

        if (!password.equals(realPassword)) {
            System.out.printf("User %s blocked!",username);
        }
    }
}
