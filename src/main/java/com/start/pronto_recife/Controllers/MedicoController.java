package com.start.pronto_recife.Controllers;

import com.start.pronto_recife.DTOs.DTOMedico;
import com.start.pronto_recife.DTOs.DTOPaciente;
import com.start.pronto_recife.Service.MedicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/medico")
public class MedicoController {
    private final MedicoService medicoService;

    @PostMapping("/register")
    public ResponseEntity<DTOMedico> saveMedico(@RequestBody @Valid DTOMedico dtoMedico){
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoService.createMedico(dtoMedico));
    }
    @GetMapping()
    public ResponseEntity<List<DTOMedico>> getAllMedicos(){
        return ResponseEntity.status(HttpStatus.OK).body(medicoService.findAll());
    }
    @GetMapping("/{CRM}")
    public ResponseEntity<DTOMedico> getMedico(@PathVariable(value="CRM") String CRM){
        DTOMedico medico = medicoService.findByCRM(CRM);
        return ResponseEntity.ok().body(medico);
    }
    @GetMapping("/find/id/{id}")
    public ResponseEntity<DTOMedico> getMedicoById(@PathVariable(value = "id") String id){
        DTOMedico medico = medicoService.findById(id);
        return ResponseEntity.ok().body(medico);
    }
    @PutMapping("{CRM}")
    public ResponseEntity<DTOMedico> updateMedico(@PathVariable String CRM, @RequestBody @Valid DTOMedico dtoMedico) {
        DTOMedico medico = medicoService.updateMedico(CRM, dtoMedico);
        return ResponseEntity.status(HttpStatus.OK).body(medico);
    }
    @DeleteMapping("/delete/{CRM}")
    public ResponseEntity<Void> deleteMedicoById(@PathVariable String CRM) {
        medicoService.deleteMedico(CRM);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
