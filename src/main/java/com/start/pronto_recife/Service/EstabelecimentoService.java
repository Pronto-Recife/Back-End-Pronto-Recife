package com.start.pronto_recife.Service;

import com.start.pronto_recife.DTOs.DTOEstabelecimento;
import com.start.pronto_recife.Mapper.EstabelecimentoMapper;
import com.start.pronto_recife.Models.EstabelecimentoModel;
import com.start.pronto_recife.Models.PacienteModel;
import com.start.pronto_recife.Repositories.EstabelecimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
    public List<DTOEstabelecimento> findAll(){
        List<EstabelecimentoModel> estabelecimentos = estabelecimentoRepository.findAll();
        return estabelecimentoMapper.listEntitytoListDTO(estabelecimentos);
    }
    public DTOEstabelecimento findById(UUID id){
        EstabelecimentoModel estabelecimentoExists = estabelecimentoRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Estabelecimento não existe!"));
        return estabelecimentoMapper.toDTO(estabelecimentoExists);
    }
    public void deleteEstabelecimento(UUID id){
        EstabelecimentoModel estabelecimentoExists = estabelecimentoRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Estabelecimento não existe!"));
        estabelecimentoRepository.delete(estabelecimentoExists);
    }
}