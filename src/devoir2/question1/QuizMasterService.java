package devoir2.question1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class QuizMasterService implements Runnable {

  private JFrame screen;
  private ArrayList<JRadioButton> buttons;
  private QuizMaster quizMaster;


  public QuizMasterService() {
    initialize();
  }

  public QuizMasterService(QuizMaster quizMaster) {
    this.quizMaster = quizMaster;
    initialize();
  }

  public void setQuizMaster(QuizMaster quizMaster) {
    this.quizMaster = quizMaster;
  }

  protected void initialize() {
    screen = new JFrame();
    buttons = new ArrayList<>();

    screen.setSize(450, 200);
  }

  private void terminate() {
    screen.dispose();
    System.exit(0);
  }


  @Override
  public void run() {
    screen.setTitle(quizMaster.getType());


    // Fermeture de la fen�tre
    screen.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
        QuizMasterService.this.terminate();
      }
    });


    // Le panneau central
    JPanel centralPanel = new JPanel(new BorderLayout());
    screen.add(centralPanel);
    ActionListener listener = e -> {
      AbstractButton button = (AbstractButton) e.getSource();
      String message = button.getText();
      if (message.equals(quizMaster.getChoice(quizMaster.getResponse()))) {
        JOptionPane.showMessageDialog(screen, "bonne réponse");
      } else {
        JOptionPane.showMessageDialog(screen, "mauvaise réponse");
      }

    };
    JPanel questionPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
    questionPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder()));
    JLabel questionLabel = new JLabel(quizMaster.getQuestion());
    questionPanel.add(questionLabel);
    centralPanel.add(questionPanel, BorderLayout.NORTH);
    JPanel choicePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    ButtonGroup buttonGroup = new ButtonGroup();
    for (int i = 0; i < 4; i++) {
      JRadioButton button = new JRadioButton(quizMaster.getChoice(i));
      buttons.add(button);
      buttonGroup.add(button);
      choicePanel.add(button);
      button.addActionListener(listener);
    }
    centralPanel.add(choicePanel, BorderLayout.CENTER);
    screen.setVisible(true);
  }

}
