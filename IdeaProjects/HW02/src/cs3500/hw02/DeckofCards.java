package cs3500.hw02;

import java.util.Random;

import static cs3500.hw02.Card.*;

/**
 * To represents a deck of cards
 */
public class DeckofCards {
  protected Card deckofCard[]; //array of cards
  protected int firstCard; // the index of the first card
  protected Random randomNum; // the random number generator in order to
  // returns a random order of deck of cards

  /**
   * Construct a deck of cards, represent all 52 cards
   */
  public DeckofCards() {
    Value cardValues[] = Value.values();
    Suit cardSuits[] = Suit.values();
    deckofCard = new Card[52]; //array of cards 52cards in total
    firstCard = 0; //set the first card
    randomNum = new Random();

    //get the entire deck of cards
    for (int cardnum = 0; cardnum < deckofCard.length; cardnum++) {
      deckofCard[cardnum] = new Card(cardValues[cardnum % 13], cardSuits[cardnum / 13]);
    }
  }

  /**
   * deal a Card to the game. Each time deal one Card
   *
   * @return Card, deal a Card to the game
   */
  public Card dealACard() {
    if (firstCard < deckofCard.length)
      return deckofCard[firstCard++];

    else
      return null; //all cards are dealed
  }
}

