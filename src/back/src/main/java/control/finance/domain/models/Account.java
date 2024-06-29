package control.finance.domain.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "accounts")
public class Account {
    
    @Id
    private String id;
    private boolean isEnabled;
    private Double cashBalance;
    private Double totalExpenses; 
    private Double totalCash;

    public Account(){}
    
    public Account(String id, boolean isEnabled, Double cashBalance, Double totalExpenses, Double totalCash) {
        this.id = id;
        this.isEnabled = isEnabled;
        this.cashBalance = cashBalance;
        this.totalExpenses = totalExpenses;
        this.totalCash = totalCash;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(Double cashBalance) {
        this.cashBalance = cashBalance;
    }

    public Double getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(Double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public Double getTotalCash() {
        return totalCash;
    }

    public void setTotalCash(Double totalCash) {
        this.totalCash = totalCash;
    }

    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public boolean isIsEnabled() {
        return isEnabled;
    }

}