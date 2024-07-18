package control.finance.domain.dto;

import static control.finance.domain.CurrencyFormatter.formatToUSD;

public class AccountDto {
    
    private String id;
    private boolean isEnabled;
    private Double cashBalance;
    private Double totalExpenses; 
    private Double totalCash;
    
    public String getTotalExpenses() {
        return formatToUSD(totalExpenses);
    }
    public void setTotalExpenses(Double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }
    public String getTotalCash() {
        return formatToUSD(totalCash);
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
    public String getCashBalance() {
        return formatToUSD(cashBalance);
    }
    public void setCashBalance(Double cashBalance) {
        this.cashBalance =  cashBalance;
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