package blackjack;
import blackjack.*;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player Players[] = new Player[4];
    private Card WCards[] = new Card[54];
    private final int valid = 21;
    int max = 0;
    private int count_1 =0 , count_2=0;
    String WinnerName =null;



    public int getCount_1() {
        return count_1;
    }

    public int getCount_2() {
        return count_2;
    }

    public Player[] getPlayers() {
        return Players;
    }

    public Card[] getWCards() {
        return WCards;
    }

    public void GenerateCards() {
        int i = 0;
        int rank = 0;
        int suit = 0;
        int value = 1;
        while (true) {
            if (i > 51) {
                break;
            }

            if (rank >= 10) {
                value = 10;
            }
            WCards[i] = new Card(suit, rank, value);
            //System.out.println(WCards[i].value + " " +WCards[i].rank);
            i++;
            value++;
            rank++;
            if (rank > 12) {
                rank = 0;
                value = 1;
                suit++;
            }

        }
    }



    public Card DrawCard() {
        Card card = new Card(0, 0, 0);
        boolean flag=true;

        while (flag) {
            Random rand = new Random();
            int i = rand.nextInt(52);
            if (WCards[i] != null) {
                card = WCards[i];
                WCards[i] = null;
                flag =false;
            }
        }
        //System.out.println(card.value);
        return card;
    }

    public void SetPlayers() {
        Card[] Cards = new Card[2];

        for (int n = 0; n < 4; n++) {
            int pscore=0;
            if (n<3) {
                Scanner play = new Scanner(System.in);
                System.out.println("Enter The Name Of Player " + "" + (n+1));
                String name = play.next();
                Players[n] = new Player(name);
            }
            else if (n==3) {
                Players[3]=new Player("Dealer", 0);

            }
            for (int j = 0; j < 2; j++) {
                Players[n].getCards()[j]= DrawCard();
               pscore =  pscore + Players[n].getCards()[j].getValue();
                Players[n].setScore(pscore) ;
                if (n < 3) {
                    System.out.println(" The Player's Card no. "+ (j + 1) + " value "  +  " is : " + Players[n].getCards()[j].getValue());

                }
                else if (n==3) {
                    if (j==0) {
                        System.out.println(" The Dealer's Card no."+ (j + 1) + " value " + " is : " + Players[n].getCards()[0].getValue());
                    }
                }

            }
            max = Players[0].getScore();
            System.out.println("___________________________________________________________________________________");

        }


    }

    ;

    public Card ScoreUpdate(int m , Card NewCard ) {
        int score=Players[m].getScore();

            score += NewCard.getValue();
            Players[m].AddCard(NewCard);
            Players[m].setScore(score);
            System.out.println("The Current Score is" + " " + Players[m].getScore());

        return NewCard;
    }
    public int MaxScore( Player players[]) {


        for(int i = 0; i < 4; i++) {

            if(players[i].getScore() > valid || players[i].loss ==true) {
                continue;
            }
            else if (players[i].blackjack) {

                count_1++;
                max = 21;
                WinnerName = players[i].getName();
            } else if (players[i].getScore() > max && players[i].getScore() < 21 && players[i].loss == false) {

                max = players[i].getScore();
                count_2 = 0;
                count_2++;
                WinnerName = players[i].getName();
            } else if(players[i].getScore() == max && players[i].getScore() < 21 && players[i].loss == false) {

                count_2++;
                WinnerName = players[i].getName();
            }


        }


//
//            if(players.blackjack) {
//                count_1++;
//                WinnerName=players.getName();
//            }
//            else if (players.getScore()>max && players.getScore() < 21 && players.loss ==false) {
//                count_2=0;
//                count_2++;
//                System.out.println(count_2);
//                max=players.getScore();
//                System.out.println(max);
//               WinnerName = players.getName();
//            }
//            else if (players.getScore()==max && players.getScore() < 21) {
//                count_2++;
//                System.out.println(count_2);
//                max=players.getScore();
//                System.out.println(max);
//                WinnerName = players.getName();
//            }



     return max;
    }
    public String DisplayWinner () {
        return WinnerName;
    }

}


