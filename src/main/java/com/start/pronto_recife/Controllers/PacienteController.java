package com.start.pronto_recife.Controllers;

import com.start.pronto_recife.DTOs.DTOPaciente;
import com.start.pronto_recife.Mapper.PacienteMapper;
import com.start.pronto_recife.Models.PacienteModel;
import com.start.pronto_recife.Service.PacienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PacienteController {
    private final PacienteMapper pacienteMapper;
    private final PacienteService pacienteService;


    @PostMapping("/paciente")
    public ResponseEntity<DTOPaciente> savePaciente(@RequestBody DTOPaciente dtoPaciente){
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.createPaciente(dtoPaciente));
    }

    @GetMapping("/paciente")
    public ResponseEntity<List<DTOPaciente>> getAllPacients(Pageable page){
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.findAll());
    }

}
