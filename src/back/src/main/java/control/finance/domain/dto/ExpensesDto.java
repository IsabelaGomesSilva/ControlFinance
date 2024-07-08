package control.finance.domain.dto;

import java.util.Date;

public class ExpensesDto extends CashDto {
    
    private Date dueDate;
    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    
    @Override
    public String toString() {
        return "Expenses [ dueDate=" + dueDate + " ]";
    }
   
}
