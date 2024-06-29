package control.finance.mapper;

import control.finance.domain.dto.CashDto;
import control.finance.domain.models.Cash;
import control.finance.domain.request.CashRequest;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-29T15:53:16-0300",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
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
        cashDto.setAdditionDate( cash.getAdditionDate() );
        cashDto.setUpdateDate( cash.getUpdateDate() );
        cashDto.setIsEnabled( cash.isIsEnabled() );
        cashDto.setIdAccount( cash.getIdAccount() );

        return cashDto;
    }

    @Override
    public Cash cashRequestToCash(CashRequest cashRequest) {
        if ( cashRequest == null ) {
            return null;
        }

        Cash cash = new Cash();

        cash.setDescription( cashRequest.getDescription() );
        cash.setValue( cashRequest.getValue() );
        cash.setIsEnabled( cashRequest.isIsEnabled() );
        cash.setIdAccount( cashRequest.getIdAccount() );

        return cash;
    }
}
