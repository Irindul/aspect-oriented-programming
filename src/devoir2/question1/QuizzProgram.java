package devoir2.question1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuizzProgram {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("devoir2/question1/quizz.xml");
    QuizzMasterService quizWithConstructor = (QuizzMasterService) context.getBean("quizWithConstructor");
    QuizzMasterService quizWithSetter = (QuizzMasterService) context.getBean("quizWithSetter");
    quizWithConstructor.run();

    //Enlever le commentaire pour lancer l'interface instancié avec le setter
    //quizWithSetter.run();
  }
}
