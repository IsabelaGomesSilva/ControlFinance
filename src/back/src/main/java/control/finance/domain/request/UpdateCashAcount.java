package control.finance.domain.request;

import jakarta.validation.constraints.NotNull;

public class UpdateCashAcount {
    @NotNull
    private Double totalCash;
    
    public UpdateCashAcount( Double totalCash) {
        this.totalCash = totalCash;
    }

    public Double getTotalCash() {
        return totalCash;
    }
    public void setTotalCash(Double totalCash) {
        this.totalCash = totalCash;
    }

}
