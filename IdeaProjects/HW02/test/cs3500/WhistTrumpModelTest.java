package cs3500.hw04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cs3500.hw02.Card;
import cs3500.hw02.GenericStandardDeckGame;

import static org.junit.Assert.assertEquals;

/**
 * Created by chizhang on 2/19/16.
 */
public class WhistTrumpModelTest {
  Card.Value values[] = Card.Value.values();
  Card.Suit suits[] = Card.Suit.values();
  Card card52 = new Card(values[12], suits[3]);
  Card card44 = new Card(values[4], suits[3]);
  Card card43 = new Card(values[3], suits[3]);
  Card card42 = new Card(values[2], suits[3]);
  Card card14 = new Card(values[0], suits[1]);
  Card card4 = new Card(values[3], suits[0]);
  Card card3 = new Card(values[2], suits[0]);
  Card card2 = new Card(values[1], suits[0]);
  Card card1 = new Card(values[0], suits[0]);
  List<Card> deck0 = new ArrayList<Card>();
  List<Card> deck1 = new ArrayList<>(Arrays.asList(card1, card2));
  List<Card> deck2 = new ArrayList<>(Arrays.asList(card44, card43, card42));
  List<Card> deck3 = new ArrayList<>(Arrays.asList(card1, card2, card52));
  List<Card> deck4 = new ArrayList<>(Arrays.asList(card1, card2, card14));

  //Test illegal startplay method
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

  // Test startplay
  @Test
  public void teststartplayfor3players() {
    WhistTrumpModel game1 = new WhistTrumpModel();
    List<Card> deck1 = game1.getDeck();
    game1.startPlay(3, deck1);
    assertEquals("Number of players: 3\n" +
        "Player 1: A♣, J♣, 8♣, 5♣, 2♣, Q♦, 9♦, 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
        "Player 2: K♣, 10♣, 7♣, 4♣, A♦, J♦, 8♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
        "Player 3: Q♣, 9♣, 6♣, 3♣, K♦, 10♦, 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
        "Player 1: 0 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Turn: Player 1\n" +
        "Trump suit: ♣", game1.getGameState());

    assertEquals(3, game1.getListofWhistPlayer().size());
    assertEquals(card1, game1.getListofWhistPlayer().get(0).listCard.get(0));
    assertEquals(card2, game1.getListofWhistPlayer().get(1).listCard.get(0));
    assertEquals(card3, game1.getListofWhistPlayer().get(2).listCard.get(0));
    assertEquals(card52, game1.getListofWhistPlayer().get(0).listCard.get(17));
  }

  @Test
  public void teststartplayfor4players() {
    WhistTrumpModel game1 = new WhistTrumpModel();
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

  }

  //test hastrumpsuit method
  @Test
  public void testhastrumpsuitisClub() {
    WhistTrumpModel game1 = new WhistTrumpModel();
    List<Card> deckcard = game1.getDeck();
    game1.startPlay(4, deckcard);
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
    assertEquals(false, game1.hasTrumpSuit(deck0));
    assertEquals(false, game1.hasTrumpSuit(deck2));
    assertEquals(true, game1.hasTrumpSuit(deck1));


  }

  @Test
  public void testhastrumptsuitisDiamond() {
    WhistTrumpModel game1 = new WhistTrumpModel();
    List<Card> deckcard = game1.getDeck();
    deckcard.remove(13);
    deckcard.add(0, card14);
    game1.startPlay(4, deckcard);
    assertEquals("Number of players: 4\n" +
        "Player 1: J♣, 7♣, 3♣, A♦, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: A♣, 10♣, 6♣, 2♣, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: K♣, 9♣, 5♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: Q♣, 8♣, 4♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 0 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 1\n" +
        "Trump suit: ♦", game1.getGameState());
    assertEquals(false, game1.hasTrumpSuit(deck0));
    assertEquals(false, game1.hasTrumpSuit(deck2));
    assertEquals(false, game1.hasTrumpSuit(deck1));
    assertEquals(true, game1.hasTrumpSuit(deck4));
  }

  @Test
  public void testhastrumptsuitisSpade() {
    WhistTrumpModel game1 = new WhistTrumpModel();
    List<Card> deckcard = game1.getDeck();
    deckcard.remove(51);
    deckcard.add(0, card52);
    game1.startPlay(4, deckcard);
    assertEquals("Number of players: 4\n" +
        "Player 1: J♣, 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 2: A♣, 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 3: K♣, 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 4: Q♣, 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 1: 0 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 1\n" +
        "Trump suit: ♠", game1.getGameState());
    assertEquals(false, game1.hasTrumpSuit(deck0));
    assertEquals(true, game1.hasTrumpSuit(deck2));
    assertEquals(false, game1.hasTrumpSuit(deck1));
    assertEquals(false, game1.hasTrumpSuit(deck4));
    assertEquals(true, game1.hasTrumpSuit(deck3));
  }

