package com.start.pronto_recife.Controllers;

import com.start.pronto_recife.DTOs.DTOConsulta;
import com.start.pronto_recife.DTOs.DTOResponsavel;
import com.start.pronto_recife.Service.ResponsavelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("responsavel")
public class ResponsavelController {
    private final ResponsavelService responsavelService;

    // GET controller
    @GetMapping("/findAll")
    public ResponseEntity<List<DTOResponsavel>> getAllResponsavels() {
        return ResponseEntity.status(HttpStatus.OK).body(responsavelService.findAll());
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<DTOResponsavel> getResponsavel(@PathVariable String id) {
        DTOResponsavel dtoResponsavel = responsavelService.getResponsavelById(id);
        return ResponseEntity.ok().body(dtoResponsavel);

    }

    // PUT controller
    @PutMapping("/update/{id}")
    public ResponseEntity<DTOResponsavel> updateResponsavel(@PathVariable String id, @RequestBody @Valid DTOResponsavel dtoResponsavel) {
        DTOResponsavel responsavel = responsavelService.updateResponsavel(id, dtoResponsavel);
        return ResponseEntity.status(HttpStatus.OK).body(responsavel);
    }

    // POST controller
    @PostMapping("/create")
    public ResponseEntity<DTOResponsavel> saveResponsavel(@RequestBody DTOResponsavel dtoResponsavel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(responsavelService.createResponsavel(dtoResponsavel));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteResponsavel(@PathVariable String id) {
        responsavelService.deleteResponsavel(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}


