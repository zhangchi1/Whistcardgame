package cs3500.hw03;

import org.junit.Test;

import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;

/**
 * Test for whistcontroller
 */
public class WhistControllerTest {
  WhistModel whistgame1 = new WhistModel();

  @Test(expected = IllegalArgumentException.class)
  public void teststartGameIllegalgame() {
    WhistModel whistgame1 = new WhistModel();
    Readable input = new InputStreamReader(System.in);
    Appendable output = new PrintStream(System.out);
    WhistController controller1 = new WhistController(input, output);
    controller1.startGame(whistgame1, 1);
    controller1.CardGame.getGameState();
    assertEquals("", controller1.CardGame.getGameState());
  }

  @Test
  public void teststartgame4players() {
    StringBuffer out = new StringBuffer();
    StringReader in = new StringReader(
        "0 0 0 0 0 0 0 0 0 0 " +
            "0 0 0 0 0 0 0 0 0 0 " +
            "0 0 0 0 0 0 0 0 0 0 " +
            "0 0 0 0 0 0 0 0 0 0 " +
            "0 0 0 0 0 0 0 0 0 0 0 0 ");
    WhistController controller1 = new WhistController(in, out);
    controller1.startGame(whistgame1, 4);
    assertEquals("Number of players: 4\n" +
        "Player 1: A♣, 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: K♣, 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: Q♣, 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: J♣, 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 0 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 1\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: K♣, 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: Q♣, 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: J♣, 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 0 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 2\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: Q♣, 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: J♣, 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 0 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 3\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: J♣, 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 0 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 4\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 1 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 1\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 1 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 2\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 1 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 3\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 1 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 4\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 2 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 1\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 2 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 2\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 2 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 3\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 2 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 4\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 3 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 1\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 3 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 2\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 3 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 3\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 3 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 4\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 4 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 1\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 4 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 2\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 4 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 3\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 4 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 4\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 5 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 1\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 5 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 2\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 5 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 3\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 5 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 4\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 6 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 1\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 6 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 2\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 6 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 3\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 6 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 4\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 7 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 1\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 7 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 2\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 7 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 3\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 7 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 4\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 8 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 1\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 8 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 2\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 8 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 3\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 8 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 4\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 9 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 1\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: K♠, 9♠, 5♠\n" +
        "Player 2: 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 9 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 2\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: K♠, 9♠, 5♠\n" +
        "Player 2: Q♠, 8♠, 4♠\n" +
        "Player 3: 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 9 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 3\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: K♠, 9♠, 5♠\n" +
        "Player 2: Q♠, 8♠, 4♠\n" +
        "Player 3: J♠, 7♠, 3♠\n" +
        "Player 4: A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 9 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 4\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: K♠, 9♠, 5♠\n" +
        "Player 2: Q♠, 8♠, 4♠\n" +
        "Player 3: J♠, 7♠, 3♠\n" +
        "Player 4: 10♠, 6♠, 2♠\n" +
        "Player 1: 10 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 1\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 9♠, 5♠\n" +
        "Player 2: Q♠, 8♠, 4♠\n" +
        "Player 3: J♠, 7♠, 3♠\n" +
        "Player 4: 10♠, 6♠, 2♠\n" +
        "Player 1: 10 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 2\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 9♠, 5♠\n" +
        "Player 2: 8♠, 4♠\n" +
        "Player 3: J♠, 7♠, 3♠\n" +
        "Player 4: 10♠, 6♠, 2♠\n" +
        "Player 1: 10 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 3\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 9♠, 5♠\n" +
        "Player 2: 8♠, 4♠\n" +
        "Player 3: 7♠, 3♠\n" +
        "Player 4: 10♠, 6♠, 2♠\n" +
        "Player 1: 10 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 4\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 9♠, 5♠\n" +
        "Player 2: 8♠, 4♠\n" +
        "Player 3: 7♠, 3♠\n" +
        "Player 4: 6♠, 2♠\n" +
        "Player 1: 11 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 1\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 5♠\n" +
        "Player 2: 8♠, 4♠\n" +
        "Player 3: 7♠, 3♠\n" +
        "Player 4: 6♠, 2♠\n" +
        "Player 1: 11 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 2\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 5♠\n" +
        "Player 2: 4♠\n" +
        "Player 3: 7♠, 3♠\n" +
        "Player 4: 6♠, 2♠\n" +
        "Player 1: 11 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 3\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 5♠\n" +
        "Player 2: 4♠\n" +
        "Player 3: 3♠\n" +
        "Player 4: 6♠, 2♠\n" +
        "Player 1: 11 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 4\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: 5♠\n" +
        "Player 2: 4♠\n" +
        "Player 3: 3♠\n" +
        "Player 4: 2♠\n" +
        "Player 1: 12 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 1\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: \n" +
        "Player 2: 4♠\n" +
        "Player 3: 3♠\n" +
        "Player 4: 2♠\n" +
        "Player 1: 12 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 2\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: \n" +
        "Player 2: \n" +
        "Player 3: 3♠\n" +
        "Player 4: 2♠\n" +
        "Player 1: 12 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 3\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: \n" +
        "Player 2: \n" +
        "Player 3: \n" +
        "Player 4: 2♠\n" +
        "Player 1: 12 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 4\n" +
        "\n" +
        " Please enter card Index \n" +
        "Number of players: 4\n" +
        "Player 1: \n" +
        "Player 2: \n" +
        "Player 3: \n" +
        "Player 4: \n" +
        "Player 1: 13 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Game over. Player 1  won.\n", out.toString());
  }


}
