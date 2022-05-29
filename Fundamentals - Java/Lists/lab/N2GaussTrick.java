package List.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class N2GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> initialArray = Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> sum = new ArrayList<>();
        for (int i = 0; i < initialArray.size() / 2; i++) {
            int tempSum = initialArray.get(i) + initialArray.get(initialArray.size() - 1 - i);
            sum.add(tempSum);
        }
        if (initialArray.size() % 2 != 0) {
            sum.add(initialArray.get(initialArray.size() / 2));
        }
        for (Integer integer : sum) {
            System.out.print(integer+" ");
        }

    }
}
