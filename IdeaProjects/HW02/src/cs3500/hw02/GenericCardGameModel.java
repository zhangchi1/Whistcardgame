package cs3500.hw02;

import java.util.List;

/**
 * Represent a family of card games
 */
public interface GenericCardGameModel<K> {
  /**
   * @return an entire deck of cards, as a List<K>
   */
  List<K> getDeck();

  /**
   * @param numPlayers as  the number of players
   * @param listk      as deck of cards
   */
  void startPlay(int numPlayers, List<K> listk);

  /**
   * @return a String that contains the entire state of the game as follows, one on each line:
   * Number of players: N (printed as a normal decimal number) Player 1: cards in sorted order
   * (printed as a comma-separated list) Player 2: cards in sorted order (printed as a
   * comma-separated list) ... Player N: cards in sorted order (printed as a comma-separated list)
   */
  String getGameState();
}



