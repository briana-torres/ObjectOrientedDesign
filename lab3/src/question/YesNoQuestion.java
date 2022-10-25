package question;

import question.AbstractQuestion;

//this class represents a yes/no question

/**
 * Represents a yes or no question.
 */
public class YesNoQuestion extends AbstractQuestion {

  //a question must be non empty and should end with a question mark

  /**
   * Creates a question ending in a question mark with a yes or no answer.
   * @param text the given question
   * @throws IllegalArgumentException when the text is empty or does not have a ?
   */
  public YesNoQuestion(String text) throws IllegalArgumentException {
    super(text);
    if ((text.charAt(text.length() - 1) != '?')) {
      throw new IllegalArgumentException("Invalid question text");
    }
  }

  @Override
  public String getType() {
    return "YesNo";
  }

  //a valid answer must be a yes or no
  @Override
  public void answer(String enteredAnswer) {
    if ((enteredAnswer.toLowerCase().equals("yes")) || (enteredAnswer.toLowerCase().equals("no"))) {
      this.enteredAnswer = enteredAnswer.toLowerCase();
    }
    else {
      throw new IllegalArgumentException("Invalid answer: " + enteredAnswer);
    }
  }

  @Override
  public boolean hasBeenAnswered() {
    return enteredAnswer.equals("yes") || enteredAnswer.equals("no");
  }

}
