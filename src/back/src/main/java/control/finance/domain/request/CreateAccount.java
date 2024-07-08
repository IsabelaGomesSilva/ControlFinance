package control.finance.domain.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class CreateAccount {
    @NotNull
    private boolean isEnabled;

    @NotNull
    @PositiveOrZero
    private Double totalExpenses; 

    @NotNull
    @PositiveOrZero
    private Double totalCash;
    
    public CreateAccount( boolean isEnabled, Double totalExpenses, Double totalCash) {
        this.isEnabled = isEnabled;
        this.totalExpenses = totalExpenses;
        this.totalCash = totalCash;
    }

    public CreateAccount() {}

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