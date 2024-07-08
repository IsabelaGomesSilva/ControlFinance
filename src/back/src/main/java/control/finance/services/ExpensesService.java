package control.finance.services;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import control.finance.domain.dto.ExpensesDto;
import control.finance.domain.models.Expenses;
import control.finance.domain.request.CreateExpenses;
import control.finance.domain.request.UpdateExpenses;
import control.finance.mapper.ExpensesMapper;
import control.finance.repository.ExpensesRepository;

@Service
public class ExpensesService {
    @Autowired
    private ExpensesRepository expensesRepository;
    
    @Autowired 
    private AccountService accountService;

    public ExpensesDto getById(String id){
        Expenses expenses = expensesRepository.findById(id).orElse(null);
        return ExpensesMapper.Instance.expensesToExpensesDto(expenses); 
    }

    public List<ExpensesDto> getAll(){
        return expensesRepository.findAll()
                .stream()
                .map(ExpensesMapper.Instance::expensesToExpensesDto)
                .collect(Collectors.toList());
    }

    public String post(CreateExpenses expensesRequest){
        Expenses expenses = ExpensesMapper.Instance.createExpensesToExpenses(expensesRequest);
        if(!accountService.addedExpensesAccount(expenses.getIdAccount(), expenses.getValue()))
            return  null;

        expenses.setAdditionDate(Date.from(Instant.now()));
        return expensesRepository.save(expenses).getId();
    }
    
    public boolean  put(String id, UpdateExpenses updateExpenses){
        Optional<Expenses> expenses = expensesRepository.findById(id);
         if(expenses.isEmpty()) return false;

        Expenses existingExpenses = expenses.get();
       
        if(!accountService.updateExpensesAccount(existingExpenses.getIdAccount(), existingExpenses.getValue(), updateExpenses.getValue()))
            return  false;

        BeanUtils.copyProperties(updateExpenses, existingExpenses, "id, isEnabled, additionDate, idAccount");
        existingExpenses.setUpdateDate(Date.from(Instant.now()));
        expensesRepository.save(existingExpenses);
        return true;
    }
}
