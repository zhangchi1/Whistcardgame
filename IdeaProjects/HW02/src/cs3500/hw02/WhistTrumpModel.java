package cs3500.hw04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cs3500.hw02.Card;
import cs3500.hw03.WhistModel;
import cs3500.hw03.WhistPlayer;

import static cs3500.hw02.Card.Suit;

/**
 * Created by chizhang on 2/18/16. represent a Trump card game
 */
public class WhistTrumpModel extends WhistModel {
  /**
   * Fields
   */
  protected Suit TrumpSuit;

  /**
   * Constructor represent a TrumpModel
   */
  public WhistTrumpModel() {
    super();
    this.TrumpSuit = null;
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
    //add trumpsuit
    this.TrumpSuit = listk.get(0).getSuit();
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
      //sort player`s cards
      for (int j = 0; j < this.numplayers; j++) {
        WhistPlayer p0 = listofWhistPlayer.get(j);
        for (int i = 0; i < p0.listCard.size() - 1; i++) {
          List<Card> cards = p0.listCard;
          this.mysort(cards);
        }
      }
    } else throw new IllegalArgumentException("not a valid game");
  }

  /**
   * Find if there exist cardsuit same as TrumpSuit in the listCards if there exist, return true, if
   * there is no such that card return false
   *
   * @return boolean
   */
  public boolean hasTrumpSuit(List<Card> listCards) {
    boolean initial = false;
    for (int i = 0; i < listCards.size(); i++) {
      if (listCards.get(i).getSuit() == TrumpSuit) {
        initial = true;
        break;
      } else initial = false || initial;
    }
    return initial;
  }

  /**
   * give a list of Card find the index of highest value card has the same suit with Currentsuit, if
   * there exist TrumpSuit card return the index of the highest TrumpSuit card, other cards with
   * other suits treat card value as 0
   *
   * @param listCards the given list of Card
   * @return the index of the highest value card
   */
  @Override
  public int highestCard(List<Card> listCards) {
    int higestIndex = 0;
    List<Integer> listofValue = new ArrayList<Integer>();
    //if there is no trumpsuit
    if (!this.hasTrumpSuit(listCards)) {
      for (int i = 0; i < listCards.size(); i++) {
        if (listCards.get(i).getSuit() == CurrentSuit) {
          listofValue.add(listCards.get(i).getValue().getValue());
        } else listofValue.add(0);
      }

    }//end if
    // if there exist trumpsuit cards
    else {
      for (int i = 0; i < listCards.size(); i++) {
        if (listCards.get(i).getSuit() == TrumpSuit) {
          listofValue.add(listCards.get(i).getValue().getValue());
        } else listofValue.add(0);
      }
    }
    int highestvalue = Collections.max(listofValue);
    higestIndex = listofValue.indexOf(highestvalue);

    return higestIndex;
  }


  /**
   * Override the GetGameState method with an additional line at the end: "Trump suit: X", where X
   * is replaced by the character of the trump suit.
   */
  @Override
  public String getGameState() {
    if (!this.isGameOver()) {
      String last = super.getGameState();
      last = last + "\n" + "Trump suit: " + this.TrumpSuit.stringSuit();
      return last;
    }//end if
    else {
      return super.getGameState();
    }
  }


}
