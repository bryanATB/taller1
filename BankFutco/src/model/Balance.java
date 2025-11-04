package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Balance {
    private String id;
    private LocalDate date;
    private String description;
    private BigDecimal cashIn;
    private BigDecimal cashOut;
    private BigDecimal closingBalance;

    public Balance() { }

    public Balance(String id, LocalDate date, String description, BigDecimal cashIn, BigDecimal cashOut, BigDecimal closingBalance) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.cashIn = cashIn;
        this.cashOut = cashOut;
        this.closingBalance = closingBalance;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getCashIn() { return cashIn; }
    public void setCashIn(BigDecimal cashIn) { this.cashIn = cashIn; }

    public BigDecimal getCashOut() { return cashOut; }
    public void setCashOut(BigDecimal cashOut) { this.cashOut = cashOut; }

    public BigDecimal getClosingBalance() { return closingBalance; }
    public void setClosingBalance(BigDecimal closingBalance) { this.closingBalance = closingBalance; }

    @Override
    public String toString() {
        return "Balance[id=" + id + ", date=" + date + ", desc=" + description + ", in=" + cashIn + ", out=" + cashOut + ", closing=" + closingBalance + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Balance)) return false;
        Balance other = (Balance) o;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
