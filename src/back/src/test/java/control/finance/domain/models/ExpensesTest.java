package control.finance.domain.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Date;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ExpensesTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidExpenses() {
        Date now = new Date();
        Expenses expenses = new Expenses(now, "category123", "account123", "Test Description", "123", true, now, 1000.0, now);

        Set<ConstraintViolation<Expenses>> violations = validator.validate(expenses);
        assertThat(violations).isEmpty();

        assertThat(expenses.getId()).isEqualTo("123");
        assertThat(expenses.getDescription()).isEqualTo("Test Description");
        assertThat(expenses.isIsEnabled()).isTrue();
        assertThat(expenses.getValue()).isEqualTo(1000.0);
        assertThat(expenses.getAdditionDate()).isEqualTo(now);
        assertThat(expenses.getUpdateDate()).isEqualTo(now);
        assertThat(expenses.getIdAccount()).isEqualTo("account123");
        assertThat(expenses.getIdCategory()).isEqualTo("category123");
        assertThat(expenses.getDueDate()).isEqualTo(now);
    }

    @Test
    public void testInvalidExpenses() {
        Expenses expenses = new Expenses(null, null, null, null, null, true, null, -1000.0, null);

        Set<ConstraintViolation<Expenses>> violations = validator.validate(expenses);
        assertThat(violations).isNotEmpty();
        assertThat(violations).hasSize(7); 
    }

    @Test
    public void testSettersAndGetters() {
        Expenses expenses = new Expenses();
        Date now = new Date();

        expenses.setId("123");
        expenses.setDescription("Test Description");
        expenses.setIsEnabled(true);
        expenses.setValue(1000.0);
        expenses.setAdditionDate(now);
        expenses.setUpdateDate(now);
        expenses.setIdAccount("account123");
        expenses.setIdCategory("category123");
        expenses.setDueDate(now);

        assertThat(expenses.getId()).isEqualTo("123");
        assertThat(expenses.getDescription()).isEqualTo("Test Description");
        assertThat(expenses.isIsEnabled()).isTrue();
        assertThat(expenses.getValue()).isEqualTo(1000.0);
        assertThat(expenses.getAdditionDate()).isEqualTo(now);
        assertThat(expenses.getUpdateDate()).isEqualTo(now);
        assertThat(expenses.getIdAccount()).isEqualTo("account123");
        assertThat(expenses.getIdCategory()).isEqualTo("category123");
        assertThat(expenses.getDueDate()).isEqualTo(now);
    }
}