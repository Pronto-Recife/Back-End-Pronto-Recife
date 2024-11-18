package com.start.pronto_recife.Service;

import com.start.pronto_recife.DTOs.DTOResponsavel;
import com.start.pronto_recife.Mapper.ResponsavelMapper;
import com.start.pronto_recife.Models.PacienteModel;
import com.start.pronto_recife.Models.ResponsavelModel;
import com.start.pronto_recife.Repositories.ResponsavelRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class  ResponsavelService {
    private final ResponsavelMapper responsavelMapper;
    private final ResponsavelRepository responsavelRepository;

    // Service findAll responsavel
    public List<DTOResponsavel> findAll() {
        List<ResponsavelModel> responsavel = responsavelRepository.findAll();
        return responsavelMapper.listEntitytoListDTO(responsavel);
    }

    // Service update responsavel
    public DTOResponsavel updateResponsavel(String id, DTOResponsavel dtoResponsavel) {
        ResponsavelModel existingResponsavel = responsavelRepository.findById(id).orElseThrow(() -> new RuntimeException("Id do responsável não encontrado."));

        ResponsavelModel updatedResponsavel = responsavelMapper.toModel(dtoResponsavel);
        updatedResponsavel.setId(existingResponsavel.getId());
        responsavelRepository.save(updatedResponsavel);
        return responsavelMapper.toDTO(updatedResponsavel);
    }

    // Service create new responsavel
    
    public DTOResponsavel createResponsavel(DTOResponsavel dtoResponsavel) {
        if (responsavelRepository.findByCpf(dtoResponsavel.cpf()).isPresent()) {
            throw new RuntimeException("CPF Já Existe!");
        }
        ResponsavelModel newResponsavel = responsavelMapper.toModel(dtoResponsavel);
        responsavelRepository.save(newResponsavel);
        return responsavelMapper.toDTO(newResponsavel);
    }

    public void deleteResponsavel(String id) {
        ResponsavelModel responsavelExists = responsavelRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuario não existe!"));
        responsavelRepository.delete(responsavelExists);
    }
}