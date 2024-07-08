package control.finance.services;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import control.finance.domain.dto.CashDto;
import control.finance.domain.models.Cash;
import control.finance.domain.request.CreateCash;
import control.finance.domain.request.UpdateCash;
import control.finance.mapper.CashMapper;
import control.finance.repository.CashRepository;

@Service
public class CashService {
    @Autowired
    private CashRepository cashRepository;
    
    @Autowired
    private AccountService accountService;

    public CashDto getById(String id){
        Cash cash = cashRepository.findById(id).orElse(null);
        return CashMapper.Instance.cashToCashDto(cash); 
    }
    
    public List<CashDto> getAll(){
        return cashRepository.findAll()
                .stream()
                .map(CashMapper.Instance::cashToCashDto)
                .collect(Collectors.toList());
    }

    public String post(CreateCash cashRequest){
        Cash cash = CashMapper.Instance.createCashToCash(cashRequest);
        if(!accountService.addedCashAccount(cash.getIdAccount(),cash.getValue()))
            return  null;
        
        cash.setAdditionDate(Date.from(Instant.now()));
        return cashRepository.save(cash).getId();
    }

    public boolean  put(String id, UpdateCash updateCash){
        Optional<Cash> cash = cashRepository.findById(id);
        if(cash.isEmpty()) return false;

        Cash existingCash = cash.get();
        
        if(!accountService.updateCashAccount(existingCash.getIdAccount(), existingCash.getValue(), updateCash.getValue()))
            return  false;

        BeanUtils.copyProperties(updateCash, existingCash, "id, isEnabled, additionDate, idAccount");    
        existingCash.setUpdateDate(Date.from(Instant.now()));
        cashRepository.save(existingCash);
        return true;
    }
}
