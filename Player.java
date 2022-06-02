package blackjack;
import blackjack.Card;

public class Player {
    private String name;
    private int Score;
    private Card cards[]= new Card[11];
    boolean blackjack=false;
    boolean loss =false;
    int  cardindex =2 ;

    public Player(String name, int score, Card[] cards) {
        this.name = name;
        Score = score;
        this.cards = cards;
    }

    public Player(String name, int score) {
        this.name = name;
        Score = score;
    }
    public Player(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        Score = score;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }


    public String getName() {
        return name;
    }

    public int getScore() {
        return Score;
    }

    public Card[] getCards() {
        return cards;
    }



    public void AddCard(Card NewCard) {

        cards[cardindex] = NewCard;
        cardindex++;
    }
}
