package devoir2.question2;

import java.util.ArrayList;

public class Bank {
  ArrayList<Client> clients;
  private double interest;

  public Bank() {
    clients = new ArrayList<>();
    interest = 0.4;
  }

  public Bank addClient(Client client) {
    clients.add(client);
    return this;
  }

  public void setInterest(double interest) {
    this.interest = interest;
  }

  public ArrayList<Client> getClients() {
    return clients;
  }
}
