package repositories;

import java.util.*;
import java.time.LocalDate;
import java.math.BigDecimal;
import model.Loans;

public class LoansRepository {
    private final Map<String, Loans> storage = new LinkedHashMap<>();

    public LoansRepository() {
        initData();
    }

    private void initData() {
        save(new Loans(UUID.randomUUID().toString(), LocalDate.now().minusMonths(6), "Personal", BigDecimal.valueOf(5000), BigDecimal.valueOf(1500), BigDecimal.valueOf(3500)));
        save(new Loans(UUID.randomUUID().toString(), LocalDate.now().minusYears(1), "Vehicle", BigDecimal.valueOf(15000), BigDecimal.valueOf(5000), BigDecimal.valueOf(10000)));
    }

    public Loans save(Loans loan) {
        if (loan == null) throw new IllegalArgumentException("Loans no puede ser null");
        if (loan.getId() == null) loan.setId(UUID.randomUUID().toString());
        storage.put(loan.getId(), loan);
        return loan;
    }

    public Optional<Loans> findById(String id) {
        if (id == null) return Optional.empty();
        return Optional.ofNullable(storage.get(id));
    }

    public List<Loans> findAll() {
        return new ArrayList<>(storage.values());
    }

    public boolean deleteById(String id) {
        if (id == null) return false;
        return storage.remove(id) != null;
    }

    public boolean existsById(String id) {
        if (id == null) return false;
        return storage.containsKey(id);
    }
}