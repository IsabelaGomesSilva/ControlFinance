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

import control.finance.domain.dto.CashDto;
import control.finance.domain.request.CreateCash;
import control.finance.domain.request.UpdateCash;
import control.finance.services.CashService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping(value = "api/v1/cash")
@Tag(name = "Cash Controller")
public class CashController {
@Autowired
    private CashService cashService;

    @GetMapping
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200"),
        @ApiResponse(responseCode = "204")
    })
    public ResponseEntity<List<CashDto>> getAll(){
        List<CashDto> cash = cashService.getAll();
        return ResponseEntity.ok(cash);
    }

    @GetMapping("/{id}")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200"),
        @ApiResponse(responseCode = "404")
    })
    public ResponseEntity<CashDto> getById(@PathVariable String id){
        CashDto cash = cashService.getById(id);
        return ResponseEntity.ok(cash);
    }

    @PostMapping
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "400"),
        @ApiResponse(responseCode = "201")
    })
    public ResponseEntity<CashDto> post(@RequestBody CreateCash entity) {

        if(entity == null){
            return ResponseEntity.badRequest().build();
        }

        String idCash = cashService.post(entity);
        if(idCash == null){
            return ResponseEntity.badRequest().build();
        }

        URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(idCash)
                    .toUri();
    
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "400"),
        @ApiResponse(responseCode = "404"),
        @ApiResponse(responseCode = "202")
    })
    public ResponseEntity<CashDto> put(@PathVariable String id, @RequestBody UpdateCash entity) {

        if(entity == null){
            return ResponseEntity.badRequest().build();
        }

        if(!cashService.put(id, entity)){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.accepted().build();
    }
}
