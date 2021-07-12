package patterns.strategy.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Observable;

public class Account extends Observable {

  long accountNumber;
  Collection<AccountEntry> entryList = new ArrayList<AccountEntry>();
  Customer customer;

  public Account(long accountNumber) {
    this.accountNumber = accountNumber;
  }

  public long getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(long accountNumber) {
    this.accountNumber = accountNumber;
  }

  public double getBalance() {
    double balance = 0;
    for (AccountEntry entry : entryList) {
      balance += entry.getAmount();
    }
    return balance;
  }

  public void deposit(double amount) {
    AccountEntry entry = new AccountEntry(new Date(), amount, "deposit", "", "");
    entryList.add(entry);
    notifyObservers();
  }

  public void withdraw(double amount) {
    AccountEntry entry = new AccountEntry(new Date(), -amount, "withdraw", "", "");
    entryList.add(entry);
  }

  private void addEntry(AccountEntry entry) {
    entryList.add(entry);
  }

  public void transferFunds(Account toAccount, double amount, String description) {
    AccountEntry fromEntry = new AccountEntry(new Date(), -amount, description, "" + toAccount.getAccountNumber(), toAccount.getCustomer().getName());
    AccountEntry toEntry = new AccountEntry(new Date(), amount, description, "" + toAccount.getAccountNumber(), toAccount.getCustomer().getName());
    entryList.add(fromEntry);
    toAccount.addEntry(toEntry);

  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Collection<AccountEntry> getEntryList() {
    return entryList;
  }

  @Override
  public String toString() {
    return "Account{" +
        "accountNumber=" + accountNumber +
        ", entryList=" + entryList +
        ", customer=" + customer.getName() +
        '}';
  }
}
