package com.start.pronto_recife.Controllers;

import com.start.pronto_recife.DTOs.DTOResponsavel;
import com.start.pronto_recife.Service.ResponsavelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/responsavel")
public class ResponsavelController {
    private final ResponsavelService responsavelService;


    @GetMapping()
    public ResponseEntity<List<DTOResponsavel>> getAllResponsavel() {
        return ResponseEntity.status(HttpStatus.OK).body(responsavelService.findAll());
    }


    @PutMapping("/responsavel/{id}")
    public ResponseEntity<DTOResponsavel> updateResponsavel(@PathVariable String id, @RequestBody @Valid DTOResponsavel dtoResponsavel) {
        DTOResponsavel updateresponsavel = responsavelService.updateResponsavel(id, dtoResponsavel);
        return ResponseEntity.status(HttpStatus.OK).body(updateresponsavel);
    }


    @PostMapping("/responsavel")
    public ResponseEntity<DTOResponsavel> saveResponsavel(@RequestBody DTOResponsavel dtoResponsavel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(responsavelService.createResponsavel(dtoResponsavel));
    }

    @DeleteMapping("/delresponsavel/{id}")
    public ResponseEntity<Void> deleteResponsavel(@PathVariable String id) {
        responsavelService.deleteResponsavel(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}


