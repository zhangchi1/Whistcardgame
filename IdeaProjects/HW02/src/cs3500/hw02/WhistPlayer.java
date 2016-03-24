package cs3500.hw03;

import cs3500.hw02.Player;

import static cs3500.hw02.Card.*;

/**
 * Represents a Whist Game Player
 */
public class WhistPlayer extends Player {

  /**
   * fields
   */
  public int hands; // number of hands of that Player

  /**
   * Constructor for WhistPlayer
   */
  public WhistPlayer(int playernum) {
    super(playernum);
    this.hands = 0;
  }

  /**
   * Add a hand to the Player
   */
  public void addAHand() {
    this.hands = this.hands + 1;
  }

  /**
   * find If a player does not have a card of the same suit with A suit
   *
   * @return false if there is no card, true if there exists a card of the same suit
   */
  public boolean hasSameSuit(Suit aSuit) {
    boolean hasSuit = false;
    for (int i = 0; i < listCard.size(); i++) {
      if (listCard.get(i).getSuit() == aSuit) {
        hasSuit = true;
        break;

      } else hasSuit = hasSuit || false;
    }
    return hasSuit;

  }
}
