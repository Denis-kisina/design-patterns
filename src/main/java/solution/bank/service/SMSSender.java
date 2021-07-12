package solution.bank.service;

import solution.bank.domain.Account;

public class SMSSender implements AccountObserver {

  public void sendSms(Account account) {
    System.out.println("Sending sms to account: " + account);
  }

  @Override
  public void update(Account account) {
    sendSms(account);
  }
}
