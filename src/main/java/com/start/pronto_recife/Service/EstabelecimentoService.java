package com.start.pronto_recife.Service;

import com.start.pronto_recife.DTOs.DTOEstabelecimento;
import com.start.pronto_recife.Mapper.EstabelecimentoMapper;
import com.start.pronto_recife.Models.EstabelecimentoModel;
import com.start.pronto_recife.Repositories.EstabelecimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstabelecimentoService {
    private final EstabelecimentoMapper estabelecimentoMapper;
    private final EstabelecimentoRepository estabelecimentoRepository;

    public DTOEstabelecimento createEstabelecimento(DTOEstabelecimento dtoEstabelecimento){
        if (estabelecimentoRepository.findByEmail(dtoEstabelecimento.email()).isPresent()) {
            throw new RuntimeException("Email Já Existe!");
        }
        EstabelecimentoModel newEstabelecimento = estabelecimentoMapper.toModel(dtoEstabelecimento);
        estabelecimentoRepository.save(newEstabelecimento);
        return estabelecimentoMapper.toDTO(newEstabelecimento);
    }
}
