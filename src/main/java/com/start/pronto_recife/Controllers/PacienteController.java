package com.start.pronto_recife.Controllers;

import com.start.pronto_recife.DTOs.DTOPaciente;
import com.start.pronto_recife.Mapper.PacienteMapper;
import com.start.pronto_recife.Repositories.PacienteRepository;
import com.start.pronto_recife.Service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PacienteController {
    private final PacienteMapper pacienteMapper;
    private final PacienteService pacienteService;
    private final PacienteRepository pacienteRepository;


    @PostMapping("/paciente")
    public ResponseEntity<DTOPaciente> savePaciente(@RequestBody DTOPaciente dtoPaciente){
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.createPaciente(dtoPaciente));
    }

    @GetMapping("/paciente")
    public ResponseEntity<List<DTOPaciente>> getAllPacients(){
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.findAll());
    }

    @GetMapping("/paciente/{CPF}")
    public ResponseEntity<DTOPaciente> getPaciente(@PathVariable(value="CPF") String CPF){
        DTOPaciente paciente = pacienteService.findByCPF(CPF);
        return ResponseEntity.ok().body(paciente);
    }

}
