package patterns.strategy.service;

import patterns.strategy.domain.Account;

public interface AccountObserver {

  void update(Account account);
}
