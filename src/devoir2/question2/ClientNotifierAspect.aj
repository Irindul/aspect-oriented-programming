package devoir2.question2;

import java.util.ArrayList;
import java.util.List;

public aspect ClientNotifierAspect {

  private List<Observer> observers = new ArrayList<>();

  pointcut clientConstructorExecution():
      initialization(devoir2.question2.Client.new(String));

  pointcut callSetInterest(double interests, Bank bank):
      call(void devoir2.question2.Bank.setInterest(double )) && args(interests) && target(bank);


  after(): clientConstructorExecution() {
    Client observer = (Client) thisJoinPoint.getTarget();
    observers.add(observer);
  }

  after(double interests, Bank bank): callSetInterest(interests, bank) {
    observers.forEach(observer -> observer.notify(interests));
  }
}