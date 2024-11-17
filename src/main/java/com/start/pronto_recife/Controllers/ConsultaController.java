package com.start.pronto_recife.Controllers;

import com.start.pronto_recife.DTOs.DTOConsulta;
import com.start.pronto_recife.DTOs.DTOPaciente;
import com.start.pronto_recife.Service.ConsultaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;


    @PostMapping("/consulta")
    public ResponseEntity<DTOConsulta> saveConsulta(@RequestBody @Valid DTOConsulta dtoconsulta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaService.createConsulta(dtoconsulta));
    }

    @DeleteMapping("/consulta/{id}")
    public ResponseEntity<Void> deleteConsultaById(@PathVariable String id) {
        consultaService.deleteConsulta(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/consulta")
    public ResponseEntity<List<DTOConsulta>> getallConsultas() {
        return ResponseEntity.status(HttpStatus.OK).body(consultaService.findAll());

    }

    @GetMapping("/consulta/{id}")
    public ResponseEntity<DTOConsulta> getPaciente(@PathVariable String id) {
        DTOConsulta consulta = consultaService.getConsultaById(id);
        return ResponseEntity.ok().body(consulta);

    }
    @PutMapping("/consulta/{id}")
    public ResponseEntity<DTOConsulta> updateConsulta(@PathVariable String id, @RequestBody @Valid DTOConsulta dtoconsulta) {
        DTOConsulta consulta = consultaService.updateConsultaByid(id, dtoconsulta);
        return ResponseEntity.status(HttpStatus.OK).body(consulta);
    }


}
