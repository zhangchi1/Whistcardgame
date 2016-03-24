package cs3500.hw03;

import org.junit.Test;

import cs3500.hw02.Card;

import static org.junit.Assert.assertEquals;

/**
 * Test for WhistPlayer
 */
public class WhistPlayerTest {
  Card.Value values[] = Card.Value.values();
  Card.Suit suits[] = Card.Suit.values();
  WhistPlayer p1 = new WhistPlayer(1);
  Card card1 = new Card(values[12], suits[0]);
  Card card2 = new Card(values[11], suits[0]);
  Card card14 = new Card(values[0], suits[1]);
  WhistPlayer p2 = new WhistPlayer(2);
  WhistPlayer p3 = new WhistPlayer(3);

  /**
   * Test for addAHand method
   */
  @Test
  public void testaddAHand() {
    p1.addAHand();
    p1.addAHand();
    p3.addAHand();
    p3.addAHand();
    p3.addAHand();

    assertEquals(2, p1.hands);
    assertEquals(0, p2.hands);
    assertEquals(3, p3.hands);
  }


  /**
   * test for hasSameSuit method
   */
  @Test
  public void testhasSameSuit() {
    p1.addCardtoPlayer(card1);
    p1.addCardtoPlayer(card2);
    p1.addCardtoPlayer(card14);

    assertEquals(false, p1.hasSameSuit(Card.Suit.Spade));
    assertEquals(true, p1.hasSameSuit(Card.Suit.Club));
    assertEquals(true, p1.hasSameSuit(Card.Suit.Diamond));
    assertEquals(false, p1.hasSameSuit(Card.Suit.Heart));
    assertEquals(false, p2.hasSameSuit(Card.Suit.Club));
    assertEquals(false, p2.hasSameSuit(Card.Suit.Diamond));
    assertEquals(false, p2.hasSameSuit(Card.Suit.Heart));
    assertEquals(false, p2.hasSameSuit(Card.Suit.Spade));
  }
}
