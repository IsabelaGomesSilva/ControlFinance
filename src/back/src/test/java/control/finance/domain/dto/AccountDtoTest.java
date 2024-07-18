package control.finance.domain.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static control.finance.domain.CurrencyFormatter.formatToUSD;

public class AccountDtoTest {

    @Test
    public void testGettersAndSetters() {
        AccountDto accountDto = new AccountDto();

        String id = "123";
        accountDto.setId(id);
        assertThat(accountDto.getId()).isEqualTo(id);

        boolean isEnabled = true;
        accountDto.setIsEnabled(isEnabled);
        assertThat(accountDto.isIsEnabled()).isTrue();

        Double cashBalance = 1000.0;
        accountDto.setCashBalance(cashBalance);
        assertThat(accountDto.getCashBalance()).isEqualTo("$1,000.00");

        Double totalExpenses = 500.0;
        accountDto.setTotalExpenses(totalExpenses);
        assertThat(accountDto.getTotalExpenses()).isEqualTo(totalExpenses);

        Double totalCash = 1500.0;
        accountDto.setTotalCash(totalCash);
        assertThat(accountDto.getTotalCash()).isEqualTo(totalCash);
    }

    @Test
    public void testToString() {
        AccountDto accountDto = new AccountDto();
        accountDto.setId("123");
        accountDto.setIsEnabled(true);
        accountDto.setCashBalance( 1000.0);
        accountDto.setTotalExpenses(500.0);
        accountDto.setTotalCash(1500.0);

        String expectedString = "Account [id=123, isEnabled=true, cashBalance=1000.0, totalExpenses=500.0, totalCash=1500.0]";
        assertThat(accountDto.toString()).isEqualTo(expectedString);
    }
}
