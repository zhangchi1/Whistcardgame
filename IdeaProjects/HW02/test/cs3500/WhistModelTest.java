package cs3500.hw03;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cs3500.hw02.Card;

import static org.junit.Assert.assertEquals;

/**
 * Test methods for WhistModel
 */
public class WhistModelTest {
  Card.Value values[] = Card.Value.values();
  Card.Suit suits[] = Card.Suit.values();
  Card card13 = new Card(values[12], suits[0]);
  Card card12 = new Card(values[11], suits[0]);
  Card card11 = new Card(values[10], suits[0]);
  Card card10 = new Card(values[9], suits[0]);
  Card card9 = new Card(values[8], suits[0]);
  Card card8 = new Card(values[7], suits[0]);
  Card card7 = new Card(values[6], suits[0]);
  Card card6 = new Card(values[5], suits[0]);
  Card card5 = new Card(values[4], suits[0]);
  Card card4 = new Card(values[3], suits[0]);
  Card card3 = new Card(values[2], suits[0]);
  Card card2 = new Card(values[1], suits[0]);
  Card card1 = new Card(values[0], suits[0]);
  Card card26 = new Card(values[12], suits[1]);
  Card card25 = new Card(values[11], suits[1]);
  Card card24 = new Card(values[10], suits[1]);
  Card card23 = new Card(values[9], suits[1]);
  Card card22 = new Card(values[8], suits[1]);
  Card card21 = new Card(values[7], suits[1]);
  Card card20 = new Card(values[6], suits[1]);
  Card card19 = new Card(values[5], suits[1]);
  Card card18 = new Card(values[4], suits[1]);
  Card card17 = new Card(values[3], suits[1]);
  Card card16 = new Card(values[2], suits[1]);
  Card card15 = new Card(values[1], suits[1]);
  Card card14 = new Card(values[0], suits[1]);
  Card card39 = new Card(values[12], suits[2]);
  Card card38 = new Card(values[11], suits[2]);
  Card card37 = new Card(values[10], suits[2]);
  Card card36 = new Card(values[9], suits[2]);
  Card card35 = new Card(values[8], suits[2]);
  Card card34 = new Card(values[7], suits[2]);
  Card card33 = new Card(values[6], suits[2]);
  Card card32 = new Card(values[5], suits[2]);
  Card card31 = new Card(values[4], suits[2]);
  Card card30 = new Card(values[3], suits[2]);
  Card card29 = new Card(values[2], suits[2]);
  Card card28 = new Card(values[1], suits[2]);
  Card card27 = new Card(values[0], suits[2]);
  Card card52 = new Card(values[12], suits[3]);
  Card card51 = new Card(values[11], suits[3]);
  Card card50 = new Card(values[10], suits[3]);
  Card card49 = new Card(values[9], suits[3]);
  Card card48 = new Card(values[8], suits[3]);
  Card card47 = new Card(values[7], suits[3]);
  Card card46 = new Card(values[6], suits[3]);
  Card card45 = new Card(values[5], suits[3]);
  Card card44 = new Card(values[4], suits[3]);
  Card card43 = new Card(values[3], suits[3]);
  Card card42 = new Card(values[2], suits[3]);
  Card card41 = new Card(values[1], suits[3]);
  Card card40 = new Card(values[0], suits[3]);
  List<Card> deck1 = new ArrayList<Card>(Arrays.asList(card1, card2, card40, card50, card27));
  List<Card> deck2 = new ArrayList<Card>(Arrays.asList(card48, card49, card50, card47));
  List<Card> deck3 = new ArrayList<Card>(Arrays.asList(card10, card48, card49, card50, card47));
  List<Card> deck4 = new ArrayList<Card>(Arrays.asList(card10, card48, card1, card49, card50,
      card47));
  List<Card> deck5 = new ArrayList<Card>(Arrays.asList(card1, card2, card3, card4, card6, card5,
      card7, card8, card9, card10, card11, card12, card13, card14, card15, card16, card18, card17,
      card19,
      card20, card22, card21, card23, card24, card26, card25, card27, card28, card30, card29,
      card31,
      card32, card34, card33, card35, card36, card40, card38, card39, card37, card41, card42,
      card43, card44, card45, card46, card47, card48, card49, card50, card51, card52));


