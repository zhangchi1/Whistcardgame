package cs3500.hw04;

import java.util.Comparator;

import cs3500.hw02.Card;

/**
 * Created by chizhang on 2/18/16.
 */

/**
 * Create a CardComparator class to compare two cards
 */
public class CardComparator implements Comparator<Card> {


  /**
   * compare to card which one is before the other in the list
   *
   * @param o1 first card
   * @param o2 second card
   */
  @Override
  public int compare(Card o1, Card o2) {
    int o1SuitIdx = o1.getSuit().ordinal();
    int o2SuitIdx = o2.getSuit().ordinal();
    if (o1SuitIdx < o2SuitIdx) {
      return -1;
    } else if (o1SuitIdx > o2SuitIdx) {
      return 1;
    }
    //when two cards have same suit
    int o1ValueIdx = o1.getValue().ordinal();
    int o2ValueIdx = o2.getValue().ordinal();
    if (o1ValueIdx < o2ValueIdx) {
      return -1;
    } else if (o1ValueIdx > o2ValueIdx) {
      return 1;
    } else {
      return 0;
    }

  }


}
