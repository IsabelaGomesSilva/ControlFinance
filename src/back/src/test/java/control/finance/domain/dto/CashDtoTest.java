package control.finance.domain.dto;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class CashDtoTest {

    @Test
    public void testGettersAndSetters() {
        CashDto cashDto = new CashDto();

        String id = "123";
        cashDto.setId(id);
        assertThat(cashDto.getId()).isEqualTo(id);

        String description = "Sample Description";
        cashDto.setDescription(description);
        assertThat(cashDto.getDescription()).isEqualTo(description);

        Double value = 1000.0;
        cashDto.setValue(value);
        assertThat(cashDto.getValue()).isEqualTo(value);

        String idCategory = "456";
        cashDto.setIdCategory(idCategory);
        assertThat(cashDto.getIdCategory()).isEqualTo(idCategory);

        Date additionDate = new Date();
        cashDto.setAdditionDate(additionDate);
        assertThat(cashDto.getAdditionDate()).isEqualTo(additionDate);

        Date updateDate = new Date();
        cashDto.setUpdateDate(updateDate);
        assertThat(cashDto.getUpdateDate()).isEqualTo(updateDate);

        boolean isEnabled = true;
        cashDto.setIsEnabled(isEnabled);
        assertThat(cashDto.isIsEnabled()).isTrue();

        String idAccount = "789";
        cashDto.setIdAccount(idAccount);
        assertThat(cashDto.getIdAccount()).isEqualTo(idAccount);
    }

    @Test
    public void testToString() {
        CashDto cashDto = new CashDto();
        cashDto.setId("123");
        cashDto.setIsEnabled(true);
        cashDto.setDescription("Sample Description");
        cashDto.setValue(1000.0);
        cashDto.setIdCategory("456");
        Date additionDate = new Date();
        cashDto.setAdditionDate(additionDate);
        Date updateDate = new Date();
        cashDto.setUpdateDate(updateDate);
        cashDto.setIdAccount("789");

        String expectedString = "Expenses [id= 123, isEnabled= true, idAccount= 789, description= Sample Description"
                + ", value=1000.0, category= 456, additionDate= " + additionDate + ", updateDate= "
                + updateDate + "]";
        assertThat(cashDto.toString()).isEqualTo(expectedString);
    }
}
