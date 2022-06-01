package List.exercise;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N5BombNumbersWithWhileLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            List<Integer> listNumers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String[] num = scanner.nextLine().split("\\s+");
        int specialNumber = Integer.parseInt(num[0]);
        int power =Integer.parseInt(num[1]);


        while (listNumers.contains(specialNumber)) {
            int bombIndex = listNumers.indexOf(specialNumber);
            int start = Math.max(bombIndex - power,0);
            int end = Math.min(bombIndex + power,listNumers.size()-1);


            for (int i = start; i <= end; i++) {
                listNumers.remove(start);
            }

        }
        int sum = 0;
        for (Integer listNumer : listNumers) {
            sum += listNumer;
        }

        System.out.println(sum);

    }
}
