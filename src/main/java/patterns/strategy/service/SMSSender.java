package patterns.strategy.service;

import patterns.strategy.domain.Account;

public class SMSSender implements AccountObserver {

  public void sendSms(Account account) {
    System.out.println("Sending sms to account: " + account);
  }

  @Override
  public void update(Account account) {
    sendSms(account);
  }
}
