package control.finance.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import control.finance.domain.dto.AccountDto;
import control.finance.domain.models.Account;
import control.finance.domain.request.CreateAccount;

@Mapper
public interface  AccountMapper {
    AccountMapper Instance = Mappers.getMapper(AccountMapper.class);
    AccountDto accountToAccountDto(Account account);
    Account accountRequestToAccount(CreateAccount accountRequest);
}
