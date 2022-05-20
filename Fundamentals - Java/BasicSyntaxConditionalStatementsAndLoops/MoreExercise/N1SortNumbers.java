package BasicSyntaxConditionalStatementsAndLoops.MoreExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class N1SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(n);
        numbers.add(n2);
        numbers.add(n3);

        Collections.sort(numbers);
        for (int i = 2; i >=0 ; i--) {
            System.out.println(numbers.get(i));
        }

    }
}
