package patterns.strategy;

import java.util.Collection;
import patterns.strategy.domain.Account;
import patterns.strategy.domain.AccountEntry;
import patterns.strategy.domain.Customer;
import patterns.strategy.service.AccountService;
import patterns.strategy.service.EmailSender;
import patterns.strategy.service.Logger;
import patterns.strategy.service.SMSSender;

public class Application {

  public static void main(String[] args) {

    AccountService accountService = new AccountService();

    // create Observers
    Logger logger = new Logger();
    EmailSender emailSender = new EmailSender();
    SMSSender smsSender = new SMSSender();

    // add observers
    accountService.addObserver(logger);
    accountService.addObserver(emailSender);
    accountService.addObserver(smsSender);

    // create 2 accounts;
    accountService.createAccount(1263862, "Frank Brown");
    accountService.createAccount(4253892, "John Doe");

    //use account 1;
    accountService.deposit(1263862, 240);
    accountService.deposit(1263862, 529);
    accountService.withdraw(1263862, 230);
    //use account 2;
    accountService.deposit(4253892, 12450);
    accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");
    // show balances

    Collection<Account> accountlist = accountService.getAllAccounts();
    Customer customer = null;
    for (Account account : accountlist) {
      customer = account.getCustomer();
      System.out.println("Statement for Account: " + account.getAccountNumber());
      System.out.println("Account Holder: " + customer.getName());
      System.out.println("-Date-------------------------"
          + "-Description------------------"
          + "-Amount-------------");
      for (AccountEntry entry : account.getEntryList()) {
        System.out.printf("%30s%30s%20.2f\n", entry.getDate()
            .toString(), entry.getDescription(), entry.getAmount());
      }
      System.out.println("----------------------------------------"
          + "----------------------------------------");
      System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:",
          account.getBalance());
    }
  }
}


