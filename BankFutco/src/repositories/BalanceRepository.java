package repositories;

import java.util.*;
import java.time.LocalDate;
import java.math.BigDecimal;
import model.Balance;

public class BalanceRepository {
    private final Map<String, Balance> storage = new LinkedHashMap<>();

    public BalanceRepository() { initData(); }

    private void initData() {
        save(new Balance(UUID.randomUUID().toString(), LocalDate.now().minusDays(2), "Depósito", BigDecimal.valueOf(1000), BigDecimal.ZERO, BigDecimal.valueOf(1000)));
        save(new Balance(UUID.randomUUID().toString(), LocalDate.now().minusDays(1), "Retiro", BigDecimal.ZERO, BigDecimal.valueOf(200), BigDecimal.valueOf(800)));
    }

    public Balance save(Balance b) {
        if (b == null) throw new IllegalArgumentException("Balance no puede ser un null");
        if (b.getId() == null) b.setId(UUID.randomUUID().toString());
        storage.put(b.getId(), b);
        return b;
    }

    public Optional<Balance> findById(String id) {
        if (id == null) return Optional.empty();
        return Optional.ofNullable(storage.get(id));
    }

    public List<Balance> findAll() { return new ArrayList<>(storage.values()); }

    public boolean deleteById(String id) { return storage.remove(id) != null; }

    public boolean existsById(String id) { return storage.containsKey(id); }
}
