package control.finance.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import control.finance.domain.dto.ExpensesDto;
import control.finance.domain.models.Expenses;
import control.finance.domain.request.ExpensesRequest;
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
    public String post(ExpensesRequest expensesRequest){
        Expenses expenses = ExpensesMapper.Instance.expensesRequestToExpenses(expensesRequest);
        if(!accountService.updateExpensesAccount(expenses.getIdAccount(), expenses.getValue()))
            return  null;

        return expensesRepository.save(expenses).getId();
    }
    public boolean  put(String id, ExpensesRequest expensesRequest){
        Optional<Expenses> expenses = expensesRepository.findById(id);
         if(expenses.isEmpty()) return false;

        Expenses existingExpenses = expenses.get();
        BeanUtils.copyProperties(expensesRequest, existingExpenses, "id");
        if(!accountService.updateExpensesAccount(id, existingExpenses.getValue()))
            return  false;

        expensesRepository.save(existingExpenses);
        return true;
    }
}
