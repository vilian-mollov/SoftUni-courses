package DataTypesAndVariables.MoreExercise;
import java.util.Scanner;
public class N4RefactoringPrimeChecker {
    public static void main(String[] arguments ){
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 2; i <= number; i++) {
            boolean check = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    check = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", i, check);
        }

    }
}
