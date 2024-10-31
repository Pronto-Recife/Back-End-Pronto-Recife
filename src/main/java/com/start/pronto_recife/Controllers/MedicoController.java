package com.start.pronto_recife.Controllers;

import com.start.pronto_recife.DTOs.DTOMedico;
import com.start.pronto_recife.Mapper.MedicoMapper;
import com.start.pronto_recife.Models.MedicoModel;
import com.start.pronto_recife.Repositories.MedicoRepository;
import com.start.pronto_recife.Service.MedicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
public class MedicoController {
    private final MedicoMapper medicoMapper;
    private final MedicoService medicoService;
    private final MedicoRepository medicoRepository;

    @PostMapping("/medico")
    public ResponseEntity<DTOMedico> saveMedico(@RequestBody @Valid DTOMedico dtoMedico){
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoService.createMedico(dtoMedico));
    }

    @GetMapping("/medico")
    public ResponseEntity<List<MedicoModel>> getAllMedicos(){
        return ResponseEntity.status(HttpStatus.OK).body(medicoRepository.findAll());
    }

    @GetMapping("/medico/{id}")
    public ResponseEntity<Object> getOneMedico(@PathVariable(value = "id")String id){
        Optional<MedicoModel> medicoModel = medicoRepository.findById(UUID.fromString(id));
        if(medicoModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Medico nao encontrado. ");
        }
        return ResponseEntity.status(HttpStatus.OK).body(medicoModel.get());
    }

    @PutMapping("medico/{id}")
    public ResponseEntity<Object> updateMedico(@PathVariable(value = "id") UUID id, @RequestBody @Valid DTOMedico dtoMedico) {
        Optional<MedicoModel> medicoModel = medicoRepository.findById(id);
        if (medicoModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medico nao encontrado. ");
        }
        MedicoModel medicoModel1 = medicoModel.get();
        BeanUtils.copyProperties(dtoMedico, medicoModel1);
        return ResponseEntity.status(HttpStatus.OK).body(medicoRepository.save(medicoModel1));
    }

}