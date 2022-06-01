package List.exercise;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N5BombNumbersWithForLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listNumers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String[] num = scanner.nextLine().split("\\s+");
        int specialNumber = Integer.parseInt(num[0]);
        int power = Integer.parseInt(num[1]);

        for (int i = 0; i < listNumers.size(); i++) {
            int bombIndex = listNumers.indexOf(specialNumber);
            int start = Math.max(bombIndex - power, 0);
            int end = Math.min(bombIndex + power, listNumers.size() - 1);

            if (listNumers.get(i).equals(specialNumber)) {
                for (int j = start; j <= end; j++) {

                    listNumers.remove(start);

                }
                i = -1;

            }


        }
        int container = 0;
        for (int i = 0; i < listNumers.size(); i++) {
            container += listNumers.get(i);
        }


        System.out.println(container);

    }

}
