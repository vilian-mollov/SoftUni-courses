package WorkingWithAbstraction.CardsEmun;

public class Card {

    private CardRank rank;
    private CardSuit suit;

    private int power;

    public Card(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
        this.power = setPower(rank, suit);
    }

    public CardRank getRank() {
        return rank;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public int getPower() {
        return power;
    }

    private int setPower(CardRank rank, CardSuit suit) {
        return rank.getValue() + suit.getValue();
    }
}
