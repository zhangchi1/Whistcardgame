package cs3500.hw03;

import cs3500.hw02.GenericCardGameModel;

/**
 * To represent a Card Game Model
 */
public interface CardGameModel<K> extends GenericCardGameModel<K> {
  /**
   * plays the card at index cardIdx in the set of cards for player number playerNo. It is assumed
   * that both player numbers and card indices begin with 0. It is further assumed that players’
   * hands are sorted.
   *
   * @param playerNo player`s number
   * @param cardIdx  plays the card at index cardIdx in the set of cards
   */
  void play(int playerNo, int cardIdx);

  /**
   * @return the player whose turn it is to play.
   */
  int getCurrentPlayer();

  /**
   * @return true if the game is over, false otherwise.
   */
  boolean isGameOver();
}
