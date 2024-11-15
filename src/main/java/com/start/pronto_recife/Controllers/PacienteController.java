package com.start.pronto_recife.Controllers;

import com.start.pronto_recife.DTOs.DTOPaciente;
import com.start.pronto_recife.Service.PacienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController("paciente")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @PostMapping("/register")
    public ResponseEntity<DTOPaciente> savePaciente(@RequestBody DTOPaciente dtoPaciente){
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.createPaciente(dtoPaciente));
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String cpf, @RequestParam String senha){
        try {
            String mensagem = pacienteService.loginPaciente(cpf, senha);
            return ResponseEntity.ok(mensagem);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login Falhou: " + e.getMessage());
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<DTOPaciente>> getAllPacients(){
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.findAll());
    }
    @GetMapping("/find/{CPF}")
    public ResponseEntity<DTOPaciente> getPaciente(@PathVariable(value="CPF") String CPF){
        DTOPaciente paciente = pacienteService.findByCPF(CPF);
        return ResponseEntity.ok().body(paciente);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<DTOPaciente> updatePaciente(@PathVariable UUID id, @RequestBody @Valid DTOPaciente dtoPaciente) {
        DTOPaciente paciente = pacienteService.updatePaciente(id, dtoPaciente);
        return ResponseEntity.status(HttpStatus.OK).body(paciente);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable UUID id){
        pacienteService.deletePaciente(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
