package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Loans {
    private String id;
    private LocalDate date;
    private String type;
    private BigDecimal totalLoan;
    private BigDecimal amountPaid;
    private BigDecimal outstandingAmt;

    public Loans() { }

    public Loans(String id, LocalDate date, String type, BigDecimal totalLoan, BigDecimal amountPaid, BigDecimal outstandingAmt) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.totalLoan = totalLoan;
        this.amountPaid = amountPaid;
        this.outstandingAmt = outstandingAmt;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public BigDecimal getTotalLoan() { return totalLoan; }
    public void setTotalLoan(BigDecimal totalLoan) { this.totalLoan = totalLoan; }

    public BigDecimal getAmountPaid() { return amountPaid; }
    public void setAmountPaid(BigDecimal amountPaid) { this.amountPaid = amountPaid; }

    public BigDecimal getOutstandingAmt() { return outstandingAmt; }
    public void setOutstandingAmt(BigDecimal outstandingAmt) { this.outstandingAmt = outstandingAmt; }

    @Override
    public String toString() {
        return "Loans[id=" + id + ", date=" + date + ", type=" + type + ", total=" + totalLoan + ", paid=" + amountPaid + ", outstanding=" + outstandingAmt + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Loans)) return false;
        Loans other = (Loans) o;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
