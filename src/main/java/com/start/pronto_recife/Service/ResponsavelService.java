package com.start.pronto_recife.Service;

import com.start.pronto_recife.DTOs.DTOResponsavel;
import com.start.pronto_recife.Exceptions.CustomException;
import com.start.pronto_recife.Mapper.ResponsavelMapper;
import com.start.pronto_recife.Models.PacienteModel;
import com.start.pronto_recife.Models.ResponsavelModel;
import com.start.pronto_recife.Repositories.PacienteRepository;
import com.start.pronto_recife.Repositories.ResponsavelRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.http.HttpStatus;
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
    private final PacienteRepository pacienteRepository;

    // Service create new responsavel
    public DTOResponsavel createResponsavel(DTOResponsavel dtoResponsavel) {
        try {
            ResponsavelModel responsavelModel = responsavelRepository.save(responsavelMapper.toModel(dtoResponsavel));
            return responsavelMapper.toDTO(responsavelModel);
        }catch (Exception e){
            throw new CustomException("Erro ao Salvar Responsável!", HttpStatus.BAD_REQUEST, null);
        }
    }
    // Service findAll responsavel
    public List<DTOResponsavel> findAll() {
        List<ResponsavelModel> responsavel = responsavelRepository.findAll();
        return responsavelMapper.listEntitytoListDTO(responsavel);
    }
    // Service update responsavel
    public DTOResponsavel updateResponsavel(String id, DTOResponsavel dtoResponsavel) {
        ResponsavelModel existingResponsavel = responsavelRepository.findById(id)
                .orElseThrow(() -> new CustomException("Responsavel não encontrado!", HttpStatus.NOT_FOUND, null));

        ResponsavelModel updatedResponsavel = responsavelMapper.toModel(dtoResponsavel);
        updatedResponsavel.setId(existingResponsavel.getId());
        responsavelRepository.save(updatedResponsavel);
        return responsavelMapper.toDTO(updatedResponsavel);
    }
    public void deleteResponsavel(String id) {
        ResponsavelModel responsavelExists = responsavelRepository.findById(id).orElseThrow(() ->
                new CustomException("Responsável não encontrado!", HttpStatus.NOT_FOUND, null));
        List<PacienteModel> paciente = pacienteRepository.findByResponsavelCpf(responsavelExists.getCpf());
        List<PacienteModel> pacienteUpdate = paciente.stream()
                .peek(p -> p.setResponsavel_CPF(null)).toList();
        pacienteRepository.saveAll(pacienteUpdate);
        responsavelRepository.delete(responsavelExists);
    }
}