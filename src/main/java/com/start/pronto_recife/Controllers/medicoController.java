package com.start.pronto_recife.Controllers;

import com.start.pronto_recife.DTOs.DTOMedico;
import com.start.pronto_recife.Models.MedicoModel;
import com.start.pronto_recife.Repositories.MedicoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class medicoController {
private final MedicoRepository medicoRepository;

@PostMapping("/medico")
    public ResponseEntity<MedicoModel> saveMedico(@RequestBody @Valid DTOMedico dtoMedico){
    var medicoModel = new MedicoModel();
    BeanUtils.copyProperties(dtoMedico, medicoModel); //model mapper ou map struct
    return ResponseEntity.status(HttpStatus.CREATED).body(medicoRepository.save(medicoModel));
}

}
