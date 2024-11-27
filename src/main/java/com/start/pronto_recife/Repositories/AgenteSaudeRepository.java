package com.start.pronto_recife.Repositories;

import com.start.pronto_recife.Models.AgenteSaudeModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgenteSaudeRepository extends JpaRepository<AgenteSaudeModel, String> {
    Optional<AgenteSaudeModel> findByCpf(String cpf);

    @Transactional
    void deleteByCpf(String cpf);
}




