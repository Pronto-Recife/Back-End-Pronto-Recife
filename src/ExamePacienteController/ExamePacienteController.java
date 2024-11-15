package com.start.pronto_recife.ExamePacienteController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.start.pronto_recife.ExamePacienteDTO.ExameDTO;
import com.start.pronto_recife.ExamePacienteService.ExameService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/exames")
public class ExamePacienteController {

    private final ExameService<?> exameService;

    ExamePacienteController(ExamePacienteService<?> exameService) {
        this.exameService = exameService;
    }

    @PostMapping
    public ResponseEntity<ExamePacienteDTO> createExame(@RequestBody ExameDTO dto) {
        ExameDTO createdExame = exameService.createExame(dto);
        return new ResponseEntity<>(createdExame, HttpStatus.CREATED);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<ExameDTO> getExameById(@PathVariable UUID id) {
        ExameDTO exame = exameService.getExameById(id);
        if (exame == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(exame, HttpStatus.OK);
    }

    
    @GetMapping
    public ResponseEntity<List<ExamePacienteDTO>> getAllExames() {
        List<ExameDTO> exames = exameService.getAllExames();
        return new ResponseEntity<>(exames, HttpStatus.OK);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<ExameDTO> updateExame(@PathVariable UUID id, @RequestBody ExameDTO dto) {
        ExameDTO updatedExame = exameService.updateExame(id, dto);
        if (updatedExame == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedExame, HttpStatus.OK);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExame(@PathVariable UUID id) {
        boolean isDeleted = exameService.deleteExame(id);
        if (!isDeleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}