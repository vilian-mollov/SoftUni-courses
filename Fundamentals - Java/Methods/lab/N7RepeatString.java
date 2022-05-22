package Methods.lab;

import java.util.Scanner;

public class N7RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        repeatTextNTimens(n,text);
    }

    private static void repeatTextNTimens(int n,String text) {
        for (int i = 0; i < n; i++) {
            System.out.print(text);
        }
    }
}
