package control.finance.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import control.finance.domain.dto.CashDto;
import control.finance.domain.models.Cash;
import control.finance.domain.request.CreateCash;

@Mapper
public interface CashMapper {
    CashMapper Instance = Mappers.getMapper(CashMapper.class);
    CashDto cashToCashDto(Cash cash);
    Cash createCashToCash(CreateCash createCash);
}
