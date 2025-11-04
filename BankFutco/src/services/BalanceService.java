package services;

import java.util.List;
import java.util.Optional;
import model.Balance;
import repositories.BalanceRepository;

public class BalanceService {
    private final BalanceRepository repo = new BalanceRepository();

    public Balance save(Balance b) {
        return repo.save(b);
    }

    public Optional<Balance> findById(String id) {
        return repo.findById(id);
    }

    public List<Balance> findAll() {
        return repo.findAll();
    }

    public boolean deleteById(String id) {
        return repo.deleteById(id);
    }

    public boolean existsById(String id) {
        return repo.existsById(id);
    }
}
