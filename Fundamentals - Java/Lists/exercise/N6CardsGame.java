package List.exercise;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N6CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> playerOne = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> playerTwo = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        while (!playerOne.isEmpty() && !playerTwo.isEmpty()) {
            if(playerOne.get(0)>playerTwo.get(0)){
                playerOne.add(playerOne.get(0));
                playerOne.add(playerTwo.get(0));
                playerOne.remove(0);
                playerTwo.remove(0);
            }else if (playerOne.get(0).equals(playerTwo.get(0))){
                playerOne.remove(0);
                playerTwo.remove(0);
            }else{
                playerTwo.add(playerTwo.get(0));
                playerTwo.add(playerOne.get(0));
                playerTwo.remove(0);
                playerOne.remove(0);

            }

        }
        int sumOne = 0;
        int sumTwo = 0;
        for (Integer integer : playerOne) {
            sumOne += integer;
        }
        for (Integer integer : playerTwo) {
            sumTwo += integer;
        }


        if (playerOne.isEmpty()) {
            System.out.printf("Second player wins! Sum: %d",sumTwo);
        }else{
            System.out.printf("First player wins! Sum: %d",sumOne);
        }


    }
}
