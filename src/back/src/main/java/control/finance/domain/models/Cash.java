package control.finance.domain.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Document(collection = "cash")
public class Cash {
    @Id
    @NotNull
    private String id;

    @NotNull
    private String description;

    @NotNull
    private boolean isEnabled;

    @NotNull
    @PositiveOrZero
    private Double value;

    @NotNull
    private Date additionDate;
    private Date updateDate;

    @NotNull
    private String idAccount;
    
    @Field("category_cash")
    @NotNull
    private String idCategory;
    
    
    public Cash() {}

    public Cash(Date additionDate, String idCategory, String idAccount, String description, String id, boolean isEnabled, Date updateDate, Double value) {
        this.additionDate = additionDate;
        this.idCategory = idCategory;
        this.idAccount = idAccount;
        this.description = description;
        this.id = id;
        this.isEnabled = isEnabled;
        this.updateDate = updateDate;
        this.value = value;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getValue() {
        return value;
    }
    public void setValue(Double value) {
        this.value = value;
    }
    public String getIdCategory() {
        return idCategory;
    }
    public void setIdCategory(String category) {
        this.idCategory = category;
    }
    public Date getAdditionDate() {
        return additionDate;
    }
    public void setAdditionDate(Date additionDate) {
        this.additionDate = additionDate;
    }
    public Date getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    public boolean isIsEnabled() {
        return isEnabled;
    }
    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }
}
