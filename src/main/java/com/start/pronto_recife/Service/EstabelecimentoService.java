package com.start.pronto_recife.Service;

import com.start.pronto_recife.DTOs.DTOEstabelecimento;
import com.start.pronto_recife.Mapper.EstabelecimentoMapper;
import com.start.pronto_recife.Models.EstabelecimentoModel;
import com.start.pronto_recife.Repositories.EstabelecimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstabelecimentoService {
    private final EstabelecimentoMapper estabelecimentoMapper;
    private final EstabelecimentoRepository estabelecimentoRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public DTOEstabelecimento createEstabelecimento(DTOEstabelecimento dtoEstabelecimento){
        if (estabelecimentoRepository.findByEmail(dtoEstabelecimento.email()).isPresent()) {
            throw new RuntimeException("Email Já Existe!");
        }
        String criptSenha = passwordEncoder.encode(dtoEstabelecimento.senha());
        EstabelecimentoModel newEstabelecimento = estabelecimentoMapper.toModel(dtoEstabelecimento);
        newEstabelecimento.setSenha(criptSenha);
        estabelecimentoRepository.save(newEstabelecimento);
        return estabelecimentoMapper.toDTO(newEstabelecimento);
    }
    public List<DTOEstabelecimento> findAll(){
        List<EstabelecimentoModel> estabelecimentos = estabelecimentoRepository.findAll();
        return estabelecimentoMapper.listEntitytoListDTO(estabelecimentos);
    }
    public DTOEstabelecimento findById(String id){
        EstabelecimentoModel estabelecimentoExists = estabelecimentoRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Estabelecimento não existe!"));
        return estabelecimentoMapper.toDTO(estabelecimentoExists);
    }
    public void deleteEstabelecimento(String id){
        EstabelecimentoModel estabelecimentoExists = estabelecimentoRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Estabelecimento não existe!"));
        estabelecimentoRepository.delete(estabelecimentoExists);
    }

}
