package control.finance.domain.request;

import jakarta.validation.constraints.NotNull;

public class UpdateExpensesAccount {
    @NotNull    
    private Double totalExpenses; 
    
    public UpdateExpensesAccount( Double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public Double getTotalExpenses() {
        return totalExpenses;
    }
    public void setTotalExpenses(Double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }
}
