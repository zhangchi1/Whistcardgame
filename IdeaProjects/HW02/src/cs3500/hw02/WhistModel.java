package cs3500.hw03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cs3500.hw02.Card;
import cs3500.hw02.GenericStandardDeckGame;

import static cs3500.hw02.Card.*;


/**
 * To represents the Whist Card Game
 */
public class WhistModel extends GenericStandardDeckGame implements CardGameModel<Card> {
  /**
   * Fields
   */
  protected Suit CurrentSuit;    //Current Suit play
  protected List<Card> CurrentHandCards; // Cards play in the Current round
  protected int IndexofLastWinner; //The winner`s index
  protected List<WhistPlayer> listofWhistPlayer;

  /**
   * Constructor for WhistModel
   */
  public WhistModel() {
    super();
    this.CurrentSuit = null;
    this.CurrentHandCards = new ArrayList<Card>();
    this.IndexofLastWinner = 0;
    this.listofWhistPlayer = new ArrayList<WhistPlayer>();
  }


  /**
   * give a list of Card find the index of highest value card has the same suit with Currentsuit
   * othe cards with other suits treat card value as 0
   *
   * @param listCards the given list of Card
   * @return the index of the highest value card
   */
  public int highestCard(List<Card> listCards) {
    int higestIndex = 0;
    List<Integer> listofValue = new ArrayList<Integer>();

    for (int i = 0; i < listCards.size(); i++) {
      if (listCards.get(i).getSuit() == CurrentSuit) {
        listofValue.add(listCards.get(i).getValue().getValue());
      } else listofValue.add(0);
    }
    int highestvalue = Collections.max(listofValue);
    for (int i = 0; i < listofValue.size(); i++) {
      if (listofValue.get(i) == highestvalue) {
        higestIndex = i;
      } //end if
      else {
        //do nothing
      }
    }

    return higestIndex;
  }

