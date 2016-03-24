package cs3500.hw04;

/**
 * Created by chizhang on 2/22/16.
 */

import org.junit.Test;

import java.util.List;

import cs3500.hw02.Card;
import cs3500.hw03.CardGameModel;
import cs3500.hw03.WhistModel;

import static cs3500.hw04.WhistModelCreator.ModelType;
import static cs3500.hw04.WhistModelCreator.create;
import static org.junit.Assert.assertEquals;

/**
 * Test for all method for WhistModelCreator
 */
public class WhistModelCreatorTest {
  Card.Value values[] = Card.Value.values();
  Card.Suit suits[] = Card.Suit.values();

  Card card4 = new Card(values[3], suits[0]);
  Card card3 = new Card(values[2], suits[0]);
  Card card2 = new Card(values[1], suits[0]);
  Card card1 = new Card(values[0], suits[0]);

  WhistModelCreator.ModelType Trumpmodel = ModelType.TRUMP;
  WhistModelCreator.ModelType nontrumpmodel = ModelType.NOTRUMP;
  CardGameModel Trumpgame = create(Trumpmodel);
  CardGameModel Whistgame = create(nontrumpmodel);

  /**
   * test for create method
   */
  @Test
  public void testcreatenontrumpmodel() {

    assertEquals(false, Whistgame instanceof WhistTrumpModel);
    assertEquals(true, Whistgame instanceof WhistModel);

  }

  /**
   * test for create method
   */
  @Test
  public void testcreatetrumpmodel() {

    assertEquals(true, Trumpgame instanceof WhistTrumpModel);
    assertEquals(true, Trumpgame instanceof WhistModel);
  }

  @Test
  public void usecreatortoplaytrumpmodel() {
    WhistModel game1 = create(ModelType.TRUMP);
    List<Card> deck1 = game1.getDeck();

    game1.startPlay(4, deck1);
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
        "Trump suit: ♣", game1.getGameState());
    assertEquals(4, game1.getListofWhistPlayer().size());
    assertEquals(card1, game1.getListofWhistPlayer().get(0).listCard.get(0));
    assertEquals(card2, game1.getListofWhistPlayer().get(1).listCard.get(0));
    assertEquals(card3, game1.getListofWhistPlayer().get(2).listCard.get(0));
    assertEquals(card4, game1.getListofWhistPlayer().get(3).listCard.get(0));
    game1.play(0, 12);
    game1.play(1, 12);
    game1.play(2, 12);
    game1.play(3, 12);
    assertEquals("Number of players: 4\n" +
        "Player 1: A♣, 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠\n" +
        "Player 2: K♣, 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠\n" +
        "Player 3: Q♣, 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠\n" +
        "Player 4: J♣, 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠\n" +
        "Player 1: 1 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 1\n" +
        "Trump suit: ♣", game1.getGameState());
    game1.play(0, 3);
    game1.play(1, 0);
    game1.play(2, 0);
    game1.play(3, 0);
    assertEquals("Number of players: 4\n" +
        "Player 1: A♣, 10♣, 6♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠\n" +
        "Player 2: 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠\n" +
        "Player 3: 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠\n" +
        "Player 4: 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠\n" +
        "Player 1: 1 hands won\n" +
        "Player 2: 1 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 2\n" +
        "Trump suit: ♣", game1.getGameState());
    game1.play(1, 2);
    game1.play(2, 2);
    game1.play(3, 2);
    game1.play(0, 3);
    game1.play(1, 2);
    game1.play(2, 2);
    game1.play(3, 2);
    game1.play(0, 3);
    assertEquals("Number of players: 4\n" +
        "Player 1: A♣, 10♣, 6♣, 3♦, Q♥, 8♥, 4♥, K♠, 9♠\n" +
        "Player 2: 9♣, 5♣, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠\n" +
        "Player 3: 8♣, 4♣, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠\n" +
        "Player 4: 7♣, 3♣, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠\n" +
        "Player 1: 1 hands won\n" +
        "Player 2: 3 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 2\n" +
        "Trump suit: ♣", game1.getGameState());
    game1.play(1, 2);
    game1.play(2, 2);
    game1.play(3, 2);
    game1.play(0, 3);
    assertEquals("Number of players: 4\n" +
        "Player 1: A♣, 10♣, 6♣, Q♥, 8♥, 4♥, K♠, 9♠\n" +
        "Player 2: 9♣, 5♣, 2♦, J♥, 7♥, 3♥, Q♠, 8♠\n" +
        "Player 3: 8♣, 4♣, A♥, 10♥, 6♥, 2♥, J♠, 7♠\n" +
        "Player 4: 7♣, 3♣, K♥, 9♥, 5♥, A♠, 10♠, 6♠\n" +
        "Player 1: 1 hands won\n" +
        "Player 2: 4 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 2\n" +
        "Trump suit: ♣", game1.getGameState());
    game1.play(1, 2);
    game1.play(2, 2);
    game1.play(3, 2);
    game1.play(0, 3);
    game1.play(1, 2);
    game1.play(2, 2);
    game1.play(3, 2);
    game1.play(0, 3);
    game1.play(1, 2);
    game1.play(2, 2);
    game1.play(3, 2);
    game1.play(0, 3);
    game1.play(1, 2);
    game1.play(2, 2);
    game1.play(3, 2);
    game1.play(0, 3);
    game1.play(1, 2);
    game1.play(2, 2);
    game1.play(3, 2);
    game1.play(0, 3);
    assertEquals("Number of players: 4\n" +
        "Player 1: A♣, 10♣, 6♣\n" +
        "Player 2: 9♣, 5♣, 8♠\n" +
        "Player 3: 8♣, 4♣, 7♠\n" +
        "Player 4: 7♣, 3♣, 6♠\n" +
        "Player 1: 1 hands won\n" +
        "Player 2: 9 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 2\n" +
        "Trump suit: ♣", game1.getGameState());
    game1.play(1, 2);
    game1.play(2, 2);
    game1.play(3, 2);
    game1.play(0, 2);
    game1.play(0, 0);
    game1.play(1, 0);
    game1.play(2, 0);
    game1.play(3, 0);
    assertEquals("Number of players: 4\n" +
        "Player 1: 10♣\n" +
        "Player 2: 5♣\n" +
        "Player 3: 4♣\n" +
        "Player 4: 3♣\n" +
        "Player 1: 3 hands won\n" +
        "Player 2: 9 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 1\n" +
        "Trump suit: ♣", game1.getGameState());
    game1.play(0, 0);  //all play trump suit cards
    game1.play(1, 0);
    game1.play(2, 0);
    game1.play(3, 0);
    assertEquals("Number of players: 4\n" +
        "Player 1: \n" +
        "Player 2: \n" +
        "Player 3: \n" +
        "Player 4: \n" +
        "Player 1: 4 hands won\n" +
        "Player 2: 9 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Game over. Player 2  won.", game1.getGameState());



  }

}
