package control.finance.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import control.finance.domain.dto.ExpensesDto;
import control.finance.domain.request.ExpensesRequest;
import control.finance.services.ExpensesService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "api/v1/expenses")
@Tag(name = "Expenses Controller")
public class ExpensesController {
@Autowired
    private ExpensesService expensesService;

    @GetMapping
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200"),
        @ApiResponse(responseCode = "204")
    })
    public ResponseEntity<List<ExpensesDto>> getAll(){
        List<ExpensesDto> expenses = expensesService.getAll();
        if(expenses == null)
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(expenses);
    }

    @GetMapping("/{id}")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200"),
        @ApiResponse(responseCode = "404")
    })
    public ResponseEntity<ExpensesDto> getById(@PathVariable String id){
        ExpensesDto expenses = expensesService.getById(id);
        if (expenses == null) 
            return  ResponseEntity.notFound().build();
            
        return ResponseEntity.ok(expenses);
    }

    @PostMapping
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "400"),
        @ApiResponse(responseCode = "201")
    })
    public ResponseEntity<ExpensesDto> post(@RequestBody ExpensesRequest entity) {

        if(entity == null)
            return ResponseEntity.badRequest().build();

        String idExpenses = expensesService.post(entity);
        if(idExpenses == null)
            return ResponseEntity.badRequest().build();

        URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(idExpenses)
                    .toUri();
    
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "404"),
        @ApiResponse(responseCode = "400"),
        @ApiResponse(responseCode = "202")
    })
    public ResponseEntity<ExpensesDto> put(@PathVariable String id, @RequestBody ExpensesRequest entity) {

        if(entity == null)
            return ResponseEntity.badRequest().build();
        
        if(!expensesService.put(id, entity))
            return ResponseEntity.notFound().build();
        
        return ResponseEntity.accepted().build();
    }
}
