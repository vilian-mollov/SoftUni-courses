import java.util.Scanner;

public class ZadachaChetiri {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double inch = Double.parseDouble(scanner.nextLine());
        double santimeters = inch * 2.54;
        System.out.println(santimeters);
    }
}
