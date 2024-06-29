package control.finance.domain.request;

public class UpdateExpensesAccount {
        
    private Double cashBalance;
    private Double totalExpenses; 
    
    public UpdateExpensesAccount(Double cashBalance, Double totalExpenses) {
        this.cashBalance = cashBalance;
        this.totalExpenses = totalExpenses;
    }

    public UpdateExpensesAccount() {
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

}
