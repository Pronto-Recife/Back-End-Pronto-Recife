package com.start.pronto_recife.Service;

import com.start.pronto_recife.DTOs.DTOLaudo;
import com.start.pronto_recife.Mapper.LaudoMapper;
import com.start.pronto_recife.Models.LaudoModel;
import com.start.pronto_recife.Repositories.LaudoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LaudoService {
   private final LaudoMapper laudoMapper;
   private final LaudoRepository laudoRepository;
    // Service findAll laudos
    public List<DTOLaudo> findAll(){
        List<LaudoModel> laudos = laudoRepository.findAll();
        return laudoMapper.listEntitytoListDTO(laudos);
    }
   // Service update laudo
    public DTOLaudo updateLaudo(String id, DTOLaudo dtoLaudo){
        LaudoModel existingLaudo = laudoRepository.findById(id).orElseThrow(() -> new RuntimeException("Id do Laudo não encontrado."));

        LaudoModel updatedLaudo = laudoMapper.toModel(dtoLaudo);
        updatedLaudo.setId(existingLaudo.getId());
        laudoRepository.save(updatedLaudo);
        return laudoMapper.toDTO(updatedLaudo);
    }
    // Service create new laudo
    public DTOLaudo createLaudo(DTOLaudo dtoLaudo){
        LaudoModel laudoModel = laudoRepository.save(laudoMapper.toModel(dtoLaudo));
        return laudoMapper.toDTO(laudoModel);
    }
}
