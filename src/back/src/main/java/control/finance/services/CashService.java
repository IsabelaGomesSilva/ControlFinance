package control.finance.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import control.finance.domain.dto.CashDto;
import control.finance.domain.models.Cash;
import control.finance.domain.request.CashRequest;
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

    public String post(CashRequest cashRequest){
        Cash cash = CashMapper.Instance.cashRequestToCash(cashRequest);
       System.out.println( "AAAAAAAAAAQQQQQQUUUUUUIIIIIIIIIIIIIIIIIIIIIIIII:   " + cash.getIdAccount());
        if(!accountService.updateCashAccount(cash.getIdAccount(),cash.getValue()))
            return  null;

        return cashRepository.save(cash).getId();
    }

    public boolean  put(String id, CashRequest CashRequest){
        Optional<Cash> cash = cashRepository.findById(id);
        if(cash.isEmpty()) return false;

        Cash existingCash = cash.get();
        BeanUtils.copyProperties(CashRequest, existingCash, "id");

        if(!accountService.updateCashAccount(id,existingCash.getValue()))
            return  false;

        cashRepository.save(existingCash);
        return true;
    }
}
