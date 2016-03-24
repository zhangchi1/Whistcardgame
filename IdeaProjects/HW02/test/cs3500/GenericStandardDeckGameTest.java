package cs3500.hw02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Test all methods for GenericStandardDeckGame
 */
public class GenericStandardDeckGameTest {

  Card.Value values[] = Card.Value.values();
  Card.Suit suits[] = Card.Suit.values();

  Card card6 = new Card(values[5], suits[0]);

  Card card4 = new Card(values[3], suits[0]);
  Card card3 = new Card(values[2], suits[0]);
  Card card2 = new Card(values[1], suits[0]);
  Card card1 = new Card(values[0], suits[0]);

  Card card14 = new Card(values[0], suits[1]);

  Card card27 = new Card(values[0], suits[2]);
  Card card52 = new Card(values[12], suits[3]);
  Card card51 = new Card(values[11], suits[3]);
  Card card50 = new Card(values[10], suits[3]);
  Card card49 = new Card(values[9], suits[3]);
  Card card48 = new Card(values[8], suits[3]);
  Card card47 = new Card(values[7], suits[3]);
  Card card46 = new Card(values[6], suits[3]);

  Card card40 = new Card(values[0], suits[3]);

  /**
   * Test getDeck method
   */
  @Test
  public void testgetDeck() {
    GenericStandardDeckGame game = new GenericStandardDeckGame();
    assertEquals(card1, game.getDeck().get(0));
    assertEquals(card2, game.getDeck().get(1));
    assertEquals(card14, game.getDeck().get(13));
    assertEquals(card27, game.getDeck().get(26));
    assertEquals(card40, game.getDeck().get(39));
    assertEquals(card49, game.getDeck().get(48));
    assertEquals(card50, game.getDeck().get(49));
    assertEquals(card51, game.getDeck().get(50));
    assertEquals(card52, game.getDeck().get(51));
    assertEquals(card48, game.getDeck().get(47));
    assertEquals(card47, game.getDeck().get(46));
    assertEquals(card46, game.getDeck().get(45));
    assertEquals(52, game.getDeck().size());
  }

  /**
   * Test nodupcards method
   */
  @Test
  public void testnodupCards() {
    GenericStandardDeckGame game1 = new GenericStandardDeckGame();
    List<Card> deck1 = game1.getDeck();
    List<Card> deck0 = new ArrayList<>();
    List<Card> deck2 = new ArrayList<Card>(Arrays.asList(card1, card1));
    List<Card> deck3 = new ArrayList<Card>(Arrays.asList(card2, card1, card1));
    List<Card> deck4 = new ArrayList<Card>(Arrays.asList(card1, card2, card14));
    List<Card> deck5 = new ArrayList<Card>(Arrays.asList(card1, card2, card27, card2, card27));
    List<Card> deck6 = new ArrayList<Card>(Arrays.asList(card1, card2, card40, card50, card27));
    assertEquals(true, game1.nodupCards(deck1));
    assertEquals(false, game1.nodupCards(deck2));
    assertEquals(false, game1.nodupCards(deck3));
    assertEquals(true, game1.nodupCards(deck4));
    assertEquals(false, game1.nodupCards(deck5));
    assertEquals(true, game1.nodupCards(deck6));
    assertEquals(true, game1.nodupCards(deck0));
  }

  /**
   * Test for isvalid method
   */
  @Test
  public void testisvalid() {
    GenericStandardDeckGame game1 = new GenericStandardDeckGame();
    List<Card> deck1 = game1.getDeck();
    List<Card> deck2 = new ArrayList<Card>(Arrays.asList(card1, card1));
    List<Card> deck3 = new ArrayList<Card>(Arrays.asList(card2, card1, card1));
    List<Card> deck4 = new ArrayList<Card>();
    List<Card> deck6 = new ArrayList<Card>(Arrays.asList(card1, card2, card40, card50, card27));
    assertEquals(true, game1.isvalid(deck1));
    assertEquals(false, game1.isvalid(deck2));
    assertEquals(false, game1.isvalid(deck3));
    assertEquals(false, game1.isvalid(deck4));
    assertEquals(false, game1.isvalid(deck6));
  }


  /**
   * Test for startPlay method 3 players
   */
  @Test
  public void teststartPlayfor3Players() {
    GenericStandardDeckGame game1 = new GenericStandardDeckGame();
    List<Card> deck1 = game1.getDeck();

    game1.startPlay(3, deck1);

    assertEquals(3, game1.listplayers.size());
    assertEquals(card1, game1.listplayers.get(0).listCard.get(0));
    assertEquals(card2, game1.listplayers.get(1).listCard.get(0));
    assertEquals(card3, game1.listplayers.get(2).listCard.get(0));
    assertEquals(card52, game1.listplayers.get(0).listCard.get(17));
  }

