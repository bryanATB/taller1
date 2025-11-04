package model;

import java.util.Objects;

public class Account {
    private String accountNumber;
    private String name;
    private String email;
    private String mobileNumber;
    private String accountType;
    private String address;

    public Account() { }

    public Account(String accountNumber, String name, String email, String mobileNumber, String accountType, String address) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.accountType = accountType;
        this.address = address;
    }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    @Override
    public String toString() {
        return "Account[" + accountNumber + ", name=" + name + ", email=" + email + ", mobile=" + mobileNumber + ", type=" + accountType + ", address=" + address + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account other = (Account) o;
        return Objects.equals(accountNumber, other.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }
}