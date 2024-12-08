package com.start.pronto_recife.Repositories;

import com.start.pronto_recife.Models.PacienteModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteModel, String> {
    Optional<PacienteModel> findByCPF(@NotBlank @Pattern(regexp = "\\d{11}") String CPF);
    List<PacienteModel> findByResponsavelCpf(String CPF);
    Optional<PacienteModel> findByEmail(String Email);
//    @Query(value = "select * from paciente join responsavel on paciente.responsavel_id = responsavel_id",
//              nativeQuery = true )
//    List<PacienteModel> findALL();

}
