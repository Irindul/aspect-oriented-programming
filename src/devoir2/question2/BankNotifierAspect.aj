package devoir2.question2;

public aspect BankNotifierAspect {
  pointcut callSetInterest(double interests, Bank bank):
      call(void Bank.setInterest(double )) && args(interests) && target(bank);

  before(double interests, Bank bank): callSetInterest(interests, bank) {
    bank.getClients().forEach(client -> client.notify(interests));
  }
}