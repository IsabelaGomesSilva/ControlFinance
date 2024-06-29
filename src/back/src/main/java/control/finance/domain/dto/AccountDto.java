package control.finance.domain.dto;

import org.springframework.data.annotation.Id;


public class AccountDto {
    
    @Id
    private String id;
    private boolean isEnabled;
    private Double cashBalance;
    private Double totalExpenses; 
    private Double totalCash;
    
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

    public boolean isIsEnabled() {
        return isEnabled;
    }
    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", isEnabled="+ isEnabled + ", cashBalance=" + cashBalance + 
        ", totalExpenses=" + totalExpenses + ", totalCash=" + totalCash + "]";
    }
}