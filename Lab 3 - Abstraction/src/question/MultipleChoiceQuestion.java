package question;

/**
 * Represents a multiple choice question with an int as the correct answer.
 */
public class MultipleChoiceQuestion extends AbstractQuestion {

  private String[] answers;

  /**
   * Creates a question with multiple answers.
   *
   * @param text    the given question
   * @param answers the list of possible answers
   * @throws IllegalArgumentException when the text is empty
   */
  public MultipleChoiceQuestion(String text, String[] answers) throws IllegalArgumentException {
    super(text);
    this.answers = answers;
  }

  @Override
  public String getType() {
    return "MultipleChoice";
  }

  @Override
  public void answer(String enteredAnswer) {
    if (Integer.valueOf(enteredAnswer) > 0) {
      this.enteredAnswer = enteredAnswer;
      return;
    }
    throw new IllegalArgumentException("Invalid answer");
  }

  @Override
  public boolean hasBeenAnswered() {
    if (this.enteredAnswer.equals("")) {
      return false;
    }
    for (int i = 0; i < this.answers.length; i++) {
      if (i == Integer.valueOf(enteredAnswer)) {
        return true;
      }
    }
    return false;
  }
}