  /**
   * Test for startPlay method for 53 players
   */
  @Test
  public void teststartPlayfor53Players() {
    GenericStandardDeckGame game1 = new GenericStandardDeckGame();
    List<Card> deck1 = game1.getDeck();

    game1.startPlay(53, deck1);

    assertEquals(53, game1.listplayers.size());
    assertEquals(card1, game1.listplayers.get(0).listCard.get(0));
    assertEquals(card2, game1.listplayers.get(1).listCard.get(0));
    assertEquals(card3, game1.listplayers.get(2).listCard.get(0));
    assertEquals(card52, game1.listplayers.get(51).listCard.get(0));
    assertEquals(card52, game1.listplayers.get(51).listCard.get(0));
    assertEquals(0, game1.listplayers.get(52).listCard.size());
  }

  /**
   * Test for Illegal game
   */
  @Test(expected = IllegalArgumentException.class)
  public void testillegalgame() {
    GenericStandardDeckGame game1 = new GenericStandardDeckGame();
    List<Card> deck1 = game1.getDeck();
    List<Card> deck2 = new ArrayList<Card>(Arrays.asList(card1, card2));
    List<Card> deck3 = new ArrayList<Card>(Arrays.asList(card1, card1));
    game1.startPlay(1, deck1);
    game1.startPlay(0, deck1);
    game1.startPlay(2, deck2);
    game1.startPlay(52, deck2);
    game1.startPlay(52, deck3);
    game1.startPlay(53, deck3);
    game1.startPlay(3, deck3);
  }

  /**
   * Test for getGameState
   */
  @Test
  public void testgetGameStatewithoutstartplay() {
    GenericStandardDeckGame game1 = new GenericStandardDeckGame();
    assertEquals("Number of players: 0", game1.getGameState());
  }

  /**
   * Illegal getGameState
   */
  @Test(expected = IllegalArgumentException.class)
  public void testgetGameStatewithIllegalstartplay() {
    GenericStandardDeckGame game1 = new GenericStandardDeckGame();
    List<Card> deck3 = new ArrayList<Card>(Arrays.asList(card1, card1));
    game1.startPlay(3, deck3);
    game1.getGameState();
  }

  /**
   * Test for getGameState method with 3 players
   */
  @Test
  public void testgetGameStatewith3Players() {
    GenericStandardDeckGame game1 = new GenericStandardDeckGame();
    List<Card> deck1 = game1.getDeck();
    List<Card> deck2 = new ArrayList<>(Arrays.asList(card49, card2, card50, card3,
        card14, card27, card40));

    game1.startPlay(3, deck1);
    assertEquals("Number of players: 3\n" +
            "Player 1: A♣, J♣, 8♣, 5♣, 2♣, Q♦, 9♦, 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
            "Player 2: K♣, 10♣, 7♣, 4♣, A♦, J♦, 8♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
            "Player 3: Q♣, 9♣, 6♣, 3♣, K♦, 10♦, 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠",
        game1.getGameState());


  }

  /**
   * Test getGameState method with 4 players
   */
  @Test
  public void testgetGameStatewith4Players() {
    GenericStandardDeckGame game1 = new GenericStandardDeckGame();
    List<Card> deck1 = game1.getDeck();
    game1.startPlay(4, deck1);
    assertEquals("Number of players: 4\n" +
        "Player 1: A♣, 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: K♣, 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: Q♣, 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: J♣, 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠", game1.getGameState());
  }

  @Test
  public void testgetGameStatewith4Playersunordereddeck() {
    GenericStandardDeckGame game1 = new GenericStandardDeckGame();
    List<Card> deck1 = game1.getDeck();
    deck1.remove(5);
    deck1.add(card6);
    deck1.remove(3);
    deck1.add(card4);
    game1.startPlay(4, deck1);
    assertEquals("Number of players: 4\n" +
        "Player 1: A♣, 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 2: K♣, 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 3: Q♣, 9♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 4: J♣, 10♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠", game1.getGameState());
  }

