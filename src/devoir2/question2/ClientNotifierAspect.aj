package devoir2.question2;

public aspect ClientNotifierAspect {
  pointcut callSetInterest(double interests, Bank bank):
      call(void devoir2.question2.Bank.setInterest(double )) && args(interests) && target(bank);

  after(double interests, Bank bank): callSetInterest(interests, bank) {
    bank.getClients().forEach(client -> client.notify(interests));
  }
}