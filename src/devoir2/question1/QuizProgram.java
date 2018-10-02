package devoir2.question1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuizProgram {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("devoir2/question1/quiz.xml");
    QuizMasterService quizWithConstructor = (QuizMasterService) context.getBean("quizWithConstructor");
    QuizMasterService quizWithSetter = (QuizMasterService) context.getBean("quizWithSetter");
    quizWithConstructor.run();

    //Enlever le commentaire pour lancer l'interface instancié avec le setter
    //quizWithSetter.run();
  }
}
