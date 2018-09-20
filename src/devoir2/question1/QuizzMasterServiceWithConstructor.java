package devoir2.question1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuizzMasterServiceWithConstructor extends AbstractQuizzMasterService {

  @Autowired
  public QuizzMasterServiceWithConstructor(QuizzMaster quizzMaster) {
    this.quizMaster = quizzMaster;
    initialize();
  }

}
