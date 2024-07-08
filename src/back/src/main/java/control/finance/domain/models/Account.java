package control.finance.domain.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Document(collection = "accounts")
public class Account {
    
    @Id
    @NotNull
    private String id;

    @NotNull
    private boolean isEnabled;

    @NotNull
    private Double cashBalance;

    @NotNull
    @PositiveOrZero
    private Double totalExpenses; 

    @NotNull
    @PositiveOrZero
    private Double totalCash;

    public Account(){}
    
    public Account(String id, boolean isEnabled, Double totalExpenses, Double totalCash) {
        this.id = id;
        this.isEnabled = isEnabled;
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
    public void setCashBalance() {
        this.cashBalance = updateCashBalance();
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
    
    private Double updateCashBalance() {
        if (this.totalExpenses != null && this.totalCash != null) {
           return  this.totalCash - this.totalExpenses;
        }
        return this.totalCash;
    }

}