package cs3500.hw02;

import org.junit.Test;

import static cs3500.hw02.Card.*;
import static org.junit.Assert.assertEquals;

/**
 * Test all the methods for Card
 */
public class CardTest {
  Value values[] = Card.Value.values();
  Suit suits[] = Card.Suit.values();
  Card card1 = new Card(values[0], suits[0]);
  Card card2 = new Card(values[1], suits[0]);
  Card card14 = new Card(values[2], suits[1]);
  Card card27 = new Card(values[3], suits[2]);
  Card card40 = new Card(values[4], suits[3]);
  Card card49 = new Card(values[11], suits[3]);
  Card card50 = new Card(values[12], suits[3]);


  /**
   * Test the getValue method
   */
  @Test
  public void testgetValue() {
    assertEquals("Ace", card1.getValue().toString());
    assertEquals("King", card2.getValue().toString());
    assertEquals("Queen", card14.getValue().toString());
    assertEquals("Jack", card27.getValue().toString());
    assertEquals("Ten", card40.getValue().toString());
    assertEquals("Three", card49.getValue().toString());
    assertEquals("Two", card50.getValue().toString());


  }

  /**
   * Test the getSuit method
   */
  @Test
  public void testgetSuit() {
    assertEquals("Club", card2.getSuit().toString());
    assertEquals("Diamond", card14.getSuit().toString());
    assertEquals("Heart", card27.getSuit().toString());
    assertEquals("Spade", card40.getSuit().toString());
    assertEquals("Spade", card49.getSuit().toString());
    assertEquals("Spade", card50.getSuit().toString());

  }

  /**
   * Test the CardtoString method
   */
  @Test
  public void testCardtoString() {
    assertEquals("A♣", card1.CardtoString());
    assertEquals("K♣", card2.CardtoString());
    assertEquals("Q♦", card14.CardtoString());
    assertEquals("J♥", card27.CardtoString());
    assertEquals("10♠", card40.CardtoString());
    assertEquals("3♠", card49.CardtoString());
    assertEquals("2♠", card50.CardtoString());

  }

  /**
   * Test for comparTo
   */
  @Test
  public void testcompareTo() {
    assertEquals(0, card1.compareTo(card1));
    assertEquals(-1, card1.compareTo(card2));
    assertEquals(-1, card2.compareTo(card14));
    assertEquals(-1, card40.compareTo(card50));
    assertEquals(1, card50.compareTo(card49));
  }

  @Test
  public void Testequals() {
    assertEquals(true, card1.equals(card1));
    assertEquals(true, card2.equals(card2));
    assertEquals(true, card14.equals(card14));
    assertEquals(true, card27.equals(card27));
    assertEquals(true, card40.equals(card40));
    assertEquals(false, card1.equals(card2));
    assertEquals(false, card14.equals(card2));
    assertEquals(false, card27.equals(card14));
    assertEquals(false, card40.equals(card27));
  }

  @Test
  public void Testhashcode() {
    assertEquals(11873, card1.hashCode());
    assertEquals(12183, card2.hashCode());
    assertEquals(12372, card14.hashCode());
    assertEquals(12154, card27.hashCode());
    assertEquals(58432, card40.hashCode());
  }
}
