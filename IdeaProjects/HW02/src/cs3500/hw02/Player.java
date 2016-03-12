package cs3500.hw02;

import java.util.ArrayList;

/**
 * represents a player in the card game
 */
public class Player {

  /**
   * field the player`s number a list of card
   */
  public int playernum;
  public ArrayList<Card> listCard;

  /**
   * Construct a Player
   *
   * @param playernum represents the Player`s number
   */
  public Player(int playernum) {
    this.playernum = playernum;
    this.listCard = new ArrayList<Card>();
  }

  /**
   * 2nd Constructor for a Player
   *
   * @param playernum the Player`s number
   * @param listCard  the Player`s listofCards, each Player has a list of Cards
   */
  public Player(int playernum, ArrayList<Card> listCard) {
    this.playernum = playernum;
    this.listCard = listCard;
  }

  /**
   * add a Card to the player
   *
   * @param card add a Card to the Player`s listCard
   */
  public void addCardtoPlayer(Card card) {
    this.listCard.add(card);
  }


}
