package control.finance.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import control.finance.domain.dto.ExpensesDto;
import control.finance.domain.models.Expenses;
import control.finance.domain.request.ExpensesRequest;

@Mapper
public interface ExpensesMapper {
    ExpensesMapper Instance = Mappers.getMapper(ExpensesMapper.class);
    ExpensesDto expensesToExpensesDto(Expenses expenses);
    Expenses expensesRequestToExpenses(ExpensesRequest expensesRequest);

}
