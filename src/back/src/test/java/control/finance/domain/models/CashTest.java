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
public class CashTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidCash() {
        Date now = new Date();
        Cash cash = new Cash(now, "category123", "account123", "Test Description", "123", true, now, 1000.0);

        Set<ConstraintViolation<Cash>> violations = validator.validate(cash);
        assertThat(violations).isEmpty();

        assertThat(cash.getId()).isEqualTo("123");
        assertThat(cash.getDescription()).isEqualTo("Test Description");
        assertThat(cash.isIsEnabled()).isTrue();
        assertThat(cash.getValue()).isEqualTo(1000.0);
        assertThat(cash.getAdditionDate()).isEqualTo(now);
        assertThat(cash.getUpdateDate()).isEqualTo(now);
        assertThat(cash.getIdAccount()).isEqualTo("account123");
        assertThat(cash.getIdCategory()).isEqualTo("category123");
    }

    @Test
    public void testInvalidCash() {
        Cash cash = new Cash(null, null, null, null, null, true, null, -1000.0);

        Set<ConstraintViolation<Cash>> violations = validator.validate(cash);
        assertThat(violations).isNotEmpty();
        assertThat(violations).hasSize(6); 
    }

    @Test
    public void testSettersAndGetters() {
        Cash cash = new Cash();
        Date now = new Date();

        cash.setId("123");
        cash.setDescription("Test Description");
        cash.setIsEnabled(true);
        cash.setValue(1000.0);
        cash.setAdditionDate(now);
        cash.setUpdateDate(now);
        cash.setIdAccount("account123");
        cash.setIdCategory("category123");

        assertThat(cash.getId()).isEqualTo("123");
        assertThat(cash.getDescription()).isEqualTo("Test Description");
        assertThat(cash.isIsEnabled()).isTrue();
        assertThat(cash.getValue()).isEqualTo(1000.0);
        assertThat(cash.getAdditionDate()).isEqualTo(now);
        assertThat(cash.getUpdateDate()).isEqualTo(now);
        assertThat(cash.getIdAccount()).isEqualTo("account123");
        assertThat(cash.getIdCategory()).isEqualTo("category123");
    }
}
