package control.finance.mapper;

import control.finance.domain.dto.CashDto;
import control.finance.domain.models.Cash;
import control.finance.domain.request.CreateCash;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-15T10:24:40-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.11 (Eclipse Adoptium)"
)
public class CashMapperImpl implements CashMapper {

    @Override
    public CashDto cashToCashDto(Cash cash) {
        if ( cash == null ) {
            return null;
        }

        CashDto cashDto = new CashDto();

        cashDto.setId( cash.getId() );
        cashDto.setDescription( cash.getDescription() );
        cashDto.setValue( cash.getValue() );
        cashDto.setIdCategory( cash.getIdCategory() );
        cashDto.setAdditionDate( cash.getAdditionDate() );
        cashDto.setUpdateDate( cash.getUpdateDate() );
        cashDto.setIsEnabled( cash.isIsEnabled() );
        cashDto.setIdAccount( cash.getIdAccount() );

        return cashDto;
    }

    @Override
    public Cash createCashToCash(CreateCash createCash) {
        if ( createCash == null ) {
            return null;
        }

        Cash cash = new Cash();

        cash.setDescription( createCash.getDescription() );
        cash.setValue( createCash.getValue() );
        cash.setIdCategory( createCash.getIdCategory() );
        cash.setIdAccount( createCash.getIdAccount() );

        return cash;
    }
}
