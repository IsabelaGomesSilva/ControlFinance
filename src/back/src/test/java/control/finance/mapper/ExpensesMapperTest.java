package control.finance.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.Test;

import control.finance.domain.dto.ExpensesDto;
import control.finance.domain.models.Expenses;
import control.finance.domain.request.CreateExpenses;

public class ExpensesMapperTest {
 private final ExpensesMapper expensesMapper = ExpensesMapper.Instance;

    @Test
    public void testExpenesToExpenesDto() {

        Expenses expenses = new Expenses();
        expenses.setId("01");
        expenses.setAdditionDate(new Date(01/03/2024));
        expenses.setDescription("Description");
        expenses.setIdAccount("03");
        expenses.setIdCategory("04");
        expenses.setIsEnabled(true);
        expenses.setUpdateDate(new Date(04/04/2024));
        expenses.setValue(30.4);
        expenses.setDueDate(new Date(02/02/2025));
        
       
        ExpensesDto expensesDto = expensesMapper.expensesToExpensesDto(expenses);

        assertNotNull(expensesDto);
        assertEquals(expenses.getValue(), expensesDto.getValue());
        assertEquals(expenses.getUpdateDate(), expensesDto.getUpdateDate());
        assertEquals(expenses.isIsEnabled(), expensesDto.isIsEnabled());
        assertEquals(expenses.getIdCategory(), expensesDto.getIdCategory());
        assertEquals(expenses.getIdAccount(), expensesDto.getIdAccount());
        assertEquals(expenses.getDescription(), expensesDto.getDescription());
        assertEquals(expenses.getAdditionDate(), expensesDto.getAdditionDate());
        assertEquals(expenses.getId(), expensesDto.getId());
    }

    @Test
    public void testExpenseRequestToExpenses() {
        
        CreateExpenses  createExpenses = new CreateExpenses();
        createExpenses.setDescription("Description");
        createExpenses.setIdAccount("03");
        createExpenses.setValue(30.4);
        createExpenses.setIdCategory("03");
        
        Expenses expenses = expensesMapper.createExpensesToExpenses(createExpenses);

        assertNotNull(expenses);
        assertEquals(expenses.getValue(), createExpenses.getValue());
        assertEquals(expenses.getUpdateDate(), null);
        assertThat(expenses.isIsEnabled()).isFalse();
        assertEquals(expenses.getIdCategory(), createExpenses.getIdCategory());
        assertEquals(expenses.getIdAccount(), createExpenses.getIdAccount());
        assertEquals(expenses.getDescription(), createExpenses.getDescription());
        assertEquals(expenses.getAdditionDate(), null);
        assertEquals(expenses.getId(), null);
       
    }
}
