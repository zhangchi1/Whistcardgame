package cs3500.hw03;

/**
 * Created by chizhang on 2/5/16.
 */
public interface IWhistController {
  /**
   * This method should start the game with the provided number of players, and return only after
   * the game has ended.
   */
  <K> void startGame(CardGameModel<K> game, int numPlayers);
}
