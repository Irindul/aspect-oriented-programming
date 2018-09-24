package devoir2.question1;

import java.util.ArrayList;

public class UMLQuiz extends AbstractQuiz {

  @Override
  public void initializeValues() {
    type = "Question sur UML";
    choices = new ArrayList<>(4);
    question = "Parmi les diagrammes suivants, lequel a été introduit dans UML2 ?";
    choices.add("Diagramme d'activité");
    choices.add("Diagramme de Classes");
    choices.add("Diagramme de Temps");
    choices.add("Diagramme des cas d'utilisation");

    answer = 2;
  }
}
