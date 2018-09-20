package devoir2.question1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuizzMasterServiceWithSetter extends AbstractQuizzMasterService{

  @Autowired
  public void setQuizzMaster(QuizzMaster quizzMaster) {
    this.quizMaster = quizzMaster;
  }
}
