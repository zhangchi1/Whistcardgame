package cs3500.hw04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import cs3500.hw02.Card;
import cs3500.hw03.WhistModel;

import static org.junit.Assert.assertEquals;

/**
 * Created by chizhang on 2/23/16. Test method for CardComparator class
 */
public class CardComparatorTest {
  Card.Value values[] = Card.Value.values();
  Card.Suit suits[] = Card.Suit.values();
  Card card1 = new Card(values[0], suits[0]);  //A♣
  Card card2 = new Card(values[1], suits[0]);  //K♣
  Card card14 = new Card(values[2], suits[1]); //Q♦
  Card card27 = new Card(values[3], suits[2]); //J♥
  Card card40 = new Card(values[4], suits[3]); //10♠
  Card card49 = new Card(values[11], suits[3]);//3♠
  Card card50 = new Card(values[12], suits[3]);//2♠

  @Test
  public void testComparator() {
    cs3500.hw03.CardGameModel model = new WhistTrumpModel();
    List<Card> deck = testComparatorHelper(model.getDeck(), new CardComparator());
    model.startPlay(3, deck);
    WhistTrumpModel trumpgame1 = new WhistTrumpModel();
    List<Card> deck1 = trumpgame1.getDeck();
    Card card1 = deck1.remove(0);
    deck1.add(card1);
    Collections.sort(deck1);
    assertEquals(deck1, deck);
    assertEquals(deck1.get(0).CardtoString(), deck.get(0).CardtoString());
  }

  @Test
  public void testComparatorWhistmodel() {
    cs3500.hw03.CardGameModel model = new WhistTrumpModel();
    List<Card> deck = testComparatorHelper(model.getDeck(), new CardComparator());
    model.startPlay(3, deck);
    WhistModel Whistgame1 = new WhistModel();
    List<Card> deck1 = Whistgame1.getDeck();
    Card card1 = deck1.remove(0);
    Card card2 = deck1.remove(8);
    Card card3 = deck1.remove(20);
    deck1.add(card1);
    deck1.add(card2);
    deck1.add(card3);
    Collections.sort(deck1);
    assertEquals(deck1, deck);
    assertEquals("A♣", deck1.get(0).CardtoString());
    assertEquals("K♣", deck1.get(1).CardtoString());
    assertEquals("2♠", deck1.get(51).CardtoString());
    assertEquals("3♠", deck1.get(50).CardtoString());
    assertEquals(deck1.get(0).CardtoString(), deck.get(0).CardtoString());
  }

  @Test
  public void testComparatorWhistmodelwithoutstartplay() {
    cs3500.hw03.CardGameModel model = new WhistTrumpModel();
    List<Card> deck = testComparatorHelper(model.getDeck(), new CardComparator());


    List<Card> deck1 = new ArrayList<Card>(Arrays.asList(card1, card14, card2, card27, card40,
        card50,
        card49));
    assertEquals("A♣", deck1.get(0).CardtoString());
    assertEquals("3♠", deck1.get(6).CardtoString());
    Collections.sort(deck1);
    assertEquals(new ArrayList<Card>(Arrays.asList(card1, card2, card14, card27, card40, card49,
        card50)), deck1);
  }

  //
  @Test
  public void testComparatorwithtwocards() {
    CardComparator comparator1 = new CardComparator();
    assertEquals(-1, comparator1.compare(card1, card2));
    assertEquals(-1, comparator1.compare(card1, card14));
    assertEquals(-1, comparator1.compare(card2, card14));
    assertEquals(1, comparator1.compare(card14, card2));
    assertEquals(-1, comparator1.compare(card14, card27));
    assertEquals(0, comparator1.compare(card14, card14));
    assertEquals(-1, comparator1.compare(card49, card50));
    assertEquals(1, comparator1.compare(card40, card14));
  }

  private <S, T extends Comparator<S>> List<S> testComparatorHelper(List<S> list, T comparator) {
    List<S> temp = new ArrayList<S>();
    for (S item : list) {
      temp.add(item);
    }
    Collections.sort(temp, comparator);
    return temp;
  }

}
