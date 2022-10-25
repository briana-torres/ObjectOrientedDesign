package question;

import question.Question;

/**
 * Abstracts the methods found in the Question interface.
 */
public abstract class AbstractQuestion implements Question {

  protected String questionText;
  protected String enteredAnswer;

  /**
   * Creates a question with the given text.
   * @param text the given question
   * @throws IllegalArgumentException when the text is empty
   */
  public AbstractQuestion(String text) throws IllegalArgumentException {
    if ((text.length() == 0)) {
      throw new IllegalArgumentException("Invalid question text");
    }
    this.questionText = text;
    enteredAnswer = "";
  }

  public String getQuestionText() {
    return questionText;
  }

  /**
   * If the question has been answered returns the entered answer.
   * @return the entered answer
   */
  public String getEnteredAnswer() {
    if (!hasBeenAnswered()) {
      throw new IllegalStateException("solution.question.Question not attempted yet!");
    }
    else {
      return enteredAnswer;
    }
  }

}
