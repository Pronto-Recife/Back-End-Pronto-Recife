package com.start.pronto_recife.Service;

import com.start.pronto_recife.DTOs.DTOResponsavel;
import com.start.pronto_recife.DTOs.DTOResponsavelRequest;
import com.start.pronto_recife.Exceptions.CustomException;
import com.start.pronto_recife.Mapper.ResponsavelMapper;
import com.start.pronto_recife.Models.ResponsavelModel;
import com.start.pronto_recife.Repositories.PacienteRepository;
import com.start.pronto_recife.Repositories.ResponsavelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class  ResponsavelService {
    private final ResponsavelMapper responsavelMapper;
    private final ResponsavelRepository responsavelRepository;
    private final PacienteRepository pacienteRepository;


    public DTOResponsavel createResponsavel(DTOResponsavel dtoResponsavel) {
        try {
            ResponsavelModel responsavelModel = responsavelRepository.save(responsavelMapper.toModel(dtoResponsavel));
            return responsavelMapper.toDTO(responsavelModel);
        }catch (Exception e){
            throw new CustomException("Erro ao Salvar Responsável!", HttpStatus.BAD_REQUEST, null);
        }
    }

    public List<DTOResponsavel> findAll() {
        List<ResponsavelModel> responsavel = responsavelRepository.findAll();
        return responsavelMapper.listEntitytoListDTO(responsavel);
    }

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


        responsavelRepository.delete(responsavelExists);
    }
}