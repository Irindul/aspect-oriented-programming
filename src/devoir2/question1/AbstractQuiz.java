package devoir2.question1;

import java.util.ArrayList;

public abstract class AbstractQuiz implements QuizMaster {
  protected String type;
  protected String question;
  protected ArrayList<String> choices;
  protected int answer;


  public AbstractQuiz() {
    choices = new ArrayList<>();
    initializeValues();
  }

  public abstract void initializeValues();

  @Override
  public String getChoice(int i) {
    return choices.get(i);
  }

  @Override
  public String getQuestion() {
    return question;
  }

  @Override
  public int getResponse() {
    return answer;
  }

  @Override
  public String getType() {
    return type;
  }
}
