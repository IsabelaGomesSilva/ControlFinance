package control.finance.mapper;

import control.finance.domain.dto.AccountDto;
import control.finance.domain.models.Account;
import control.finance.domain.request.CreateAccount;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-29T15:53:16-0300",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountDto accountToAccountDto(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountDto accountDto = new AccountDto();

        accountDto.setTotalExpenses( account.getTotalExpenses() );
        accountDto.setTotalCash( account.getTotalCash() );
        accountDto.setId( account.getId() );
        accountDto.setCashBalance( account.getCashBalance() );
        accountDto.setIsEnabled( account.isIsEnabled() );

        return accountDto;
    }

    @Override
    public Account accountRequestToAccount(CreateAccount accountRequest) {
        if ( accountRequest == null ) {
            return null;
        }

        Account account = new Account();

        account.setCashBalance( accountRequest.getCashBalance() );
        account.setTotalExpenses( accountRequest.getTotalExpenses() );
        account.setTotalCash( accountRequest.getTotalCash() );
        account.setIsEnabled( accountRequest.isIsEnabled() );

        return account;
    }
}
