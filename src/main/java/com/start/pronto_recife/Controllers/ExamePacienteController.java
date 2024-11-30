package com.start.pronto_recife.Controllers;

import com.start.pronto_recife.DTOs.ExamePacienteDTO;
import com.start.pronto_recife.Service.ExamePacienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController ("exame")
@RequiredArgsConstructor
public class ExamePacienteController {
    private final ExamePacienteService examePacienteService;

    @PostMapping()
    public ResponseEntity<ExamePacienteDTO> saveExamePaciente(@RequestBody @Valid ExamePacienteDTO examePacienteDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(examePacienteService.createExame(examePacienteDTO));
    }
    @GetMapping()
    public ResponseEntity<List<ExamePacienteDTO>> getallExames() {
        return ResponseEntity.status(HttpStatus.OK).body(examePacienteService.getAllExames());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ExamePacienteDTO> getExamesByID(@PathVariable String id) {
        ExamePacienteDTO consulta = examePacienteService.getExameById(id);
        return ResponseEntity.ok().body(consulta);
    }
    @PutMapping("/exame/{id}")
    public ResponseEntity<ExamePacienteDTO> updateExame(@PathVariable String id, @RequestBody @Valid ExamePacienteDTO examePacienteDTO) {
        ExamePacienteDTO consulta = examePacienteService.updateExame(id, examePacienteDTO);
        return ResponseEntity.status(HttpStatus.OK).body(consulta);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExamePaciente(@PathVariable String id) {
        examePacienteService.deleteExame(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
