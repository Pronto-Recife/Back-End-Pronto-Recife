package com.start.pronto_recife.Controllers;

import com.start.pronto_recife.DTOs.DTOResponsavel;
import com.start.pronto_recife.Service.ResponsavelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController("responsavel")
@RequiredArgsConstructor
public class ResponsavelController {
    private final ResponsavelService responsavelService;
    // GET controller
    @GetMapping("/responsavel")
    public ResponseEntity<List<DTOResponsavel>> getAllResponsavels(){
        return ResponseEntity.status(HttpStatus.OK).body(responsavelService.findAll());
    }
    // PUT controller
    @PutMapping("/responsavel/{id}")
    public ResponseEntity<DTOResponsavel> updateResponsavel(@PathVariable UUID id, @RequestBody @Valid DTOResponsavel dtoResponsavel){
        DTOResponsavel responsavel = responsavelService.updateResponsavel(id, dtoResponsavel);
        return ResponseEntity.status(HttpStatus.OK).body(responsavel);
    }
    // POST controller
    @PostMapping("/responsavel")
    public ResponseEntity<DTOResponsavel> saveResponsavel(@RequestBody DTOResponsavel dtoResponsavel){
        return ResponseEntity.status(HttpStatus.CREATED).body(responsavelService.createResponsavel(dtoResponsavel));}
}

