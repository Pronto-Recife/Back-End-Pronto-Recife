package com.start.pronto_recife.Controllers;

import com.start.pronto_recife.DTOs.DTOMedico;
import com.start.pronto_recife.Mapper.MedicoMapper;
import com.start.pronto_recife.Service.MedicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class MedicoController {
private final MedicoMapper medicoMapper;
private final MedicoService medicoService;




@PostMapping("/medico")
    public ResponseEntity<DTOMedico> saveMedico(@RequestBody @Valid DTOMedico dtoMedico){
    return ResponseEntity.status(HttpStatus.CREATED).body(medicoService.createMedico(dtoMedico));
}



}
