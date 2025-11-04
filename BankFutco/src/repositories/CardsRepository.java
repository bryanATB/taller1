package repositories;

import java.util.*;
import java.math.BigDecimal;
import model.Cards;

public class CardsRepository {
    private final Map<String, Cards> storage = new LinkedHashMap<>();

    public CardsRepository() {
        initData();
    }

    private void initData() {
        storage.put("CARD001", new Cards("CARD001", "Credit", BigDecimal.valueOf(5000), BigDecimal.valueOf(1000), BigDecimal.valueOf(4000)));
        storage.put("CARD002", new Cards("CARD002", "Debit", BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO));
    }

    public Cards save(Cards card) {
        if (card == null) throw new IllegalArgumentException("Card no puede ser null");
        if (card.getCardNumber() == null) throw new IllegalArgumentException("cardNumber no puede ser null");
        storage.put(card.getCardNumber(), card);
        return card;
    }

    public Optional<Cards> findById(String cardNumber) {
        if (cardNumber == null) return Optional.empty();
        return Optional.ofNullable(storage.get(cardNumber));
    }

    public List<Cards> findAll() {
        return new ArrayList<>(storage.values());
    }

    public boolean deleteById(String cardNumber) {
        return storage.remove(cardNumber) != null;
    }

    public boolean existsById(String cardNumber) {
        return storage.containsKey(cardNumber);
    }
}