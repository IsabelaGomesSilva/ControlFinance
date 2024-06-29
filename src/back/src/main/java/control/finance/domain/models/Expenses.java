package control.finance.domain.models;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "expenses")
public class Expenses extends Cash {
    
    @Field("category_expenses")
    private String idCategory;
    private Date dueDate;
    public Expenses() {}

    public Expenses(Date additionDate, String idCategory, String idAccount , String description, String id, boolean isEnabled, 
            Date updateDate, Double value,  Date dueDate) {
        super(additionDate, idCategory, idAccount ,description, id, isEnabled, updateDate, value);
        this.idCategory = idCategory;
        this.dueDate = dueDate;
    }
    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String getIdCategory() {
        return idCategory;
    }

    @Override
    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }
   
}
