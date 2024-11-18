package com.start.pronto_recife.Controllers;

import com.start.pronto_recife.DTOs.DTOMedico;
import com.start.pronto_recife.DTOs.DTOPaciente;
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
@RequestMapping("/medico")
public class MedicoController {
    private final MedicoMapper medicoMapper;
    private final MedicoService medicoService;
    private final MedicoRepository medicoRepository;

    @PostMapping()
    public ResponseEntity<DTOMedico> saveMedico(@RequestBody DTOMedico dtoMedico){
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

    @PutMapping("{CRM}")
    public ResponseEntity<DTOMedico> updateMedico(@PathVariable String CRM, @RequestBody @Valid DTOMedico dtoMedico) {
        DTOMedico medico = medicoService.updateMedico(CRM, dtoMedico);
        return ResponseEntity.status(HttpStatus.OK).body(medico);
    }

//    @PutMapping("medico/{id}")
//    public ResponseEntity<Object> updateMedico(@PathVariable(value = "id") UUID id, @RequestBody @Valid DTOMedico dtoMedico) {
//        Optional<MedicoModel> medicoModel = medicoRepository.findById(id);
//        if (medicoModel.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medico nao encontrado. ");
//        }
//        MedicoModel medicoModel1 = medicoModel.get();
//        BeanUtils.copyProperties(dtoMedico, medicoModel1);
//        return ResponseEntity.status(HttpStatus.OK).body(medicoRepository.save(medicoModel1));
//    }

}

//