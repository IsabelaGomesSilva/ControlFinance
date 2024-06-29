package control.finance.domain.request;

public class UpdateCashAcount {
  
    private Double cashBalance;
    private Double totalCash;
    
    public UpdateCashAcount() {
    }

    public UpdateCashAcount( Double cashBalance, Double totalCash) {
        this.cashBalance = cashBalance;
        this.totalCash = totalCash;
    }

    public Double getCashBalance() {
        return cashBalance;
    }
    public void setCashBalance(Double cashBalance) {
        this.cashBalance = cashBalance;
    }
    public Double getTotalCash() {
        return totalCash;
    }
    public void setTotalCash(Double totalCash) {
        this.totalCash = totalCash;
    }

}
