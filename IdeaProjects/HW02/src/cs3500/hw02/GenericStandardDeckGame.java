package cs3500.hw02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Represents a generic standard deck of cards game
 */
public class GenericStandardDeckGame implements GenericCardGameModel<Card> {

  /**
   * fields
   */
  protected int numplayers;
  protected List<Player> listplayers;
  protected List<Card> listcard; // a entire deck of card

  /**
   * 1st construct a generic standard Deck-card-game default (i.e., zero arguments) constructor
   */
  public GenericStandardDeckGame() {
    this.numplayers = 0;
    this.listplayers = new ArrayList<>();

  }

  /**
   * 2nd Construct a generic standard Deck-card-game
   *
   * @param numplayers  the number of players in the game
   * @param listplayers players who play the game
   */
  public GenericStandardDeckGame(int numplayers, List<Player> listplayers) {
    this.numplayers = numplayers;
    this.listplayers = listplayers;

  }


  /**
   * Any implementation of this method must return a list representing the entire deck of relevant
   * cards. deal 52 Cards so that we can return a entire deck of cards
   *
   * @return an entire deck of cards, as a List<card>
   */
  public List<Card> getDeck() {
    List<Card> newListCard1 = new ArrayList<Card>();
    DeckofCards deckofCards1 = new DeckofCards();
    for (int card = 0; card < 52; card++) {
      Card one = deckofCards1.dealACard();
      newListCard1.add(one);
    }

    return newListCard1;
  }

  /**
   * check there is no duplicate cards in a List<Card> the List<Card> can be any length
   *
   * @return boolean
   */
  public boolean nodupCards(List<Card> listCard) {
    for (int i = 0; i < listCard.size(); i++) {
      for (int j = 0; j < listCard.size(); j++) {
        if (listCard.get(i).equals(listCard.get(j)) && i != j) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * test a card is valid or not list of cards must have exactly 52 cards and no duplicated cards
   *
   * @return boolean
   */
  public boolean isvalid(List<Card> listCard) {
    for (int i = 0; i < listCard.size(); i++) {
      if (listCard.size() == 52 && nodupCards(listCard)) {
        return true;
      }
    }
    return false;
  }

  /**
   * This Method supposed to distribute these cards in the specified order among the players in
   * round-robin fashion. This method should throw an IllegalArgumentException in two cases: if the
   * number of players is not greater than 1. if the deck passed to it is invalid. This is dependent
   * on the implementation
   *
   * @param numPlayers as the number of players
   * @param listk      as a deck of cards
   */
  public void startPlay(int numPlayers, List<Card> listk) {
    this.listcard = listk;
    this.numplayers = numPlayers;
    if (numPlayers > 1 && this.isvalid(listk)) {
      //add players
      for (int player = 0; player < numPlayers; player++) {
        listplayers.add(new Player(player));
      }
      //add cards to corresponding Player
      for (int i = 0; i <= 51; i++) {
        listplayers.get(i % numPlayers).addCardtoPlayer(listk.get(i));
      }

    } else throw new IllegalArgumentException("not a valid game");
  }

  /**
   * sort a list of cards Follow by a standard deck of cards is defined as alphabetical order of
   * suits. Then within each suit, cards should be ordered in descending order by number with aces
   * being highest (A, K, Q, J, 10, ..., 2).
   *
   * @param listCards a  List<Card>
   * @return a List<Card>
   */
  public void mysort(List<Card> listCards) {
    Collections.sort(listCards);
  }

  /**
   * @return a String that contains the entire state of the game as follows, one on each line:
   * Number of players: N (printed as a normal decimal number) Player 1: cards in sorted order
   * (printed as a comma-separated list) Player 2: cards in sorted order (printed as a
   * comma-separated list) ... Player N: cards in sorted order (printed as a comma-separated list)
   */
  public String getGameState() {

    String gamestate = "Number of players: " + this.numplayers;
    for (int j = 0; j < this.numplayers; j++) {
      gamestate += "\n" + "Player " + Integer.toString(j + 1) + ": ";
      if (j < 52) {
        Player p0 = listplayers.get(j);
        for (int i = 0; i < p0.listCard.size() - 1; i++) {
          List<Card> cards = p0.listCard;
          this.mysort(cards);
          Card card = cards.get(i);
          gamestate += card.CardtoString() + ", ";

        }
        gamestate = gamestate + p0.listCard.get(p0.listCard.size() - 1).CardtoString();
      } else {
        gamestate = gamestate + "";
      }

    }

    return gamestate;
  }
}
