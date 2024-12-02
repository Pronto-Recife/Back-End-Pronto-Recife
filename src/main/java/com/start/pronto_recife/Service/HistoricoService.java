package com.start.pronto_recife.Service;

import com.start.pronto_recife.DTOs.DTOHistorico;
import com.start.pronto_recife.Exceptions.CustomException;
import com.start.pronto_recife.Mapper.HistoricoMapper;
import com.start.pronto_recife.Models.HistoricoModel;
import com.start.pronto_recife.Repositories.HistoricoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
        try {
            HistoricoModel historico = historicoMapper.toModel(dtoHistorico);
            HistoricoModel createdHistorico = historicoRepository.save(historico);
            return historicoMapper.toDTO(createdHistorico);
        }catch (Exception e){
            throw new CustomException("Erro ao registrar o Historico!", HttpStatus.BAD_REQUEST, null);
        }
    }
}