  /**
   * Test for highestCard
   */
  @Test
  public void highestCardtestwithoutplay() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck0 = whistgame1.getDeck();
    whistgame1.startPlay(3, deck0);
    assertEquals(3, whistgame1.getListofWhistPlayer().size());
    assertEquals(4, whistgame1.highestCard(deck1));
    assertEquals(3, whistgame1.highestCard(deck2));

  }

  @Test
  public void highestCardtestwithplayClubascurrentsuit() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck0 = whistgame1.getDeck();
    whistgame1.startPlay(4, deck0);
    whistgame1.play(0, 2);
    assertEquals(4, whistgame1.getListofWhistPlayer().size());
    assertEquals(0, whistgame1.highestCard(deck3));
    assertEquals(2, whistgame1.highestCard(deck4));
  }

  /**
   * Test for isValidPlay Does not control which player's turn to play
   */
  @Test
  public void testisValidPlay4players() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck0 = whistgame1.getDeck();
    whistgame1.startPlay(4, deck0);
    whistgame1.play(0, 2);
    assertEquals(true, whistgame1.isValidPlay(0, 1));
    assertEquals(true, whistgame1.isValidPlay(1, 1));
    assertEquals(true, whistgame1.isValidPlay(1, 2));
    assertEquals(true, whistgame1.isValidPlay(1, 2));
    assertEquals(true, whistgame1.isValidPlay(2, 2));
    assertEquals(true, whistgame1.isValidPlay(3, 2));
    assertEquals(false, whistgame1.isValidPlay(1, 10));
    assertEquals(false, whistgame1.isValidPlay(2, 10));
    assertEquals(false, whistgame1.isValidPlay(2, 4));
    assertEquals(false, whistgame1.isValidPlay(2, 10));
    assertEquals(false, whistgame1.isValidPlay(3, 10));
    assertEquals(false, whistgame1.isValidPlay(3, 4));
    assertEquals(false, whistgame1.isValidPlay(3, 10));
  }

  /**
   * Test for startPlay method 3 players
   */
  @Test
  public void teststartPlayfor3Players() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck1 = whistgame1.getDeck();

    whistgame1.startPlay(3, deck1);

    assertEquals(3, whistgame1.getListofWhistPlayer().size());
    assertEquals(card1, whistgame1.getListofWhistPlayer().get(0).listCard.get(0));
    assertEquals(card2, whistgame1.getListofWhistPlayer().get(1).listCard.get(0));
    assertEquals(card3, whistgame1.getListofWhistPlayer().get(2).listCard.get(0));
    assertEquals(card52, whistgame1.getListofWhistPlayer().get(0).listCard.get(17));
  }

  /**
   * Test for startPlay method for 53 players
   */
  @Test
  public void teststartPlayfor53Players() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck1 = whistgame1.getDeck();

    whistgame1.startPlay(53, deck1);

    assertEquals(53, whistgame1.getListofWhistPlayer().size());
    assertEquals(card1, whistgame1.getListofWhistPlayer().get(0).listCard.get(0));
    assertEquals(card2, whistgame1.getListofWhistPlayer().get(1).listCard.get(0));
    assertEquals(card3, whistgame1.getListofWhistPlayer().get(2).listCard.get(0));
    assertEquals(card52, whistgame1.getListofWhistPlayer().get(51).listCard.get(0));
    assertEquals(card52, whistgame1.getListofWhistPlayer().get(51).listCard.get(0));
    assertEquals(0, whistgame1.getListofWhistPlayer().get(52).listCard.size());
  }

  /**
   * Test for Illegal game
   */
  @Test(expected = IllegalArgumentException.class)
  public void testillegalstartPlay() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck1 = whistgame1.getDeck();
    List<Card> deck2 = new ArrayList<Card>(Arrays.asList(card1, card2));
    List<Card> deck3 = new ArrayList<Card>(Arrays.asList(card1, card1));
    whistgame1.startPlay(1, deck1);
    whistgame1.startPlay(0, deck1);
    whistgame1.startPlay(2, deck2);
    whistgame1.startPlay(52, deck2);
    whistgame1.startPlay(52, deck3);
    whistgame1.startPlay(53, deck3);
    whistgame1.startPlay(3, deck3);
  }


  /**
   * Test for Illegal Argument for getCurrentPlayer method
   */
  @Test(expected = IllegalArgumentException.class)
  public void testgetCurrentPlayerwithoutstartplay() {
    WhistModel whistgame1 = new WhistModel();
    assertEquals(0, whistgame1.getCurrentPlayer());
  }


  /**
   * Test for getCurrentPlayer method
   */
  @Test
  public void getCurentPlayertest3playerswithplay() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck3 = whistgame1.getDeck();
    whistgame1.startPlay(3, deck3);
    assertEquals(0, whistgame1.getCurrentPlayer());
    //round1 player1: Q♦
    whistgame1.play(0, 5);
    assertEquals(1, whistgame1.getCurrentPlayer());
    //round1 player2: A♦
    whistgame1.play(1, 4);
    assertEquals(2, whistgame1.getCurrentPlayer());
    //round1 player3: 4♦
    whistgame1.play(2, 7);
    assertEquals(1, whistgame1.getCurrentPlayer());
    //round2 player2: Q♥
    whistgame1.play(1, 8);
    assertEquals(2, whistgame1.getCurrentPlayer());
    //round2 player3: A♥
    whistgame1.play(2, 7);
    assertEquals(0, whistgame1.getCurrentPlayer());
    //round2 player1: K♥
    whistgame1.play(0, 8);
    assertEquals(2, whistgame1.getCurrentPlayer());

  }

  /**
   * test for play method
   */
  @Test
  public void test3playerswithplaymethod() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck3 = whistgame1.getDeck();
    whistgame1.startPlay(3, deck3);
    assertEquals(3, whistgame1.getListofWhistPlayer().size());
    assertEquals(18, whistgame1.getListofWhistPlayer().get(0).listCard.size());
    assertEquals(17, whistgame1.getListofWhistPlayer().get(1).listCard.size());
    assertEquals(17, whistgame1.getListofWhistPlayer().get(2).listCard.size());
    assertEquals(0, whistgame1.getListofWhistPlayer().get(0).hands);
    assertEquals(0, whistgame1.getListofWhistPlayer().get(1).hands);
    assertEquals(0, whistgame1.getListofWhistPlayer().get(2).hands);
    assertEquals(null, whistgame1.CurrentSuit);
    assertEquals(0, whistgame1.IndexofLastWinner);
    assertEquals(0, whistgame1.CurrentHandCards.size());
    //round1 player1: Q♦
    whistgame1.play(0, 5);
    assertEquals(3, whistgame1.getListofWhistPlayer().size());
    assertEquals(17, whistgame1.getListofWhistPlayer().get(0).listCard.size());
    assertEquals(17, whistgame1.getListofWhistPlayer().get(1).listCard.size());
    assertEquals(17, whistgame1.getListofWhistPlayer().get(2).listCard.size());
    assertEquals(0, whistgame1.getListofWhistPlayer().get(0).hands);
    assertEquals(0, whistgame1.getListofWhistPlayer().get(1).hands);
    assertEquals(0, whistgame1.getListofWhistPlayer().get(2).hands);
    assertEquals("Diamond", whistgame1.CurrentSuit.toString());
    assertEquals(0, whistgame1.IndexofLastWinner);
    assertEquals(1, whistgame1.CurrentHandCards.size());
    //round1 player2: A♦
    whistgame1.play(1, 4);
    assertEquals(3, whistgame1.getListofWhistPlayer().size());
    assertEquals(17, whistgame1.getListofWhistPlayer().get(0).listCard.size());
    assertEquals(16, whistgame1.getListofWhistPlayer().get(1).listCard.size());
    assertEquals(17, whistgame1.getListofWhistPlayer().get(2).listCard.size());
    assertEquals(0, whistgame1.getListofWhistPlayer().get(0).hands);
    assertEquals(0, whistgame1.getListofWhistPlayer().get(1).hands);
    assertEquals(0, whistgame1.getListofWhistPlayer().get(2).hands);
    assertEquals("Diamond", whistgame1.CurrentSuit.toString());
    assertEquals(0, whistgame1.IndexofLastWinner);
    assertEquals(2, whistgame1.CurrentHandCards.size());
    //round1 player3: 4♦
    whistgame1.play(2, 7);
    assertEquals(3, whistgame1.getListofWhistPlayer().size());
    assertEquals(17, whistgame1.getListofWhistPlayer().get(0).listCard.size());
    assertEquals(16, whistgame1.getListofWhistPlayer().get(1).listCard.size());
    assertEquals(16, whistgame1.getListofWhistPlayer().get(2).listCard.size());
    assertEquals(0, whistgame1.getListofWhistPlayer().get(0).hands);
    assertEquals(1, whistgame1.getListofWhistPlayer().get(1).hands);
    assertEquals(0, whistgame1.getListofWhistPlayer().get(2).hands);
    assertEquals(null, whistgame1.CurrentSuit);
    assertEquals(1, whistgame1.IndexofLastWinner);
    assertEquals(0, whistgame1.CurrentHandCards.size());
    //round2 player2: Q♥
    whistgame1.play(1, 8);
    assertEquals(3, whistgame1.getListofWhistPlayer().size());
    assertEquals(17, whistgame1.getListofWhistPlayer().get(0).listCard.size());
    assertEquals(15, whistgame1.getListofWhistPlayer().get(1).listCard.size());
    assertEquals(16, whistgame1.getListofWhistPlayer().get(2).listCard.size());
    assertEquals(0, whistgame1.getListofWhistPlayer().get(0).hands);
    assertEquals(1, whistgame1.getListofWhistPlayer().get(1).hands);
    assertEquals(0, whistgame1.getListofWhistPlayer().get(2).hands);
    assertEquals("Heart", whistgame1.CurrentSuit.toString());
    assertEquals(1, whistgame1.IndexofLastWinner);
    assertEquals(1, whistgame1.CurrentHandCards.size());
    //round2 player3: A♥
    whistgame1.play(2, 7);
    assertEquals(3, whistgame1.getListofWhistPlayer().size());
    assertEquals(17, whistgame1.getListofWhistPlayer().get(0).listCard.size());
    assertEquals(15, whistgame1.getListofWhistPlayer().get(1).listCard.size());
    assertEquals(15, whistgame1.getListofWhistPlayer().get(2).listCard.size());
    assertEquals(0, whistgame1.getListofWhistPlayer().get(0).hands);
    assertEquals(1, whistgame1.getListofWhistPlayer().get(1).hands);
    assertEquals(0, whistgame1.getListofWhistPlayer().get(2).hands);
    assertEquals("Heart", whistgame1.CurrentSuit.toString());
    assertEquals(1, whistgame1.IndexofLastWinner);
    assertEquals(2, whistgame1.CurrentHandCards.size());
    //round2 player1: K♥
    whistgame1.play(0, 8);
    assertEquals(3, whistgame1.getListofWhistPlayer().size());
    assertEquals(16, whistgame1.getListofWhistPlayer().get(0).listCard.size());
    assertEquals(15, whistgame1.getListofWhistPlayer().get(1).listCard.size());
    assertEquals(15, whistgame1.getListofWhistPlayer().get(2).listCard.size());
    assertEquals(0, whistgame1.getListofWhistPlayer().get(0).hands);
    assertEquals(1, whistgame1.getListofWhistPlayer().get(1).hands);
    assertEquals(1, whistgame1.getListofWhistPlayer().get(2).hands);
    assertEquals(null, whistgame1.CurrentSuit);
    assertEquals(2, whistgame1.IndexofLastWinner);
    assertEquals(0, whistgame1.CurrentHandCards.size());
  }

  /**
   * test for illegal argument for play method
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalplaywithoutstartplay() {
    WhistModel whistgame1 = new WhistModel();
    whistgame1.play(0, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalplaynotcurrentplayerplayer2() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck3 = whistgame1.getDeck();
    whistgame1.startPlay(3, deck3);
    //Illegal currentplayer
    whistgame1.play(1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalplaynotcurrentplayerplayer3() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck3 = whistgame1.getDeck();
    whistgame1.startPlay(3, deck3);
    //Illegal currentplayer
    whistgame1.play(2, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalplaynotcurrentplayer1stround() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck3 = whistgame1.getDeck();
    whistgame1.startPlay(3, deck3);
    whistgame1.play(0, 5);
    whistgame1.play(1, 4);
    whistgame1.play(1, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalplaynotcurrentplayer2ndround() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck3 = whistgame1.getDeck();
    whistgame1.startPlay(3, deck3);
    whistgame1.play(0, 5);
    whistgame1.play(1, 4);
    whistgame1.play(2, 7);
    whistgame1.play(2, 7);//not this player's turn
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalplaynotrightsuit() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck3 = whistgame1.getDeck();
    whistgame1.startPlay(3, deck3);
    whistgame1.play(0, 0);
    whistgame1.play(1, 1);
    whistgame1.play(2, 1);
    whistgame1.play(0, 5);
    whistgame1.play(1, 1);//should be suit: Club
  }


  @Test(expected = IllegalArgumentException.class)
  public void testIllegalplaycardIndexlessthan0() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck3 = whistgame1.getDeck();
    whistgame1.startPlay(3, deck3);
    whistgame1.play(0, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalplaynotcurrentplayer2() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck3 = whistgame1.getDeck();
    whistgame1.startPlay(3, deck3);
    //Illegal currentplayer
    whistgame1.play(1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalplaynotcurrentplayer3() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck3 = whistgame1.getDeck();
    whistgame1.startPlay(3, deck3);
    //Illegal currentplayer
    whistgame1.play(2, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalplaywhenGameisOver() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck3 = whistgame1.getDeck();
    whistgame1.startPlay(3, deck3);
    whistgame1.play(2, 0);

  }

  /**
   * Test for isGameOver method IllegalArgument Exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testisGameOverwithoutStartplay() {
    WhistModel whistgame1 = new WhistModel();
    whistgame1.play(0, 0);
    whistgame1.isGameOver();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testisGameOverwithoutstartplayandplay() {
    WhistModel whistgame1 = new WhistModel();
    whistgame1.isGameOver();
  }

  /**
   * test for isGameOver method
   */
  @Test
  public void testisGameOverwithoutplay() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck0 = whistgame1.getDeck();
    whistgame1.startPlay(4, deck0);
    assertEquals(false, whistgame1.isGameOver());
  }

  @Test
  public void testisGameOverplaytworound() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck3 = whistgame1.getDeck();
    whistgame1.startPlay(3, deck3);
    whistgame1.play(0, 0);
    whistgame1.play(1, 1);
    whistgame1.play(2, 1);
    whistgame1.play(0, 5);
    assertEquals(false, whistgame1.isGameOver());
  }

  @Test
  public void testisGameOverplayfullgame3palyers() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck3 = whistgame1.getDeck();
    whistgame1.startPlay(3, deck3);
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(0, 0);//2nd
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(0, 0);//3rd
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(0, 0);//4th
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    assertEquals(0, whistgame1.getCurrentPlayer());
    whistgame1.play(0, 0);//5th
    assertEquals("Club", whistgame1.CurrentSuit.toString());
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    assertEquals(0, whistgame1.IndexofLastWinner);
    assertEquals(null, whistgame1.CurrentSuit);
    whistgame1.play(0, 0);//6th
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(0, 0);//7th
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(0, 0);//8th
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(0, 0);//9th
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    assertEquals(false, whistgame1.isGameOver());
    whistgame1.play(0, 0);//10th
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(0, 0);//11th
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(0, 0);//12th
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(0, 0);//13th
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(0, 0);//14th
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(0, 0);//15th
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(0, 0);//16th
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(0, 0);//17th
    assertEquals("Number of players: 3\n" +
        "Player 1: 2♠\n" +
        "Player 2: 4♠\n" +
        "Player 3: 3♠\n" +
        "Player 1: 16 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Turn: Player 2", whistgame1.getGameState());
    whistgame1.play(1, 0);
    assertEquals(2, whistgame1.getCurrentPlayer());

    whistgame1.play(2, 0);
    assertEquals(null, whistgame1.CurrentSuit);
    assertEquals("Number of players: 3\n" +
        "Player 1: 2♠\n" +
        "Player 2: \n" +
        "Player 3: \n" +
        "Player 1: 17 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Game over. Player 1  won.", whistgame1.getGameState());
    assertEquals(true, whistgame1.isGameOver());
  }

  @Test
  public void testisGameOverplayfullgame4palyers() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck3 = whistgame1.getDeck();
    whistgame1.startPlay(4, deck3);
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);//2nd
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);//3rd
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);//4th
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);//5th
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);//6th
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);//7th
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);//8th
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);//9th
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);//10th
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);//11th
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);//12th
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);//13th
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    assertEquals(false, whistgame1.isGameOver());
    whistgame1.play(3, 0);
    assertEquals("Number of players: 4\n" +
        "Player 1: \n" +
        "Player 2: \n" +
        "Player 3: \n" +
        "Player 4: \n" +
        "Player 1: 13 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Game over. Player 1  won.", whistgame1.getGameState());
    assertEquals(true, whistgame1.isGameOver());
  }

  /**
   * test for getGameState
   */
  @Test(expected = IllegalArgumentException.class)
  public void testgetGameStatewithoutstartplay() {
    WhistModel whistgame1 = new WhistModel();
    whistgame1.getGameState();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testgetGameStateIlegalstartplay() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck0 = whistgame1.getDeck();
    whistgame1.startPlay(1, deck0);
    whistgame1.getGameState();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testgetGameStateIlegalplay() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck0 = whistgame1.getDeck();
    whistgame1.startPlay(4, deck0);
    whistgame1.play(1, 0);
    whistgame1.getGameState();
  }

  @Test
  public void testgetGameStatewithoutplay() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck3 = whistgame1.getDeck();
    whistgame1.startPlay(4, deck3);
    assertEquals("Number of players: 4\n" +
        "Player 1: A♣, 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 2: K♣, 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 3: Q♣, 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 4: J♣, 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 1: 0 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 1", whistgame1.getGameState());
  }

  @Test
  public void testgetGameStateplayunordereddeck() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck3 = whistgame1.getDeck();
    deck3.remove(5);
    deck3.add(card6);
    deck3.remove(3);
    deck3.add(card4);
    whistgame1.startPlay(4, deck3);
    whistgame1.play(0, 0);
    assertEquals("Number of players: 4\n" +
        "Player 1: 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
        "Player 2: K♣, 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
        "Player 3: Q♣, 9♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
        "Player 4: J♣, 10♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
        "Player 1: 0 hands won\n" +
        "Player 2: 0 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 0 hands won\n" +
        "Turn: Player 2", whistgame1.getGameState());
  }

  @Test
  public void testgetGameStatewith4players() {
    WhistModel whistgame1 = new WhistModel();
    whistgame1.startPlay(4, deck5);
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);//2nd
    assertEquals(0, whistgame1.getCurrentPlayer());
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);//3rd
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);
    whistgame1.play(0, 0);//4th
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);//5th
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);//6th
    assertEquals(1, whistgame1.getCurrentPlayer());
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);
    whistgame1.play(0, 0);//7th
    //assertEquals("", whistgame1.getGameState());
    whistgame1.play(1, 0);
    assertEquals(2, whistgame1.getCurrentPlayer());
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);
    whistgame1.play(0, 0);//8th
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);
    whistgame1.play(0, 0);//9th
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);
    whistgame1.play(0, 0);//10th

    assertEquals(1, whistgame1.getCurrentPlayer());
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);
    whistgame1.play(0, 0);//11th
    whistgame1.play(3, 0);
    assertEquals("Number of players: 4\n" +
        "Player 1: K♠, 9♠, 5♠\n" +
        "Player 2: Q♠, 8♠, 4♠\n" +
        "Player 3: J♠, 7♠, 3♠\n" +
        "Player 4: 6♠, 2♠\n" +
        "Player 1: 3 hands won\n" +
        "Player 2: 6 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 1 hands won\n" +
        "Turn: Player 1", whistgame1.getGameState());
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);//12th
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);//13th
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);
    assertEquals(Arrays.asList(0, 1), whistgame1.getwinners());
    assertEquals("Number of players: 4\n" +
        "Player 1: \n" +
        "Player 2: \n" +
        "Player 3: \n" +
        "Player 4: \n" +
        "Player 1: 6 hands won\n" +
        "Player 2: 6 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Player 4: 1 hands won\n" +
        "Game over. Player 1 Player 2  won.", whistgame1.getGameState());
    assertEquals(true, whistgame1.isGameOver());
    assertEquals(2, whistgame1.getCurrentPlayer());
  }

  /**
   * Test special message method
   */
  @Test(expected = IllegalArgumentException.class)
  public void testsepcialmessagewithoutstartplay() {
    WhistModel whistgame1 = new WhistModel();
    whistgame1.specialmessage();
  }

  @Test
  public void testsepcialmessagewithoutplay() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck3 = whistgame1.getDeck();
    whistgame1.startPlay(3, deck3);
    whistgame1.specialmessage();
    assertEquals("Turn: Player 1", whistgame1.specialmessage());
  }

  @Test
  public void testsepcialmessageDuringtheGame1Playerwon() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck3 = whistgame1.getDeck();
    whistgame1.startPlay(3, deck3);
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    assertEquals("Turn: Player 3", whistgame1.specialmessage());
    whistgame1.play(2, 0);
    whistgame1.play(0, 0);//2nd
    whistgame1.play(1, 0);
    assertEquals("Turn: Player 3", whistgame1.specialmessage());
    whistgame1.play(2, 0);
    whistgame1.play(0, 0);//3rd
    assertEquals("Turn: Player 2", whistgame1.specialmessage());
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    assertEquals("Turn: Player 1", whistgame1.specialmessage());
    whistgame1.play(0, 0);//4th
    whistgame1.play(1, 0);
    assertEquals("Turn: Player 3", whistgame1.specialmessage());
    whistgame1.play(2, 0);
    whistgame1.play(0, 0);//5th
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(0, 0);//6th
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(0, 0);//7th
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(0, 0);//8th
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(0, 0);//9th
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(0, 0);//10th
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(0, 0);//11th
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(0, 0);//12th
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(0, 0);//13th
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(0, 0);//14th
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(0, 0);//15th
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(0, 0);//16th
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(0, 0);//17th
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    assertEquals(0, whistgame1.getCurrentPlayer());
    assertEquals("Game over. Player 1  won.", whistgame1.specialmessage());
    assertEquals(0, whistgame1.getCurrentPlayer());
  }

  @Test
  public void testsepcialmessageDuringtheGame2Playerswon() {

  }

  /**
   * test for getwinners method
   */
  @Test
  public void testgetwinnerswithoutplay() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck3 = whistgame1.getDeck();
    whistgame1.startPlay(3, deck3);
    assertEquals(Arrays.asList(0, 1, 2), whistgame1.getwinners());
  }

  @Test
  public void testgetwinnerswithplay1winner() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck3 = whistgame1.getDeck();
    whistgame1.startPlay(3, deck3);
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(0, 0);//2nd
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    assertEquals(Arrays.asList(0), whistgame1.getwinners());
    assertEquals(1, whistgame1.getwinners().size());
  }

  @Test
  public void testgetwinnerswithplay2winners() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck3 = whistgame1.getDeck();
    whistgame1.startPlay(4, deck3);
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);//2nd
    assertEquals(null, whistgame1.CurrentSuit);
    whistgame1.play(0, 1);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);
    assertEquals(Arrays.asList(0, 1), whistgame1.getwinners());
  }

  @Test
  public void testgetwinnerswithplay5players() {
    WhistModel whistgame1 = new WhistModel();
    List<Card> deck3 = whistgame1.getDeck();
    whistgame1.startPlay(5, deck3);
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);
    whistgame1.play(4, 0);
    assertEquals(null, whistgame1.CurrentSuit);
    assertEquals(Arrays.asList(0), whistgame1.getwinners());
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
        "Turn: Player 1", whistgame1.getGameState());
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);
    whistgame1.play(4, 0);
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);
    whistgame1.play(4, 0);
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);
    whistgame1.play(4, 0);
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);
    whistgame1.play(4, 0);
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);
    whistgame1.play(4, 0);
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);
    whistgame1.play(4, 0);
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);
    whistgame1.play(4, 0);
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);
    whistgame1.play(4, 0);
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    whistgame1.play(2, 0);
    whistgame1.play(3, 0);
    whistgame1.play(4, 0);
    whistgame1.play(0, 0);
    whistgame1.play(1, 0);
    assertEquals(true, whistgame1.isGameOver());
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
        "Game over. Player 1  won.", whistgame1.getGameState());
  }

}
