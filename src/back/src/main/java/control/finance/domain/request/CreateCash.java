package control.finance.domain.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class CreateCash {
    @NotNull
    private String description;

    @NotNull
    @PositiveOrZero
    private Double value;

    @NotNull
    private String idCategory;

    @NotNull
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
    public String getIdCategory() {
        return idCategory;
    }
    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }
    public String getIdAccount() {
        return idAccount;
    }
    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }
}
