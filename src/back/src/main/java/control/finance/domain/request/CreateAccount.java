package control.finance.domain.request;

public class CreateAccount {
    
    private boolean isEnabled;
    private Double cashBalance;
    private Double totalExpenses; 
    private Double totalCash;
    
    public CreateAccount( boolean isEnabled, Double cashBalance, Double totalExpenses, Double totalCash) {
        this.isEnabled = isEnabled;
        this.cashBalance = cashBalance;
        this.totalExpenses = totalExpenses;
        this.totalCash = totalCash;
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

    public boolean isIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

}