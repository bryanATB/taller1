package services;

import java.util.List;
import java.util.Optional;
import model.Account;
import repositories.AccountRepository;

public class AccountService {
    private final AccountRepository repo = new AccountRepository();

    public Account save(Account account) {
        return repo.save(account);
    }

    public Optional<Account> findById(String accountNumber) {
        return repo.findById(accountNumber);
    }

    public List<Account> findAll() {
        return repo.findAll();
    }

    public boolean deleteById(String accountNumber) {
        return repo.deleteById(accountNumber);
    }

    public boolean existsById(String accountNumber) {
        return repo.existsById(accountNumber);
    }
}
