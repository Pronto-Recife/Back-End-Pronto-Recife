package com.start.pronto_recife.Controllers;


import com.start.pronto_recife.DTOs.DTOProfissionalSaude;
import com.start.pronto_recife.Service.ProfissionalSaudeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profissional-saude")
public class ProfissionalSaudeController {
    private final ProfissionalSaudeService profissionalSaudeService;

    @PostMapping
    public ResponseEntity<DTOProfissionalSaude> saveProfissionalSaude(@RequestBody @Valid DTOProfissionalSaude dtoProfissionalSaude) {
        return ResponseEntity.status(HttpStatus.CREATED).body(profissionalSaudeService.createProfissionalSaude(dtoProfissionalSaude));
    }
    @GetMapping
    public ResponseEntity<List<DTOProfissionalSaude>> getAllProfissionalSaude() {
        return ResponseEntity.status(HttpStatus.OK).body(profissionalSaudeService.findAll());
    }
    @GetMapping("/{coren}")
    public ResponseEntity<DTOProfissionalSaude> getProfissionalSaudeByCoren(@PathVariable String coren) {
        return ResponseEntity.status(HttpStatus.OK).body(profissionalSaudeService.findByCoren(coren));
    }
    @PutMapping("/update/{coren}")
    public ResponseEntity<DTOProfissionalSaude> updateProfissionalSaude(@PathVariable String coren, @RequestBody @Valid DTOProfissionalSaude dtoProfissionalSaude) {
        DTOProfissionalSaude updateProfissionalSaude = profissionalSaudeService.updateProfissionalSaude(coren, dtoProfissionalSaude);
        return ResponseEntity.status(HttpStatus.OK).body(updateProfissionalSaude);
    }
    @DeleteMapping("/delete/{coren}")
    public ResponseEntity<Void> deleteProfissionalSaude(@PathVariable String coren) {
        profissionalSaudeService.deleteProfissionalSaude(coren);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
