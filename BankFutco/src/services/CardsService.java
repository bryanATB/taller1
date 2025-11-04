package services;

import java.util.List;
import java.util.Optional;
import model.Cards;
import repositories.CardsRepository;

public class CardsService {
    private final CardsRepository repo = new CardsRepository();

    public Cards save(Cards c) {
        return repo.save(c);
    }

    public Optional<Cards> findById(String id) {
        return repo.findById(id);
    }

    public List<Cards> findAll() {
        return repo.findAll();
    }

    public boolean deleteById(String id) {
        return repo.deleteById(id);
    }

    public boolean existsById(String id) {
        return repo.existsById(id);
    }
}
