package devoir2.question1;

import com.sun.istack.internal.NotNull;

public interface QuizzMaster {

  String getQuestion();
  String getChoice(int i);
  int getResponse();
  String getType();

}
