package solution.bank.service;

import solution.bank.domain.Account;

public class Logger implements AccountObserver {

  public void log(Account account) {
    System.out.println("Logging account:" + account);
  }

  @Override
  public void update(Account account) {
    log(account);
  }
}
