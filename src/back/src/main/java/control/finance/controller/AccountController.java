package control.finance.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import control.finance.domain.dto.AccountDto;
import control.finance.domain.request.CreateAccount;
import control.finance.services.AccountService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "api/v1/accounts")
@Tag(name = "Account Controller")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200"),
        @ApiResponse(responseCode = "204")
    })
    public ResponseEntity<List<AccountDto>> getAll(){
        List<AccountDto> accounts = accountService.getAll();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/{id}")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200"),
        @ApiResponse(responseCode = "404")
    })
    public ResponseEntity<AccountDto> getById(@PathVariable String id){
        AccountDto account = accountService.getById(id);
        return ResponseEntity.ok(account);
    }

    @PostMapping
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "400"),
        @ApiResponse(responseCode = "201")
    })
    public ResponseEntity<AccountDto> post(@RequestBody CreateAccount entity) {

        if(entity == null){
            return ResponseEntity.badRequest().build();
        }

        String idAccount = accountService.post(entity);
        if(idAccount == null){
            return ResponseEntity.badRequest().build();
        }

        URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(idAccount)
                    .toUri();
    
        return ResponseEntity.created(uri).build();
    }
    
}