package com.start.pronto_recife.Service;

import com.start.pronto_recife.DTOs.DTOLaudo;
import com.start.pronto_recife.Exceptions.CustomException;
import com.start.pronto_recife.Mapper.LaudoMapper;
import com.start.pronto_recife.Models.LaudoModel;
import com.start.pronto_recife.Repositories.LaudoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LaudoService {
   private final LaudoMapper laudoMapper;
   private final LaudoRepository laudoRepository;
    // Service create new laudo
    public DTOLaudo createLaudo(DTOLaudo dtoLaudo){
        try {
            LaudoModel laudoModel = laudoRepository.save(laudoMapper.toModel(dtoLaudo));
            return laudoMapper.toDTO(laudoModel);
        }catch (Exception e){
            throw new CustomException("Erro ao cadastrar novo laudo!", HttpStatus.BAD_REQUEST, null);
        }
    }
    // Service findAll laudos
    public List<DTOLaudo> findAll(){
        List<LaudoModel> laudos = laudoRepository.findAll();
        return laudoMapper.listEntitytoListDTO(laudos);
    }
   // Service update laudo
    public DTOLaudo updateLaudo(String id, DTOLaudo dtoLaudo){
        LaudoModel existingLaudo = laudoRepository.findById(id)
                .orElseThrow(() -> new CustomException("Id do Laudo não encontrado!", HttpStatus.NOT_FOUND, null));

        LaudoModel updatedLaudo = laudoMapper.toModel(dtoLaudo);
        updatedLaudo.setId(existingLaudo.getId());
        laudoRepository.save(updatedLaudo);
        return laudoMapper.toDTO(updatedLaudo);
    }
}
