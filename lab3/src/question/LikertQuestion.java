package question;

import question.AbstractQuestion;

/**
 * Represents a 5-scale likert question.
 */
public class LikertQuestion extends AbstractQuestion {

  /**
   * Creates a question that can be answered by one of five choices.
   * @param text the given question
   * @throws IllegalArgumentException when the text is empty
   */
  public LikertQuestion(String text) throws IllegalArgumentException {
    super(text);
  }

  @Override
  public String getType() {
    return "Likert";
  }

  //a valid answer must be one of the 5 options, in a case-insensitive manner
  @Override
  public void answer(String enteredAnswer) {
    String[] options =
        {"strongly agree", "agree", "neither agree nor disagree", "disagree", "strongly disagree"};

    for (String option : options) {
      if (enteredAnswer.toLowerCase().equals(option)) {
        this.enteredAnswer = enteredAnswer.toLowerCase();
        return;
      }
    }

    throw new IllegalArgumentException("Invalid answer");
  }

  @Override
  public boolean hasBeenAnswered() {
    String[] options =
        {"strongly agree", "agree", "neither agree nor disagree", "disagree", "strongly disagree"};

    for (String option : options) {
      if (enteredAnswer.toLowerCase().equals(option)) {
        return true;
      }
    }
    return false;
  }

}
