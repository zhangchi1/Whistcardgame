package cs3500.hw02;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * test methods for Player
 */
public class PlayerTest {
  /**
   * Test addCardtoPlayer method
   */
  @Test
  public void addCardtoPlayertest() {
    Player p1 = new Player(1);
    Player p2 = new Player(2);
    Card.Value values[] = Card.Value.values();
    Card.Suit suits[] = Card.Suit.values();

    Card card2 = new Card(values[1], suits[0]);
    Card card1 = new Card(values[0], suits[0]);

    Card card14 = new Card(values[0], suits[1]);

    Card card27 = new Card(values[0], suits[2]);
    Card card52 = new Card(values[12], suits[3]);
    Card card51 = new Card(values[11], suits[3]);
    Card card50 = new Card(values[10], suits[3]);

    Card card40 = new Card(values[0], suits[3]);
    p1.addCardtoPlayer(card1);
    p1.addCardtoPlayer(card2);
    p1.addCardtoPlayer(card14);
    p1.addCardtoPlayer(card52);
    p2.addCardtoPlayer(card1);
    p2.addCardtoPlayer(card27);
    p2.addCardtoPlayer(card40);
    p2.addCardtoPlayer(card51);
    p2.addCardtoPlayer(card50);
    assertEquals(card1, p1.listCard.get(0));
    assertEquals(card2, p1.listCard.get(1));
    assertEquals(card14, p1.listCard.get(2));
    assertEquals(card52, p1.listCard.get(3));
    assertEquals(card1, p2.listCard.get(0));
    assertEquals(card27, p2.listCard.get(1));
    assertEquals(card40, p2.listCard.get(2));
    assertEquals(card51, p2.listCard.get(3));
    assertEquals(card50, p2.listCard.get(4));
  }
}
