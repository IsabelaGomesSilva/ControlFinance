package control.finance.domain.request;

import java.util.Date;

public class ExpensesRequest extends CashRequest {
    
    private Date dueDate;
    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
