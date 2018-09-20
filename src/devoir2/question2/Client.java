package devoir2.question2;

import java.util.Observable;

public class Client implements Observer {

  private String name;

  public Client(String name) {
    this.name = name;
  }

  @Override
  public void notify(double interest) {
    System.out.println("Client " + name + " notified with :");
    System.out.println("New interest = " + interest);

  }
}
