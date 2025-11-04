package services;

import java.util.List;
import java.util.Optional;
import model.Loans;
import repositories.LoansRepository;

public class LoansService {
    private final LoansRepository repo = new LoansRepository();

    public Loans save(Loans l) {
        return repo.save(l);
    }

    public Optional<Loans> findById(String id) {
        return repo.findById(id);
    }

    public List<Loans> findAll() {
        return repo.findAll();
    }

    public boolean deleteById(String id) {
        return repo.deleteById(id);
    }

    public boolean existsById(String id) {
        return repo.existsById(id);
    }
}
