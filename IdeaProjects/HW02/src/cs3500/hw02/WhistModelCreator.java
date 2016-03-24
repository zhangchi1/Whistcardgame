package cs3500.hw04;

import cs3500.hw03.WhistModel;

/**
 * Created by chizhang on 2/18/16.
 */

/**
 * Create a WhistModelCreator define an enum ModelType with two possible values TRUMP, NOTRUMP.
 */
public class WhistModelCreator {
  //field
  private final ModelType modelType;

  /**
   * Construct a WhistModelCreator
   */
  public WhistModelCreator(ModelType modelType) {
    this.modelType = modelType;
  }


  // to represent two ModelTypes TRUMP and NOTRUMP.
  public enum ModelType {
    TRUMP, NOTRUMP;
  }

  /**
   * @param type is the game ModelType
   * @return a CardGameModel whether a Trump game model or none trump game model
   */
  public static WhistModel create(ModelType type) {
    if (type == ModelType.TRUMP) {
      return new WhistTrumpModel();
    } else if (type == ModelType.NOTRUMP) {
      return new WhistModel();
    } //END IF
    else {
      throw new IllegalArgumentException("no such type");
    }

  }
}
