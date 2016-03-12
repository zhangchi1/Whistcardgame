package cs3500.hw02;

import java.util.Objects;

/**
 * represents a playing card from a standard Poker deck, without Jokers (52 cards). The card
 * includes a suit, which can be clubs, diamonds, hearts, spades).  A spade, heart, diamond, or club
 * has one of the 13 values: 2, 3, 4, 5, 6, 7, 8, 9, 10, jack, queen, king, ace.  Note that "ace" is
 * considered to be the largest value.
 */

public class Card implements Comparable<Card> {

  /**
   * fields: Value and Suit of a card cannot be changed after the card is constructed.
   */
  private final Value value;
  private final Suit suit;


  /**
   * Construct a card with a specified suit and value.
   *
   * @param value the value of the card. The value must be in the range 2 through 14, with 14
   *              representing Ace. Because Ace is the highest card
   * @param suit  the suit of the card.  This must be one of the values Card.Club, Card.Diamonds,
   *              Card.Hearts, Card.Spades
   */


  public Card(Value value, Suit suit) {
    this.value = value;
    this.suit = suit;

  }

  /**
   * Compare two cards return int to decide how to sort a deck of card
   *
   * @param othercard a card
   * @return int
   */
  public int compareTo(Card othercard) {
    //when two cards have same suit
    if (othercard.suit.compareTo(this.suit) == 0) {
      if (othercard.value.compareTo(this.value) > 0) {
        return -1;
      } else if (othercard.value.compareTo(this.value) < 0) {
        return 1;
      } else return 0;
    }//end if

    else if (othercard.suit.compareTo(this.suit) > 0) {
      return -1;
    } else {
      return 1;
    }
  }

  /**
   * returns the string of a card
   *
   * @return a string to represent a card
   */
  public String CardtoString() {
    return this.value.stringValue() + this.suit.stringSuit();
  }


  /**
   * to represent the values of the standard deck
   */
  public enum Value {
    Ace(14), King(13), Queen(12), Jack(11), Ten(10), Nine(9), Eight(8),
    Seven(7), Six(6), Five(5), Four(4), Three(3), Two(2);

    private final int value;

    /**
     * @return Value
     */
    Value(int value) {
      this.value = value;
    }

    /**
     * get the value
     *
     * @return int
     */
    public int getValue() {
      return this.value;
    }

    /**
     * get a string for the cardvalue
     *
     * @return String
     */
    public String stringValue() {
      String ini = "";
      switch (value) {
        case 14:
          ini = "A";
          break;
        case 13:
          ini = "K";
          break;
        case 12:
          ini = "Q";
          break;
        case 11:
          ini = "J";
          break;
        case 10:
        case 9:
        case 8:
        case 7:
        case 6:
        case 5:
        case 4:
        case 3:
        case 2:
          ini = Integer.toString(value);
          break;
      }
      return ini;
    }
  }

  /**
   * to represent the suits of the standard deck
   */
  public enum Suit {
    Club("Clubs"), Diamond("Diamonds"), Heart("Hearts"), Spade("Spades");
    private final String suit;


    /**
     * get the suit as a string
     *
     * @return Value
     */
    Suit(String suit) {
      this.suit = suit;
    }

    /**
     * get the value
     *
     * @return String
     */
    public String getsuit() {
      return this.suit;
    }

    /**
     * get a string for the cardsuit
     *
     * @return String for the cardsuit
     */
    public String stringSuit() {
      if (this.suit == "Clubs") {
        return "♣";
      } else if (this.suit == "Diamonds") {
        return "♦";
      } else if (this.suit == "Hearts") {
        return "♥";
      } else {
        return "♠";
      }
    }
  }

  /**
   * override equals
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Card) {
      Card acard = (Card) obj;
      return
          this.CardtoString().equals(acard.CardtoString());
    } else return false;
  }

  /**
   * override hashcode
   */
  @Override
  public int hashCode() {
    return
        Objects.hash(this.CardtoString());
  }

  /**
   * return the card value
   */
  public Value getValue() {
    return this.value;
  }

  /**
   * return the card suit
   */
  public Suit getSuit() {
    return this.suit;
  }
}




