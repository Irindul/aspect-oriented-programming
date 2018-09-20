package devoir2.question2;

import java.util.Random;

public class Trader implements Runnable{

  private Bank bank;
  private Random random;

  public Trader(Bank bank) {
    this.bank = bank;
    bank.addClient(new Client("1"))
        .addClient(new Client("2"))
        .addClient(new Client("3"));
    random = new Random(1234);
  }

  @Override
  public void run() {
    while(!Thread.currentThread().isInterrupted()) {
      int randomTimeToSleepInMs = 500 + random.nextInt(1500);
      try {
        Thread.sleep(randomTimeToSleepInMs);
      } catch (InterruptedException e) {
        //Not a problem
      }
      System.out.println();
      System.out.println("Changing banks interests");
      System.out.println();
      double min = 1d;
      double max = 10d;
      double randomBankInterest = min + (max - min) * random.nextDouble();

      bank.setInterest(randomBankInterest);
    }
  }
}
