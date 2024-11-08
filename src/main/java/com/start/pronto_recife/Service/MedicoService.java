package com.start.pronto_recife.Service;

import com.start.pronto_recife.DTOs.DTOMedico;
import com.start.pronto_recife.DTOs.DTOPaciente;
import com.start.pronto_recife.Mapper.MedicoMapper;
import com.start.pronto_recife.Models.MedicoModel;
import com.start.pronto_recife.Models.PacienteModel;
import com.start.pronto_recife.Repositories.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoService {
    private final MedicoMapper medicoMapper;
    private final MedicoRepository medicoRepository;

    public DTOMedico createMedico(DTOMedico dtoMedico){
        medicoRepository.findByCRM(dtoMedico.CRM()).ifPresent(medicoModel -> {
            throw new RuntimeException("CRM já cadastrado");
        });
        MedicoModel medicoModel = medicoRepository.save(medicoMapper.toModel(dtoMedico));
        return medicoMapper.toDTO(medicoModel);
    }

    public List<DTOMedico> findAll(){
        List<MedicoModel> medicos = medicoRepository.findAll();
        return medicoMapper.listEntitytoListDTO(medicos);
    }

    public DTOMedico findByCRM(String CRM){
        MedicoModel medicoExists = medicoRepository.findByCRM(CRM).orElseThrow(() ->
                new RuntimeException("CRM Não Existe!!"));
        return medicoMapper.toDTO(medicoExists);
    }

}
