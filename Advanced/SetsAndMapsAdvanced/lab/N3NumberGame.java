package SetsAndMapsAdvanced.lab;

import java.util.*;

public class N3NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayer = new LinkedHashSet<>();
        Set<Integer> secondPlayer = new LinkedHashSet<>();

        String[] firstPlayerCards = scanner.nextLine().split("\\s+");
        String[] secondPlayerCards = scanner.nextLine().split("\\s+");
//String card : firstPlayerCards
        //int i = firstPlayerCards.length - 1; i >= 0; i--
        for (String card : firstPlayerCards) {
            firstPlayer.add(Integer.parseInt(card));
        }
//String card : secondPlayerCards
        //int i = secondPlayerCards.length - 1; i >= 0; i--
        for (String card : secondPlayerCards) {
            secondPlayer.add(Integer.parseInt(card));
        }

        int rounds = 0;
        while (!firstPlayer.isEmpty() || !secondPlayer.isEmpty()) {
            rounds++;
            if (rounds == 50) {
                break;
            }
            Iterator<Integer> firstIterator =firstPlayer.iterator();
            int firstNumber = firstIterator.next();
            firstIterator.remove();

            Iterator<Integer> secondIterator =secondPlayer.iterator();
            int secondNumber = secondIterator.next();
            secondIterator.remove();

            if (firstNumber > secondNumber) {
                firstPlayer.add(firstNumber);
                firstPlayer.add(secondNumber);
            } else if (secondNumber > firstNumber) {
                secondPlayer.add(firstNumber);
                secondPlayer.add(secondNumber);
            }

        }

        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (secondPlayer.size() > firstPlayer.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }

    }
}
