package com.start.pronto_recife.Service;


import com.start.pronto_recife.DTOs.DTOProfissionalSaude;
import com.start.pronto_recife.Mapper.ProfissionalSaudeMapper;
import com.start.pronto_recife.Models.ProfissionalSaudeModel;
import com.start.pronto_recife.Repositories.ProfissionalSaudeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfissionalSaudeService {
    private final ProfissionalSaudeRepository profissionalSaudeRepository;
    private final ProfissionalSaudeMapper profissionalSaudeMapper;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public DTOProfissionalSaude createProfissionalSaude(DTOProfissionalSaude dtoProfissionalSaude) {
        profissionalSaudeRepository.findByCoren(dtoProfissionalSaude.coren()).ifPresent(AgenteSaudeModel -> {
            throw new RuntimeException("COREN já cadastrado");
        });
        String criptSenha = passwordEncoder.encode(dtoProfissionalSaude.senha());
        ProfissionalSaudeModel profissionalSaudeModel = profissionalSaudeRepository.save(profissionalSaudeMapper.toModel(dtoProfissionalSaude));
        profissionalSaudeModel.setSenha(criptSenha);
        return profissionalSaudeMapper.toDTO(profissionalSaudeModel);

        }
        public DTOProfissionalSaude updateProfissionalSaude(String COREN, DTOProfissionalSaude dtoProfissionalSaude) {
        ProfissionalSaudeModel target = profissionalSaudeRepository.findByCoren(COREN).orElseThrow(()->
                new RuntimeException("COREN não encontrado"));
        target.setCoren(dtoProfissionalSaude.coren());
        target.setSenha(dtoProfissionalSaude.senha());
        target.setEmail(dtoProfissionalSaude.email());
        target.setNome(dtoProfissionalSaude.nome());
        target.setTelefone(dtoProfissionalSaude.telefone());

        return profissionalSaudeMapper.toDTO(profissionalSaudeRepository.save(target));
    }
    public List<DTOProfissionalSaude> findAll() {
        List<ProfissionalSaudeModel> profissionaisSaude = profissionalSaudeRepository.findAll();

        return profissionalSaudeMapper.listEntitytoDTO(profissionaisSaude);
    }
    public DTOProfissionalSaude findByCoren(String coren) {
        ProfissionalSaudeModel profssionalSaudeExists = profissionalSaudeRepository.findByCoren(coren).orElseThrow(()->
                new RuntimeException("COREN não existente"));
        return profissionalSaudeMapper.toDTO(profssionalSaudeExists);
    }
    public void deleteProfissionalSaude(String coren) {
        profissionalSaudeRepository.findByCoren(coren).orElseThrow(()->
                new RuntimeException( "COREN não existe!"));
        profissionalSaudeRepository.deleteByCoren(coren);
    }
}
