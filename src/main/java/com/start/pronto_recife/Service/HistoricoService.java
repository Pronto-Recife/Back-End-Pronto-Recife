package com.start.pronto_recife.Service;

import ch.qos.logback.classic.spi.IThrowableProxy;
import com.start.pronto_recife.DTOs.DTOHistorico;
import com.start.pronto_recife.Mapper.HistoricoMapper;
import com.start.pronto_recife.Models.HistoricoModel;
import com.start.pronto_recife.Repositories.HistoricoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoricoService {
    private final HistoricoMapper historicoMapper;
    private final HistoricoRepository historicoRepository;

    public List<DTOHistorico> findAll(){
        List<HistoricoModel> listHistorico = historicoRepository.findAll();
        return historicoMapper.toListDto(listHistorico);
    }
    public DTOHistorico createHistorico(DTOHistorico dtoHistorico){
        historicoRepository.findById(dtoHistorico.id()).ifPresent(historicoModel -> {
            throw new RuntimeException("Historico ja existe");
        });
        HistoricoModel historico = historicoMapper.toModel(dtoHistorico);
        HistoricoModel createdHistorico = historicoRepository.save(historico);
        return historicoMapper.toDTO(createdHistorico);
    }
}