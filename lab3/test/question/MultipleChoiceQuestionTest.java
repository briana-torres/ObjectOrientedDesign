package question;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests the MultipleChoiceQuestion class.
 */
public class MultipleChoiceQuestionTest {

  private Question q;
  private String[] answers;

  @Before
  public void init() {
    answers = new String[]{"bob", "rachel", "bri", "heather", "david"};
    q = new MultipleChoiceQuestion("What is my name?", answers);

  }

  @Test
  public void getType() {
    assertEquals("MultipleChoice", q.getType());
  }

  @Test
  public void testAnswerCorrectly() {
    for (String answer : answers) {

      q.answer("1");
      assertEquals("1", q.getEnteredAnswer());
      assertTrue(q.hasBeenAnswered());
    }
  }

  @Test
  public void testAnswerInCorrectly() {
    for (String answer : answers) {
      assertFalse(q.hasBeenAnswered());

      try {
        q.answer("9");
      } catch (IllegalArgumentException e) {
        assertFalse(q.hasBeenAnswered());
      }
    }
  }
}