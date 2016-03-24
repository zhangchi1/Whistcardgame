package cs3500.hw03;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import cs3500.hw02.Card;

/**
 * Represents a WhistController class
 */
public class WhistController implements IWhistController {

  /**
   * Fields
   */
  CardGameModel<Card> CardGame;
  final Readable rd;
  final Appendable ap;

  /**
   * Constructor for WhistController
   */
  public WhistController(Readable rd, Appendable ap) {
    this.rd = rd;
    this.ap = ap;
  }

  /**
   * Start the provided game model for the provided number of players
   *
   * @param game       give a provided game
   * @param numPlayers number of Players “Run” the game in the following sequence until the game has
   *                   been won: Display game state to the output stream (which will include a
   *                   message for the next player to play if applicable, as provided by
   *                   getGameState() above). If the game is ongoing, wait for user input from the
   *                   input stream. The user input will be only the position of the card to be
   *                   played for the current player. It will pass this information on to the model.
   *                   If the game has been won, the method returns.
   */
  public <K> void startGame(CardGameModel<K> game, int numPlayers) {
    List<K> deck = game.getDeck();
    game.startPlay(numPlayers, deck);
    Scanner sc1 = new Scanner(this.rd);
    try {
      ap.append(game.getGameState());
    } catch (IOException e) {
      e.printStackTrace();
    }
    while (!game.isGameOver()) {

      try {
        ap.append("\n Please enter card Index \n");
      } catch (IOException e0) {
        e0.printStackTrace();
      }


      //ask for user input
      int cardIdx;
      String in = sc1.next();
      //play the card
      try {
        cardIdx = Integer.parseInt(in);
      } catch (NumberFormatException e1) {
        try {
          ap.append("Invalid input: " + in + ". Try again.\n");
        } catch (IOException e2) {
          e2.printStackTrace();
        }
        continue;
      }

      //display the gamestate
      try {
        game.play(game.getCurrentPlayer(), cardIdx);
      } catch (IllegalArgumentException e3) {
        try {
          ap.append("Invalid index: " + cardIdx + ". Try again.\n");
        } catch (IOException e4) {
          e4.printStackTrace();
        }
        continue;
      }
      try {
        ap.append(game.getGameState() + "\n");
      } catch (IOException e5) {
        e5.printStackTrace();
      }
    }
  }


  /**
   * the main function, which controls to run the game
   */
  public static void main(String[] args) {
    boolean firstboolean = true;
    while (firstboolean) {
      WhistController WController = new WhistController(new InputStreamReader(System.in),
          System.out);
      CardGameModel Cardgame = new WhistModel();
      try {
        System.out.print("Please enter how many players for this game");
        Scanner sc = new Scanner(System.in);
        int numberOfPlayer = sc.nextInt();
        WController.startGame(Cardgame, numberOfPlayer);
        firstboolean = false;
      } catch (IllegalArgumentException e) {
        System.out.println("\nTry again Please enter a valid input number greater than 1 ");
      } catch (InputMismatchException f) {
        System.out.println("Try again Please enter a valid input number ");
      }
    }

  }
}