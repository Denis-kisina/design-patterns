package solution.bank.service;

import java.util.ArrayList;
import java.util.Collection;
import solution.bank.domain.Account;

public class AccountSubject {

  private Collection<AccountObserver> observers = new ArrayList<>();

  public void addObserver(AccountObserver observer) {
    observers.add(observer);
  }

  public void doNotify(Account account) {
    for (AccountObserver observer: observers) {
      observer.update(account);
    }
  }
}
