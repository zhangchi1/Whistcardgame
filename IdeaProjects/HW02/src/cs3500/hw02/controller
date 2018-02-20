



package cs3500.hw03;

import java.io.InputStreamReader;
import java.util.InputMismatchException;
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
  final Readable input;
  final Appendable output;

  /**
   * Constructor for WhistController
   */
  public WhistController(Readable rd, Appendable ap) {
    this.input = rd;
    this.output = ap;
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
    if (numPlayers < 2) {
      try {
        game.startPlay(numPlayers, game.getDeck());
      } catch (IllegalArgumentException e) {
        System.out.print("\nGame can not play less than two players");
      }
    }
    game.startPlay(numPlayers, game.getDeck());
    System.out.println(game.getGameState());
    this.continued(game);
  }

  /**
   * Continued to play the game when see an Illegal Argument exception and try re-enter a valid
   * input
   */
  public <K> void continued(CardGameModel<K> Cardgame) {
    while (!Cardgame.isGameOver()) {
      try {

        Scanner sc = new Scanner(System.in);
        System.out.print("\nPlease enter Player's card Index(Start at 0)");
        int CardIndex = sc.nextInt();
        Cardgame.play(Cardgame.getCurrentPlayer(), CardIndex);
        System.out.print(Cardgame.getGameState());
      } catch (IllegalArgumentException e) {
        System.out.println("\nTry again Please enter an invalid input ");
      }
    }
    System.out.print(Cardgame.getGameState());
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
        System.out.println("\nTry again Please enter a valid input ");
      } catch (InputMismatchException f) {
        System.out.println("\nTry again Please enter a valid input number ");
      }
    }

  }
}
