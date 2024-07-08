package control.finance.domain.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class UpdateCash {
    @NotNull
    private String description;

    @NotNull
    @PositiveOrZero
    private Double value;

    @NotNull
    private String idCategory;

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
}
