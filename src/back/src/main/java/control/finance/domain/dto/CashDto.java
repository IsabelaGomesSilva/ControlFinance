package control.finance.domain.dto;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class CashDto {
  @Id
    private String id;
    private boolean isEnabled;
    private String description;
    private Double value;
    private Date  additionDate;
    private Date updateDate;
    private String idAccount;
    private String idCategory;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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
    public String getCategory() {
        return idCategory;
    }
    public void setCategory(String idCategory) {
        this.idCategory = idCategory;
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
    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    @Override
    public String toString() {
        return "Expenses [id= " + id + ", isEnabled= "+ isEnabled +  ", idAccount= "+ idAccount +", description= " + description
                + ", value=" + value + ", category= " + idCategory + ", additionDate= " + additionDate + ", updateDate= "
                + updateDate + "]";
    }
}