  /**
   * Determine if the given cardIndex of that PlayerNo(Player) is a valid play if the player's list
   * of card doesn`t have a card same as the currentsuit, player can play any card otherwise, can
   * ony play the card has the same suit with currentsuit Does not control whether is that player`s
   * turn to play!
   *
   * @param playerNo player`s number
   * @param cardIdx  plays the card at index cardIdx in the set of cards
   * @return true if it is a valid play card, false otherwise
   */
  public boolean isValidPlay(int playerNo, int cardIdx) {
    if (listofWhistPlayer.get(playerNo).hasSameSuit(CurrentSuit)) {
      if (listofWhistPlayer.get(playerNo).listCard.get(cardIdx).getSuit() == CurrentSuit) {
        return true;
      } else {
        return false;
      }
    } //end if
    else {
      return true;
    }
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
  @Override
  public void startPlay(int numPlayers, List<Card> listk) {
    this.listcard = listk;
    this.numplayers = numPlayers;
    if (numPlayers > 1 && this.isvalid(listk)) {
      //add players
      for (int player = 0; player < numPlayers; player++) {
        listofWhistPlayer.add(new WhistPlayer(player));
      }
      //add cards to corresponding Player
      for (int i = 0; i <= 51; i++) {
        listofWhistPlayer.get(i % numPlayers).addCardtoPlayer(listk.get(i));
      }

    } else throw new IllegalArgumentException("not a valid game");
  }

  // return the number of players who have cards
  private int playershascards() {

    int num = 0;
    for (int i = 0; i < listofWhistPlayer.size(); i++) {
      if (listofWhistPlayer.get(i).listCard.size() > 0) {
        num = num + 1;
      }//end if
      else {
        //do nothing
      }
    }
    return num;
  }

  /**
   * plays the card at index cardIdx in the set of cards for player number playerNo. It is assumed
   * that both player numbers and card indices begin with 0. It is further assumed that players’
   * hands are sorted.
   *
   * @param playerNo player`s number
   * @param cardIdx  plays the card at index cardIdx in the set of cards
   */
  public void play(int playerNo, int cardIdx) {
    if (playerNo == this.getCurrentPlayer() &&
        cardIdx < listofWhistPlayer.get(playerNo).listCard.size() &&
        this.isValidPlay(playerNo, cardIdx) &&
        cardIdx >= 0 &&
        !this.isGameOver()) {
      //add the card to the current hand of list of card
      CurrentHandCards.add(listofWhistPlayer.get(playerNo).listCard.get(cardIdx));
      Card removedcard = listofWhistPlayer.get(playerNo).listCard.get(cardIdx);
      //remove that card from that player
      listofWhistPlayer.get(playerNo).listCard.remove(cardIdx);

      if (CurrentHandCards.size() == 1) {
        //update currentsuit
        this.CurrentSuit = removedcard.getSuit();

      } else if ((CurrentHandCards.size() == listofWhistPlayer.size()) ||
          (this.gamealmostover() && CurrentHandCards.size() == 52 % listofWhistPlayer.size())) {
        //get the winner for this hand
        IndexofLastWinner = (this.highestCard(CurrentHandCards) + IndexofLastWinner) %
            listofWhistPlayer.size();
        //add a hand to the winner
        listofWhistPlayer.get(IndexofLastWinner).addAHand();
        this.CurrentSuit = null;
        this.CurrentHandCards = new ArrayList<Card>();
      }


    } //end if
    else {
      throw new IllegalArgumentException("Can not play like this");
    }
  }

  /**
   * check game is almost over when the number of players who has cards is less than the total
   * number of players
   *
   * @boolean true if the game is almost over , fasle otherwise
   */
  private boolean gamealmostover() {
    if (this.playershascards() < 52 % listofWhistPlayer.size()) {
      return true;
    } else return false;
  }

  /**
   * Based on who played last time If current player has no cards, jump to the next index player If
   * game is over there is no current player
   *
   * @return the player whose turn it is to play.
   */
  public int getCurrentPlayer() {
    if (listofWhistPlayer.size() == 0) {
      throw new IllegalArgumentException("Game hasn't start!");
    } else {
      int CurrentPlayer = (IndexofLastWinner + CurrentHandCards.size()) % listofWhistPlayer.size();
      //if current player has no cards, jump to the next index player
      if (listofWhistPlayer.get(CurrentPlayer).listCard.size() == 0) {
        for (int i = 0; i < listofWhistPlayer.size(); i++) {
          CurrentPlayer = (CurrentPlayer + i) % listofWhistPlayer.size();
        }
      }//end if
      else {
        //do thing
      }
      return CurrentPlayer;
    }
  }

  /**
   * The game ends when ONLY one player has cards The game is over when there are fewer than two
   * players with any cards remaining. Those remaining cards are discarded; they don’t count as
   * “hands won” by any player.
   *
   * @return true if the game is over, false otherwise.
   */
  public boolean isGameOver() {
    if (this.listofWhistPlayer.size() == 0) {
      throw new IllegalArgumentException("Game hasn't start!");
    } else {
      //make all players list of cards size into a list
      List<Integer> listofsizes = new ArrayList<>();
      for (int i = 0; i < listofWhistPlayer.size(); i++) {
        listofsizes.add(listofWhistPlayer.get(i).listCard.size());
      }
      //find how many zero size in the list
      int countzero = 0;
      for (int j = 0; j < listofsizes.size(); j++) {
        if (listofsizes.get(j) == 0) {
          countzero = countzero + 1;
        }//end if
        else {
          //do nothing
        }
      }
      /**
       *     if less than (total number of player -1) players has zero card
       * For example: total 4 players. If there are less than 3 players has zero card
       * the game is not over.
       *  The game is over when there are fewer than two players with any cards remaining
       *  (at the beginning of each round, not during the round play).
       *  Which means more than (total # of players - 2) has no card the game is over.
       */
      if (this.CurrentSuit == null &&
          countzero > listofsizes.size() - 2) {
        return true;
      } else {
        return false;
      }
    }

  }

  /**
   * @return a String that contains the entire state of the game as follows, one on each line:
   * Number of players: N (printed as a normal decimal number) Player 1: cards in sorted order
   * (printed as a comma-separated list) Player 2: cards in sorted order (printed as a
   * comma-separated list) ... Player N: cards in sorted order (printed as a comma-separated list)
   * Then Players hand won with the same format. Last append with a special message in the end
   * should be either "Turn: Player X" if the game is ongoing and it is player X’s turn to play
   * next, or "Game over. Player X won." if the game is over and player X has won.
   */
  @Override
  public String getGameState() {

    String gamestate = "Number of players: " + this.numplayers;
    for (int j = 0; j < this.numplayers; j++) {
      gamestate += "\n" + "Player " + Integer.toString(j + 1) + ": ";
      if (j < 52) {
        WhistPlayer p0 = listofWhistPlayer.get(j);
        for (int i = 0; i < p0.listCard.size() - 1; i++) {
          List<Card> cards = p0.listCard;
          this.mysort(cards);
          Card card = cards.get(i);
          gamestate += card.CardtoString() + ", ";

        }
        if (p0.listCard.size() > 0) {
          gamestate = gamestate + p0.listCard.get(p0.listCard.size() - 1).CardtoString();
        }
      }//end if
      else {
        gamestate = gamestate + "";
      }

    }
    //append the string of players' hand won
    for (int k = 0; k < listofWhistPlayer.size(); k++) {
      gamestate += "\n" + "Player " + Integer.toString(k + 1) + ": ";
      gamestate = gamestate + listofWhistPlayer.get(k).hands + " hands won";
    }
    //append the special message in the end
    gamestate = gamestate + "\n" + this.specialmessage();
    return gamestate;
  }

  /**
   * @return string "Turn: Player X" if the game is on going and it is player X’s turn to play next,
   * or "Game over. Player X won." if the game is over and player X has won.
   */
  public String specialmessage() {
    String winners = "";
    if (this.isGameOver()) {
      for (int i = 0; i < this.getwinners().size(); i++) {
        winners = winners + "Player " + (this.getwinners().get(i) + 1) + " ";
      }
      return "Game over. " + winners + " won.";
    }//end if
    else {
      return "Turn: Player " + (this.getCurrentPlayer() + 1);
    }

  }

  /**
   * @return List<Integer> find all the winners` index in a game
   */
  public List<Integer> getwinners() {
    //make all players` hands into a list
    List<Integer> listofhands = new ArrayList<Integer>();
    for (int i = 0; i < listofWhistPlayer.size(); i++) {
      listofhands.add(listofWhistPlayer.get(i).hands);
    }
    List<Integer> listofindices = new ArrayList<Integer>();
    int max = Collections.max(listofhands);
    for (int j = 0; j < listofhands.size(); j++) {
      if (listofhands.get(j) == max) {
        listofindices.add(j);
      }//end if
    }
    return listofindices;
  }

  /**
   * get list of whist player
   *
   * @return listofWhistPlayer
   */
  public List<WhistPlayer> getListofWhistPlayer() {
    return this.listofWhistPlayer;
  }
}
