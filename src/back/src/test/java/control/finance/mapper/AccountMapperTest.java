package control.finance.mapper;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import control.finance.domain.dto.AccountDto;
import control.finance.domain.models.Account;
import control.finance.domain.request.CreateAccount;

/**
 *
 * @author isabela.gomes
 */
public class AccountMapperTest {
    private final AccountMapper accountMapper = AccountMapper.Instance;

    @Test
    public void testAccountToAccountDto() {

        Account account = new Account();
        account.setId("01");
        account.setIsEnabled(true);
        account.setTotalCash(10.00);
        account.setTotalExpenses(5.00);
        account.setCashBalance();

        AccountDto accountDto = accountMapper.accountToAccountDto(account);

        assertNotNull(accountDto);
        assertEquals(account.getId(), accountDto.getId());
        assertEquals(account.getCashBalance(), accountDto.getCashBalance());
        assertThat(accountDto.isIsEnabled()).isTrue();
        assertEquals(account.getTotalCash(), accountDto.getTotalCash());
        assertEquals(account.getTotalExpenses(), accountDto.getTotalExpenses());
    }

    @Test
    public void testAccountRequestToAccount() {
        
        CreateAccount createAccount = new CreateAccount();
        createAccount.setIsEnabled(true);
        createAccount.setTotalCash(5.00);
        createAccount.setTotalExpenses(5.00);

        
        Account account = accountMapper.createAccountToAccount(createAccount);

        assertNotNull(account);
        assertEquals(account.getTotalCash(), createAccount.getTotalCash());
        assertEquals(account.getTotalExpenses(), createAccount.getTotalExpenses());
        assertThat(account.isIsEnabled()).isTrue();
        }
}