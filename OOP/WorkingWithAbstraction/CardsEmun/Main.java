package WorkingWithAbstraction.CardsEmun;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rankInput = scanner.nextLine();
        String suitInput = scanner.nextLine();

        CardSuit suit = CardSuit.valueOf(suitInput.toUpperCase());
        CardRank rank = CardRank.valueOf(rankInput.toUpperCase());

        Card card = new Card(rank, suit);

        System.out.println("Card name: " + card.getRank() + " of " + card.getSuit() + "; Card power: " + card.getPower());

    }
}
