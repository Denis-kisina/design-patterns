package solution.bank.service;

import solution.bank.domain.Account;

public interface AccountObserver {

  void update(Account account);
}