  //test highestcard method
  @Test(expected = IllegalArgumentException.class)
  public void testhighestcardhastrumpsuitclubillegalplaytrump() {
    WhistTrumpModel game1 = new WhistTrumpModel();
    List<Card> deckcard = game1.getDeck();
    game1.startPlay(4, deckcard);
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
    assertEquals(0, game1.highestCard(deck1));
    game1.play(0, 7);
    game1.play(1, 7);
    game1.play(2, 7);
    game1.play(3, 0);
  }

  @Test
  public void testhighestcardhastrumpsuitclub() {
    WhistTrumpModel game1 = new WhistTrumpModel();
    List<Card> deckcard = game1.getDeck();
    game1.startPlay(4, deckcard);
    game1.getGameState();
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
    assertEquals(0, game1.highestCard(deck1));
  }

  @Test
  public void testhighestcardhastrumpsuitSpade() {
    WhistTrumpModel game1 = new WhistTrumpModel();
    List<Card> deckcard = game1.getDeck();
    deckcard.remove(51);
    deckcard.add(0, card52);
    game1.startPlay(4, deckcard);
    assertEquals("Number of players: 4\n" +
        "Player 1: J♣, 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 2: A♣, 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 3: K♣, 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 4: Q♣, 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 1: 0 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 1\n" +
        "Trump suit: ♠", game1.getGameState());
    assertEquals(2, game1.highestCard(deck3));
    game1.play(0, 0);
    game1.play(1, 0);
    game1.play(2, 0);
    game1.play(3, 0);
    game1.play(1, 0);
    game1.play(2, 0);
    game1.play(3, 0);
    game1.play(0, 0);
    game1.play(1, 0);
    game1.play(2, 0);
    game1.play(3, 0);
    game1.play(0, 0);
    assertEquals("Number of players: 4\n" +
        "Player 1: Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 2: 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 3: A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 4: K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 1: 0 hands won\n" +
        "Player 2: 3 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 2\n" +
        "Trump suit: ♠", game1.getGameState());
    game1.play(1, 0);
    game1.play(2, 7); //two players play trump suits
    game1.play(3, 7);
    game1.play(0, 0);
    assertEquals("Number of players: 4\n" +
        "Player 1: 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 2: J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 3: A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, 8♠, 4♠\n" +
        "Player 4: K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, 7♠, 3♠\n" +
        "Player 1: 0 hands won\n" +
        "Player 2: 3 hands won\n" +
        "Player 3: 1 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 3\n" +
        "Trump suit: ♠", game1.getGameState());
  }

  @Test
  public void testhighestcardhastrumpsuitSpadeplay() {
    WhistTrumpModel game1 = new WhistTrumpModel();
    List<Card> deckcard = game1.getDeck();
    deckcard.remove(51);
    deckcard.add(0, card52);
    game1.startPlay(4, deckcard);
    assertEquals("Number of players: 4\n" +
        "Player 1: J♣, 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 2: A♣, 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 3: K♣, 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 4: Q♣, 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 1: 0 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 1\n" +
        "Trump suit: ♠", game1.getGameState());
    assertEquals(2, game1.highestCard(deck3));
    game1.play(0, 12);
    game1.play(1, 12);
    game1.play(2, 12);
    game1.play(3, 12);
    assertEquals("Number of players: 4\n" +
        "Player 1: J♣, 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠\n" +
        "Player 2: A♣, 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠\n" +
        "Player 3: K♣, 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠\n" +
        "Player 4: Q♣, 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠\n" +
        "Player 1: 0 hands won\n" +
        "Player 2: 1 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 2\n" +
        "Trump suit: ♠", game1.getGameState());
    game1.play(1, 0);
    game1.play(2, 0);
    game1.play(3, 0);
    game1.play(0, 0);
    assertEquals("Number of players: 4\n" +
        "Player 1: 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠\n" +
        "Player 2: 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠\n" +
        "Player 3: 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠\n" +
        "Player 4: 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠\n" +
        "Player 1: 0 hands won\n" +
        "Player 2: 2 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 2\n" +
        "Trump suit: ♠", game1.getGameState());
    game1.play(1, 0);
    game1.play(2, 0);
    game1.play(3, 0);
    game1.play(0, 0);
    assertEquals("Number of players: 4\n" +
        "Player 1: 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠\n" +
        "Player 2: 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠\n" +
        "Player 3: 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠\n" +
        "Player 4: 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠\n" +
        "Player 1: 0 hands won\n" +
        "Player 2: 3 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 2\n" +
        "Trump suit: ♠", game1.getGameState());
    game1.play(1, 0);
    game1.play(2, 0);
    game1.play(3, 0);
    game1.play(0, 0);
    assertEquals("Number of players: 4\n" +
        "Player 1: Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠\n" +
        "Player 2: 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠\n" +
        "Player 3: A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠\n" +
        "Player 4: K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠\n" +
        "Player 1: 0 hands won\n" +
        "Player 2: 4 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 2\n" +
        "Trump suit: ♠", game1.getGameState());
    game1.play(1, 0);
    game1.play(2, 0);
    game1.play(3, 0);
    game1.play(0, 8); //Trump suit win that round
    assertEquals("Number of players: 4\n" +
        "Player 1: Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠\n" +
        "Player 2: J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠\n" +
        "Player 3: 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠\n" +
        "Player 4: 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠\n" +
        "Player 1: 1 hands won\n" +
        "Player 2: 4 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 1\n" +
        "Trump suit: ♠", game1.getGameState());
    game1.play(0, 7);
    game1.play(1, 7);
    game1.play(2, 7);
    game1.play(3, 7); // all play Trump suit
    assertEquals("Number of players: 4\n" +
        "Player 1: Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠\n" +
        "Player 2: J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠\n" +
        "Player 3: 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠\n" +
        "Player 4: 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠\n" +
        "Player 1: 2 hands won\n" +
        "Player 2: 4 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 1\n" +
        "Trump suit: ♠", game1.getGameState());
  }

