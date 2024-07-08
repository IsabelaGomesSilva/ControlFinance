package control.finance.domain.dto;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpensesDtoTest {

    @Test
    public void testGettersAndSetters() {
        ExpensesDto expensesDto = new ExpensesDto();

        String id = "123";
        expensesDto.setId(id);
        assertThat(expensesDto.getId()).isEqualTo(id);

        String description = "Sample Description";
        expensesDto.setDescription(description);
        assertThat(expensesDto.getDescription()).isEqualTo(description);

        Double value = 1000.0;
        expensesDto.setValue(value);
        assertThat(expensesDto.getValue()).isEqualTo(value);

        String idCategory = "456";
        expensesDto.setIdCategory(idCategory);
        assertThat(expensesDto.getIdCategory()).isEqualTo(idCategory);

        Date additionDate = new Date();
        expensesDto.setAdditionDate(additionDate);
        assertThat(expensesDto.getAdditionDate()).isEqualTo(additionDate);

        Date updateDate = new Date();
        expensesDto.setUpdateDate(updateDate);
        assertThat(expensesDto.getUpdateDate()).isEqualTo(updateDate);

        boolean isEnabled = true;
        expensesDto.setIsEnabled(isEnabled);
        assertThat(expensesDto.isIsEnabled()).isTrue();

        String idAccount = "789";
        expensesDto.setIdAccount(idAccount);
        assertThat(expensesDto.getIdAccount()).isEqualTo(idAccount);

        Date dueDate = new Date();
        expensesDto.setDueDate(dueDate);
        assertThat(expensesDto.getDueDate()).isEqualTo(dueDate);
    }

    @Test
    public void testToString() {
        ExpensesDto expensesDto = new ExpensesDto();
        expensesDto.setId("123");
        expensesDto.setIsEnabled(true);
        expensesDto.setDescription("Sample Description");
        expensesDto.setValue(1000.0);
        expensesDto.setIdCategory("456");
        Date additionDate = new Date();
        expensesDto.setAdditionDate(additionDate);
        Date updateDate = new Date();
        expensesDto.setUpdateDate(updateDate);
        expensesDto.setIdAccount("789");
        Date dueDate = new Date();
        expensesDto.setDueDate(dueDate);

        String expectedString = "Expenses [ dueDate=" + dueDate + " ]";
        assertThat(expensesDto.toString()).isEqualTo(expectedString);
    }
}
