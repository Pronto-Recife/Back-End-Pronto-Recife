package com.start.pronto_recife.Controllers;

import com.start.pronto_recife.DTOs.DTOConsulta;
import com.start.pronto_recife.Models.ConsultaModel;
import com.start.pronto_recife.Service.ConsultaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("consulta")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    @PostMapping()
    public ResponseEntity<DTOConsulta> saveConsulta(@RequestBody @Valid DTOConsulta dtoconsulta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaService.createConsulta(dtoconsulta));
    }
    @GetMapping()
    public ResponseEntity<List<DTOConsulta>> getallConsultas() {
        return ResponseEntity.status(HttpStatus.OK).body(consultaService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DTOConsulta> getPaciente(@PathVariable String id) {
        DTOConsulta consulta = consultaService.getConsultaById(id);
        return ResponseEntity.ok().body(consulta);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DTOConsulta> updateConsulta(@PathVariable String id, @RequestBody @Valid DTOConsulta dtoconsulta) {
        DTOConsulta consulta = consultaService.updateConsultaByid(id, dtoconsulta);
        return ResponseEntity.status(HttpStatus.OK).body(consulta);
    }
    @PutMapping("updateData")
    public ResponseEntity<DTOConsulta> updateData(@PathVariable String id, @RequestBody @Valid DTOConsulta dtoconsulta) {
        DTOConsulta updatedData = consultaService.reagendarConsulta(id, dtoconsulta.dataConsulta());
        return ResponseEntity.status(HttpStatus.OK).body(updatedData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsultaById(@PathVariable String id) {
        consultaService.deleteConsulta(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping("/pacientes/{id}/consultas/realizadas")
    public ResponseEntity<List<DTOConsulta>> buscarConsultasRealizadas(@PathVariable String id) {
        List<DTOConsulta> consultas = consultaService.buscarConsultasRealizadas(id);
        return consultas.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(consultas);
    }

    @GetMapping("/pacientes/{id}/consultas/futuras")
    public ResponseEntity<List<DTOConsulta>> buscarConsultasFuturasMedico(@PathVariable String id) {
        List<DTOConsulta> consultas = consultaService.buscarConsultasFuturas(id);
        return consultas.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(consultas);
    }
    @GetMapping("/medico/{id}/consultas/realizadas")
    public ResponseEntity<List<DTOConsulta>> buscarConsultasRealizadasMedico(@PathVariable String id) {
        List<DTOConsulta> consultas = consultaService.buscarConsultasRealizadasMedico(id);
        return consultas.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(consultas);
    }

    @GetMapping("/medico/{id}/consultas/futuras")
    public ResponseEntity<List<DTOConsulta>> buscarConsultasFuturas(@PathVariable String id) {
        List<DTOConsulta> consultas = consultaService.buscarConsultasFuturasMedico(id);
        return consultas.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(consultas);
    }

}