  @Test
  public void testhigestcard5players() {
    WhistTrumpModel Trumpgame1 = new WhistTrumpModel();
    List<Card> deckcard = Trumpgame1.getDeck();
    Trumpgame1.startPlay(5, deckcard);
    Trumpgame1.play(0, 0);
    Trumpgame1.play(1, 0);
    Trumpgame1.play(2, 0);
    Trumpgame1.play(3, 0);
    Trumpgame1.play(4, 0);
    assertEquals(Arrays.asList(0), Trumpgame1.getwinners());
    assertEquals("Number of players: 5\n" +
        "Player 1: 9♣, 4♣, Q♦, 7♦, 2♦, 10♥, 5♥, K♠, 8♠, 3♠\n" +
        "Player 2: 8♣, 3♣, J♦, 6♦, A♥, 9♥, 4♥, Q♠, 7♠, 2♠\n" +
        "Player 3: 7♣, 2♣, 10♦, 5♦, K♥, 8♥, 3♥, J♠, 6♠\n" +
        "Player 4: 6♣, A♦, 9♦, 4♦, Q♥, 7♥, 2♥, 10♠, 5♠\n" +
        "Player 5: 5♣, K♦, 8♦, 3♦, J♥, 6♥, A♠, 9♠, 4♠\n" +
        "Player 1: 1 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Player 5: 0 hands won\n" +
        "Turn: Player 1\n" +
        "Trump suit: ♣", Trumpgame1.getGameState());
    Trumpgame1.play(0, 0);
    Trumpgame1.play(1, 0);
    Trumpgame1.play(2, 0);
    Trumpgame1.play(3, 0);
    Trumpgame1.play(4, 0);
    Trumpgame1.play(0, 0);
    Trumpgame1.play(1, 0);
    Trumpgame1.play(2, 0);
    Trumpgame1.play(3, 0);
    Trumpgame1.play(4, 0);
    Trumpgame1.play(0, 0);
    Trumpgame1.play(1, 0);
    Trumpgame1.play(2, 0);
    Trumpgame1.play(3, 0);
    Trumpgame1.play(4, 0);
    Trumpgame1.play(0, 0);
    Trumpgame1.play(1, 0);
    Trumpgame1.play(2, 0);
    Trumpgame1.play(3, 0);
    Trumpgame1.play(4, 0);
    Trumpgame1.play(0, 0);
    Trumpgame1.play(1, 0);
    Trumpgame1.play(2, 0);
    Trumpgame1.play(3, 0);
    Trumpgame1.play(4, 0);
    Trumpgame1.play(0, 0);
    Trumpgame1.play(1, 0);
    Trumpgame1.play(2, 0);
    Trumpgame1.play(3, 0);
    Trumpgame1.play(4, 0);
    Trumpgame1.play(0, 0);
    Trumpgame1.play(1, 0);
    Trumpgame1.play(2, 0);
    Trumpgame1.play(3, 0);
    Trumpgame1.play(4, 0);
    Trumpgame1.play(0, 0);
    Trumpgame1.play(1, 0);
    Trumpgame1.play(2, 0);
    Trumpgame1.play(3, 0);
    Trumpgame1.play(4, 0);
    Trumpgame1.play(0, 0);
    assertEquals("Number of players: 5\n" +
        "Player 1: 3♠\n" +
        "Player 2: 7♠, 2♠\n" +
        "Player 3: 6♠\n" +
        "Player 4: 5♠\n" +
        "Player 5: 4♠\n" +
        "Player 1: 9 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Player 5: 0 hands won\n" +
        "Turn: Player 2\n" +
        "Trump suit: ♣", Trumpgame1.getGameState());
    Trumpgame1.play(1, 0);
    Trumpgame1.play(2, 0);
    Trumpgame1.play(3, 0);
    Trumpgame1.play(4, 0);
    Trumpgame1.play(0, 0);
    Trumpgame1.play(1, 0);
    assertEquals(true, Trumpgame1.isGameOver());
    assertEquals("Number of players: 5\n" +
        "Player 1: \n" +
        "Player 2: \n" +
        "Player 3: \n" +
        "Player 4: \n" +
        "Player 5: \n" +
        "Player 1: 11 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Player 5: 0 hands won\n" +
        "Game over. Player 1  won.", Trumpgame1.getGameState());
  }

