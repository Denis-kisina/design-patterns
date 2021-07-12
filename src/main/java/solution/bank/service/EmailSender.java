package solution.bank.service;

import solution.bank.domain.Account;

public class EmailSender implements AccountObserver {

  public void sendEmail(Account account) {
    System.out.println("Sending email account:" + account);
  }

  @Override
  public void update(Account account) {
    sendEmail(account);
  }
}
