package com.start.pronto_recife.Repositories;

import com.start.pronto_recife.Models.EstabelecimentoModel;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<EstabelecimentoModel, String> {
    Optional<EstabelecimentoModel> findByEmail(@NotBlank String email);
}
