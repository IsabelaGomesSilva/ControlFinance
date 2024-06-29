package control.finance.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import control.finance.domain.dto.AccountDto;
import control.finance.domain.models.Account;
import control.finance.domain.request.CreateAccount;
import control.finance.domain.request.UpdateCashAcount;
import control.finance.domain.request.UpdateExpensesAccount;
import control.finance.mapper.AccountMapper;
import control.finance.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public AccountDto getById(String id){
        Account account = accountRepository.findById(id).orElse(null);
        return AccountMapper.Instance.accountToAccountDto(account); 
    }
    public List<AccountDto> getAll(){

        return accountRepository.findAll()
                .stream()
                .map(AccountMapper.Instance::accountToAccountDto)
                .collect(Collectors.toList());
    }

    public boolean  updateCashAccount(String idAccount,  Double value ){
        Optional<Account> accountOpt = accountRepository.findById(idAccount);
        if(accountOpt.isEmpty())
            return false;

        Account existingAccount = accountOpt.get();
        Double balance = AddValue(existingAccount.getCashBalance() , value);
        Double totalCash = AddValue(existingAccount.getTotalCash(), value);

        UpdateCashAcount updateCashAcount = new UpdateCashAcount(balance, totalCash);
       
        BeanUtils.copyProperties(updateCashAcount, existingAccount, "id, isEnabled, totalExpenses");
        accountRepository.save(existingAccount);
        return true;
    }  

    public boolean  updateExpensesAccount(String idAccount,  Double value ){
        Optional<Account> accountOpt = accountRepository.findById(idAccount);
        if(accountOpt.isEmpty())
            return false;

        Account existingAccount = accountOpt.get();
        Double balance = RemoveValue(existingAccount.getCashBalance() , value);
        Double totalExpenses = AddValue(existingAccount.getTotalExpenses(), value);

        UpdateExpensesAccount updateExpensesAccount= new UpdateExpensesAccount(balance, totalExpenses);
       
        BeanUtils.copyProperties(updateExpensesAccount, existingAccount, "id, isEnabled, totalCash");
        accountRepository.save(existingAccount);
        return true;
    }  
    public String post(CreateAccount accountRequest){
        Account account = AccountMapper.Instance.accountRequestToAccount(accountRequest);
        return accountRepository.save(account).getId();
    }

    private Double AddValue(Double currentValue, Double newValue ){
        return currentValue + newValue;
    }

    private Double RemoveValue(Double currentValue, Double newValue ){
        return currentValue - newValue;
    }

}
