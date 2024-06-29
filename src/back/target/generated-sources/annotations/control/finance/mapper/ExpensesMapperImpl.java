package control.finance.mapper;

import control.finance.domain.dto.ExpensesDto;
import control.finance.domain.models.Expenses;
import control.finance.domain.request.ExpensesRequest;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-29T15:53:16-0300",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
public class ExpensesMapperImpl implements ExpensesMapper {

    @Override
    public ExpensesDto expensesToExpensesDto(Expenses expenses) {
        if ( expenses == null ) {
            return null;
        }

        ExpensesDto expensesDto = new ExpensesDto();

        expensesDto.setId( expenses.getId() );
        expensesDto.setDescription( expenses.getDescription() );
        expensesDto.setValue( expenses.getValue() );
        expensesDto.setAdditionDate( expenses.getAdditionDate() );
        expensesDto.setUpdateDate( expenses.getUpdateDate() );
        expensesDto.setIsEnabled( expenses.isIsEnabled() );
        expensesDto.setIdAccount( expenses.getIdAccount() );
        expensesDto.setDueDate( expenses.getDueDate() );

        return expensesDto;
    }

    @Override
    public Expenses expensesRequestToExpenses(ExpensesRequest expensesRequest) {
        if ( expensesRequest == null ) {
            return null;
        }

        Expenses expenses = new Expenses();

        expenses.setDescription( expensesRequest.getDescription() );
        expenses.setValue( expensesRequest.getValue() );
        expenses.setIsEnabled( expensesRequest.isIsEnabled() );
        expenses.setIdAccount( expensesRequest.getIdAccount() );
        expenses.setDueDate( expensesRequest.getDueDate() );

        return expenses;
    }
}
