package com.start.pronto_recife.Service;

import com.start.pronto_recife.DTOs.DTOMedico;
import com.start.pronto_recife.Mapper.MedicoMapper;
import com.start.pronto_recife.Models.MedicoModel;
import com.start.pronto_recife.Repositories.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

}
