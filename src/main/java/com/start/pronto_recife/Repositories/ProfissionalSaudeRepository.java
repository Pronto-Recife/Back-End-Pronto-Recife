package com.start.pronto_recife.Repositories;

import com.start.pronto_recife.Models.ProfissionalSaudeModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfissionalSaudeRepository extends JpaRepository<ProfissionalSaudeModel, String> {
    Optional<ProfissionalSaudeModel> findByCoren(String coren);

    @Transactional
    void deleteByCoren(String coren);
}
