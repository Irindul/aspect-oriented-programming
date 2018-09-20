package devoir2.question2;

public class BankProgram {

  public static void main(String[] args) {
    Bank bank = new Bank();
    Thread t = new Thread(new Trader(bank));
    t.start();
  }
}
