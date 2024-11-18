package com.start.pronto_recife.Repositories;

import com.start.pronto_recife.Models.LaudoModel;
import com.start.pronto_recife.Models.PacienteModel;
import com.start.pronto_recife.Models.ResponsavelModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ResponsavelRepository extends JpaRepository<ResponsavelModel, String> {
    Optional<ResponsavelModel> findByCpf(@NotBlank @Pattern(regexp = "\\d{11}") String cpf);

}
