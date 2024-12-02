package com.start.pronto_recife.Controllers;

import com.start.pronto_recife.DTOs.DTOAgenteSaude;
import com.start.pronto_recife.Service.AgenteSaudeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agente-saude")
public class AgenteSaudeController {

    private final AgenteSaudeService agenteSaudeService;

    @PostMapping
    public ResponseEntity<DTOAgenteSaude> saveAgenteSaude(@RequestBody @Valid DTOAgenteSaude dtoAgenteSaude) {
        return ResponseEntity.status(HttpStatus.CREATED).body(agenteSaudeService.createAgenteSaude(dtoAgenteSaude));
    }

    @GetMapping
    public ResponseEntity<List<DTOAgenteSaude>> getAllAgentesSaude() {
        return ResponseEntity.status(HttpStatus.OK).body(agenteSaudeService.findAll());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<DTOAgenteSaude> getAgenteSaudeByCpf(@PathVariable String cpf) {
        return ResponseEntity.status(HttpStatus.OK).body(agenteSaudeService.findByCpf(cpf));
    }

    @PutMapping("/update/{cpf}")
    public ResponseEntity<DTOAgenteSaude> updateAgenteSaude(@PathVariable String cpf, @RequestBody @Valid DTOAgenteSaude dtoAgenteSaude) {
        DTOAgenteSaude updateAgenteSaude = agenteSaudeService.updateAgenteSaude(cpf, dtoAgenteSaude);
        return ResponseEntity.status(HttpStatus.OK).body(updateAgenteSaude);
    }

    @DeleteMapping("/delete/{cpf}")
    public ResponseEntity<Void> deleteAgenteSaudeByCpf(@PathVariable String cpf) {
        agenteSaudeService.deleteAgenteSaude(cpf);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
