package control.finance.domain.request;

import java.util.Date;

import jakarta.validation.constraints.NotNull;

public class CreateExpenses extends CreateCash {
    @NotNull
    private Date dueDate;

    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
