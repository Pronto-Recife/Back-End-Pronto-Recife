package com.start.pronto_recife.Service;

import com.start.pronto_recife.DTOs.DTOAgenteSaude;
import com.start.pronto_recife.Mapper.AgenteSaudeMapper;
import com.start.pronto_recife.Models.AgenteSaudeModel;
import com.start.pronto_recife.Repositories.AgenteSaudeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgenteSaudeService {

    private final AgenteSaudeMapper agenteSaudeMapper;
    private final AgenteSaudeRepository agenteSaudeRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public DTOAgenteSaude createAgenteSaude(DTOAgenteSaude dtoAgenteSaude) {
        agenteSaudeRepository.findByCpf(dtoAgenteSaude.CPF()).ifPresent(AgenteSaudeModel -> {
            throw new RuntimeException("CPF já cadastrado");
        });
        String criptSenha = passwordEncoder.encode(dtoAgenteSaude.senha());
        AgenteSaudeModel agenteSaudeModel = agenteSaudeRepository.save(agenteSaudeMapper.toModel(dtoAgenteSaude));
        agenteSaudeModel.setSenha(criptSenha);
        return agenteSaudeMapper.toDTO(agenteSaudeModel);

    }

    public DTOAgenteSaude updateAgenteSaude(String CPF, DTOAgenteSaude dtoAgenteSaude) {
        AgenteSaudeModel target = agenteSaudeRepository.findByCpf(CPF).orElseThrow(() -> new RuntimeException("CPF não encontrado"));
        target.setCpf(dtoAgenteSaude.CPF());
        target.setSenha(dtoAgenteSaude.senha());
        target.setTelefone(dtoAgenteSaude.telefone());
        target.setEmail(dtoAgenteSaude.email());
        target.setNome(dtoAgenteSaude.nome());

        return agenteSaudeMapper.toDTO(agenteSaudeRepository.save(target));

    }
    public List<DTOAgenteSaude>findAll() {
        List<AgenteSaudeModel> agentesSaude = agenteSaudeRepository.findAll();
        return agenteSaudeMapper.listEntitytoDTO(agentesSaude);

    }

    public DTOAgenteSaude findByCpf(String cpf) {
        AgenteSaudeModel agenteSaudeExists = agenteSaudeRepository.findByCpf(cpf).orElseThrow(() ->
                new RuntimeException("CPF não existente"));
            return agenteSaudeMapper.toDTO(agenteSaudeExists);

    }
    public void deleteAgenteSaude(String cpf) {
        agenteSaudeRepository.findByCpf(cpf).orElseThrow(()-> new RuntimeException("CPF não existe"));
        agenteSaudeRepository.deleteByCpf(cpf);
    }
}