package blackjack;

public class Card
{
    private final int rank;
    private final int suit;
   private final int value;
    public Card(int suit , int rank , int value) {
        this.suit=suit;
        this.rank=rank;
        this.value=value;
    }
    public Card (Card C) {
       rank=C.rank;
       suit=C.suit;
       value=C.value;
    }
    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }
}
