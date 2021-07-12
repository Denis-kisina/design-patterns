package patterns.strategy.service;

import java.util.Collection;
import patterns.strategy.dao.AccountDAO;
import patterns.strategy.dao.IAccountDAO;
import patterns.strategy.domain.Account;
import patterns.strategy.domain.Customer;

public class AccountService extends AccountSubject implements IAccountService {

  private IAccountDAO accountDAO;

  public AccountService() {
    accountDAO = new AccountDAO();
  }

  public Account createAccount(long accountNumber, String customerName) {
    Account account = new Account(accountNumber);
    Customer customer = new Customer(customerName);
    account.setCustomer(customer);
    accountDAO.saveAccount(account);
    doNotify(account);
    return account;
  }

  public void deposit(long accountNumber, double amount) {
    Account account = accountDAO.loadAccount(accountNumber);
    account.deposit(amount);
    accountDAO.updateAccount(account);
    doNotify(account);
  }

  public Account getAccount(long accountNumber) {
    Account account = accountDAO.loadAccount(accountNumber);
    return account;
  }

  public Collection<Account> getAllAccounts() {
    return accountDAO.getAccounts();
  }

  public void withdraw(long accountNumber, double amount) {
    Account account = accountDAO.loadAccount(accountNumber);
    account.withdraw(amount);
    accountDAO.updateAccount(account);
    doNotify(account);
  }

  public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
    Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
    Account toAccount = accountDAO.loadAccount(toAccountNumber);
    fromAccount.transferFunds(toAccount, amount, description);
    accountDAO.updateAccount(fromAccount);
    accountDAO.updateAccount(toAccount);
  }
}
