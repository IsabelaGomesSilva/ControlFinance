package control.finance.mapper;

import java.util.Date;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import control.finance.domain.dto.CashDto;
import control.finance.domain.models.Cash;
import control.finance.domain.request.CreateCash;

public class CashMapperTest {
    private final CashMapper cashMapper = CashMapper.Instance;

    @Test
    public void testAccountToAccountDto() {

        Cash cash = new Cash();
        cash.setId("01");
        cash.setAdditionDate(new Date(01/03/2024));
        cash.setDescription("Description");
        cash.setIdAccount("03");
        cash.setIdCategory("04");
        cash.setIsEnabled(true);
        cash.setUpdateDate(new Date(04/04/2024));
        cash.setValue(30.4);
        
       
        CashDto cashDto = cashMapper.cashToCashDto(cash);

        assertNotNull(cashDto);
        assertEquals(cash.getValue(), cashDto.getValue());
        assertEquals(cash.getUpdateDate(), cashDto.getUpdateDate());
        assertEquals(cash.isIsEnabled(), cashDto.isIsEnabled());
        assertEquals(cash.getIdCategory(), cashDto.getIdCategory());
        assertEquals(cash.getIdAccount(), cashDto.getIdAccount());
        assertEquals(cash.getDescription(), cashDto.getDescription());
        assertEquals(cash.getAdditionDate(), cashDto.getAdditionDate());
        assertEquals(cash.getId(), cashDto.getId());
    }

    @Test
    public void testCashRequestToCash() {
        
        CreateCash  createCash = new CreateCash();
        createCash.setDescription("Description");
        createCash.setIdAccount("03");
        createCash.setValue(30.4);
        createCash.setIdCategory("03");
        
        Cash cash = cashMapper.createCashToCash(createCash);

        assertNotNull(cash);
        assertEquals(cash.getValue(), createCash.getValue());
        assertEquals(cash.getUpdateDate(), null);
        assertThat(cash.isIsEnabled()).isFalse();
        assertEquals(cash.getIdCategory(), createCash.getIdCategory());
        assertEquals(cash.getIdAccount(), createCash.getIdAccount());
        assertEquals(cash.getDescription(), createCash.getDescription());
        assertEquals(cash.getAdditionDate(), null);
        assertEquals(cash.getId(), null);
       
    }
}