  //test getgamestate
  @Test
  public void testgetgamestate4players() {
    WhistTrumpModel Trumpgame1 = new WhistTrumpModel();
    List<Card> deckcard = Trumpgame1.getDeck();
    Trumpgame1.startPlay(4, deckcard);
    Trumpgame1.play(0, 0);
    Trumpgame1.play(1, 0);
    Trumpgame1.play(2, 0);
    Trumpgame1.play(3, 0);
    assertEquals("Number of players: 4\n" +
        "Player 1: 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 1 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 1\n" +
        "Trump suit: ♣", Trumpgame1.getGameState());
    Trumpgame1.play(0, 0);
    Trumpgame1.play(1, 0);
    Trumpgame1.play(2, 0);
    Trumpgame1.play(3, 0);
    Trumpgame1.play(0, 0);
    Trumpgame1.play(1, 0);
    Trumpgame1.play(2, 0);
    Trumpgame1.play(3, 0);
    Trumpgame1.play(0, 0);
    Trumpgame1.play(1, 0);
    Trumpgame1.play(2, 0);
    Trumpgame1.play(3, 0);
    Trumpgame1.play(0, 0);
    Trumpgame1.play(1, 0);
    Trumpgame1.play(2, 0);
    Trumpgame1.play(3, 0);
    Trumpgame1.play(0, 0);
    Trumpgame1.play(1, 0);
    Trumpgame1.play(2, 0);
    Trumpgame1.play(3, 0);
    Trumpgame1.play(0, 0);
    Trumpgame1.play(1, 0);
    Trumpgame1.play(2, 0);
    Trumpgame1.play(3, 0);
    Trumpgame1.play(0, 0);
    Trumpgame1.play(1, 0);
    Trumpgame1.play(2, 0);
    Trumpgame1.play(3, 0);
    Trumpgame1.play(0, 0);
    Trumpgame1.play(1, 0);
    Trumpgame1.play(2, 0);
    Trumpgame1.play(3, 0);
    Trumpgame1.play(0, 0);
    Trumpgame1.play(1, 0);
    Trumpgame1.play(2, 0);
    Trumpgame1.play(3, 0);
    assertEquals("Number of players: 4\n" +
        "Player 1: K♠, 9♠, 5♠\n" +
        "Player 2: Q♠, 8♠, 4♠\n" +
        "Player 3: J♠, 7♠, 3♠\n" +
        "Player 4: 10♠, 6♠, 2♠\n" +
        "Player 1: 10 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 1\n" +
        "Trump suit: ♣", Trumpgame1.getGameState());
    Trumpgame1.play(0, 0);
    Trumpgame1.play(1, 0);
    Trumpgame1.play(2, 0);
    Trumpgame1.play(3, 0);
    Trumpgame1.play(0, 0);
    Trumpgame1.play(1, 0);
    Trumpgame1.play(2, 0);
    Trumpgame1.play(3, 0);
    Trumpgame1.play(0, 0);
    Trumpgame1.play(1, 0);
    Trumpgame1.play(2, 0);
    Trumpgame1.play(3, 0);
    assertEquals("Number of players: 4\n" +
        "Player 1: \n" +
        "Player 2: \n" +
        "Player 3: \n" +
        "Player 4: \n" +
        "Player 1: 13 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Game over. Player 1  won.", Trumpgame1.getGameState());
  }

}
