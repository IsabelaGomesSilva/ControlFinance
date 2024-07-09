package control.finance.domain.request;

public class CashRequest {
 
    private boolean isEnabled;
    private String description;
    private Double value;
    private String idCategory;
    private String idAccount;

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
}
