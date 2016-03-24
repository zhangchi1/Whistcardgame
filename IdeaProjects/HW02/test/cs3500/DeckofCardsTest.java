package cs3500.hw02;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Test methods for DeckofCards
 */
public class DeckofCardsTest {
  /**
   * Test dealACard method
   */
  @Test
  public void testdealACard() {
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


    DeckofCards deckofCards1 = new DeckofCards();


    assertEquals(card1.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card2.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card3.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card4.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card5.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card6.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card7.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card8.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card9.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card10.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card11.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card12.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card13.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card14.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card15.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card16.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card17.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card18.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card19.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card20.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card21.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card22.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card23.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card24.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card25.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card26.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card27.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card28.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card29.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card30.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card31.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card32.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card33.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card34.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card35.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card36.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card37.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card38.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card39.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card40.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card41.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card42.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card43.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card44.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card45.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card46.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card47.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card48.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card49.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card50.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card51.CardtoString(), deckofCards1.dealACard().CardtoString());
    assertEquals(card52.CardtoString(), deckofCards1.dealACard().CardtoString());
  }
}
