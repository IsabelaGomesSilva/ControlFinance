package control.finance.domain.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AccountTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidAccount() {
        Account account = new Account("123", true, 500.0, 1500.0);
        account.setCashBalance();

        Set<ConstraintViolation<Account>> violations = validator.validate(account);
        assertThat(violations).isEmpty();

        assertThat(account.getId()).isEqualTo("123");
        assertThat(account.isIsEnabled()).isTrue();
        assertThat(account.getTotalExpenses()).isEqualTo(500.0);
        assertThat(account.getTotalCash()).isEqualTo(1500.0);
        assertThat(account.getCashBalance()).isEqualTo(1000.0);
    }

    @Test
    public void testInvalidAccount() {
        Account account = new Account(null, true, -500.0, -1500.0);

        Set<ConstraintViolation<Account>> violations = validator.validate(account);
        assertThat(violations).isNotEmpty();
        assertThat(violations).hasSize(4); 
    }

    @Test
    public void testUpdateCashBalance() {
        Account account = new Account("123", true, 500.0, 1500.0);
        account.setTotalExpenses(600.0);
        account.setTotalCash(1600.0);
        account.setCashBalance();

        assertThat(account.getCashBalance()).isEqualTo(1000.0);
    }
}
