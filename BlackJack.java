package blackjack;
import blackjack.*;
import javax.swing.JFrame;
import java.util.Scanner;
public class Blackjack {
    static Game StartGame = new Game();
    public static void main (String[] args) {
       GUI gui = new GUI();
        Player[] theplayers = new Player[4];
         String Winner= null;
        int count3 = 0 , count4 = 0 , maximum = 0;

        StartGame.GenerateCards();
        StartGame.SetPlayers();

        theplayers[3]=StartGame.getPlayers()[3];
        gui.runGUI(StartGame.getWCards(), StartGame.getPlayers()[0].getCards(),StartGame.getPlayers()[1].getCards() , StartGame.getPlayers()[2].getCards() ,StartGame.getPlayers()[3].getCards());


        for (int i = 0 ; i <4 ; i++) {
            theplayers[i] = StartGame.getPlayers()[i];
            if (i == 3) {
                if (count4 == 3) {
                    break;
                } else if (count3 == 3) {
                    break;
                } else {
                    System.out.println("For Dealer" + " : " + " Press 1 to Hit or Press 2 to Stand ??");
                }
            }
            if (i < 3) {
                System.out.println("For Player" + " " + (i + 1) + " : " + " Press 1 to Hit or Press 2 to Stand ??");
            }
            Scanner Answer = new Scanner(System.in);
            String ans = Answer.next();
            while (true) {
                if (ans.equals("1")) {
                    if (i < 3) {
                        Card Newcard = StartGame.DrawCard();
                        gui.updatePlayerHand(Newcard, i);
                        StartGame.ScoreUpdate(i, Newcard);
                    } else if (i == 3) {
                        if (count3 < 3 && count4 < 3) {
                            Card Newcard = StartGame.DrawCard();
                            gui.updateDealerHand(Newcard, StartGame.getWCards());
                            StartGame.ScoreUpdate(3, Newcard);
                        }

                    }
                    if (theplayers[i].getScore() == 21) {
                        System.out.println("Congrats You Have Reached BlackJack");
                        theplayers[i].blackjack = true;
                        break;
                    } else if (theplayers[i].getScore() >= 21) {
                        System.out.println("You Are BUSTED");
                        theplayers[i].loss = true;
                        if (i <3) {
                            count4++;
                        }
                        System.out.println(count4);
                        break;
                    }
                    System.out.println("Press 1 to Hit or Press 2 to Stand ??");
                    ans = Answer.next();

                } else if (ans.equals("2")) {
                    Card fCard = new Card(0, 0, 0);
                    StartGame.ScoreUpdate(i, fCard);
                    break;
                }
                if (i != 3)
                    if (theplayers[3].getScore() > theplayers[i].getScore()) {
                        count3++;
                    }

            }




            System.out.println("___________________________________________________________________________________");
        }

//        for (int j = 0 ; j<4; j++) {
        maximum = StartGame.MaxScore(theplayers);
        System.out.println("the max is " + maximum);
            Winner = StartGame.DisplayWinner();
//        }


       
               if (count4==3) {
                   System.out.println("Since that all other players all busted then The Dealer has won");
               }
              else if (count3==3) {
                  System.out.println("The Dealer Wins because the value of his 2 cards are more than the maximum score");
              }
             else if (StartGame.getCount_1() == 1 ) {
                 if (StartGame.getCount_2()>=0) {
                     System.out.println("We Have A Winner With A blackJack" + " : Player " + Winner);
                 }
              } else if (StartGame.getCount_2() > 1) {
                  System.out.println("It is A Push (Draw) ");
              } else if (StartGame.getCount_1() == 0 && StartGame.getCount_2() == 1) {
                  System.out.println("We Have A Winner of Maximum Score ( below 21)" + " : Player " + Winner);
              }

          }
    }