  /**
   * Test getGameState method with 5 players
   */
  @Test
  public void testgetGameStatewith5Players() {
    GenericStandardDeckGame game1 = new GenericStandardDeckGame();
    List<Card> deck1 = game1.getDeck();
    game1.startPlay(5, deck1);
    assertEquals("Number of players: 5\n" +
        "Player 1: A♣, 9♣, 4♣, Q♦, 7♦, 2♦, 10♥, 5♥, K♠, 8♠, 3♠\n" +
        "Player 2: K♣, 8♣, 3♣, J♦, 6♦, A♥, 9♥, 4♥, Q♠, 7♠, 2♠\n" +
        "Player 3: Q♣, 7♣, 2♣, 10♦, 5♦, K♥, 8♥, 3♥, J♠, 6♠\n" +
        "Player 4: J♣, 6♣, A♦, 9♦, 4♦, Q♥, 7♥, 2♥, 10♠, 5♠\n" +
        "Player 5: 10♣, 5♣, K♦, 8♦, 3♦, J♥, 6♥, A♠, 9♠, 4♠", game1.getGameState());
  }

  /**
   * Test getGameState method with 53 players
   */
  @Test
  public void testgetGameStatewith53Players() {
    GenericStandardDeckGame game1 = new GenericStandardDeckGame();
    List<Card> deck1 = game1.getDeck();
    game1.startPlay(53, deck1);
    assertEquals("Number of players: 53\n" +
        "Player 1: A♣\n" +
        "Player 2: K♣\n" +
        "Player 3: Q♣\n" +
        "Player 4: J♣\n" +
        "Player 5: 10♣\n" +
        "Player 6: 9♣\n" +
        "Player 7: 8♣\n" +
        "Player 8: 7♣\n" +
        "Player 9: 6♣\n" +
        "Player 10: 5♣\n" +
        "Player 11: 4♣\n" +
        "Player 12: 3♣\n" +
        "Player 13: 2♣\n" +
        "Player 14: A♦\n" +
        "Player 15: K♦\n" +
        "Player 16: Q♦\n" +
        "Player 17: J♦\n" +
        "Player 18: 10♦\n" +
        "Player 19: 9♦\n" +
        "Player 20: 8♦\n" +
        "Player 21: 7♦\n" +
        "Player 22: 6♦\n" +
        "Player 23: 5♦\n" +
        "Player 24: 4♦\n" +
        "Player 25: 3♦\n" +
        "Player 26: 2♦\n" +
        "Player 27: A♥\n" +
        "Player 28: K♥\n" +
        "Player 29: Q♥\n" +
        "Player 30: J♥\n" +
        "Player 31: 10♥\n" +
        "Player 32: 9♥\n" +
        "Player 33: 8♥\n" +
        "Player 34: 7♥\n" +
        "Player 35: 6♥\n" +
        "Player 36: 5♥\n" +
        "Player 37: 4♥\n" +
        "Player 38: 3♥\n" +
        "Player 39: 2♥\n" +
        "Player 40: A♠\n" +
        "Player 41: K♠\n" +
        "Player 42: Q♠\n" +
        "Player 43: J♠\n" +
        "Player 44: 10♠\n" +
        "Player 45: 9♠\n" +
        "Player 46: 8♠\n" +
        "Player 47: 7♠\n" +
        "Player 48: 6♠\n" +
        "Player 49: 5♠\n" +
        "Player 50: 4♠\n" +
        "Player 51: 3♠\n" +
        "Player 52: 2♠\n" +
        "Player 53: ", game1.getGameState());
  }

  /**
   * Test for mysort method with 3 cards in a list
   */
  @Test
  public void testmysortwith3Cards() {
    GenericStandardDeckGame game2 = new GenericStandardDeckGame();
    List<Card> deck2 = new ArrayList<>(Arrays.asList(card49, card2, card50));
    game2.mysort(deck2);
    assertEquals("K♣", deck2.get(0).CardtoString());
    assertEquals("5♠", deck2.get(1).CardtoString());
    assertEquals("4♠", deck2.get(2).CardtoString());

  }

  /**
   * Test for mysort method with 6 cards in a list
   */
  @Test
  public void testmysortwith6Cards() {
    GenericStandardDeckGame game2 = new GenericStandardDeckGame();
    List<Card> deck2 = new ArrayList<>(Arrays.asList(card49, card2, card50, card1, card52));
    game2.mysort(deck2);
    assertEquals("A♣", deck2.get(0).CardtoString());
    assertEquals("K♣", deck2.get(1).CardtoString());
    assertEquals("5♠", deck2.get(2).CardtoString());
    assertEquals("4♠", deck2.get(3).CardtoString());
    assertEquals("2♠", deck2.get(4).CardtoString());
  }
}
