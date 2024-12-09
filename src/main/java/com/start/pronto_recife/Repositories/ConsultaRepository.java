package com.start.pronto_recife.Repositories;

import com.start.pronto_recife.Models.ConsultaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaModel, String> {
    List<ConsultaModel> findByPacienteIdAndDataConsultaBefore(String pacienteId, LocalDateTime dataAtual);
    List<ConsultaModel> findByPacienteIdAndDataConsultaAfter(String pacienteId, LocalDateTime dataAtual);
    List<ConsultaModel> findByMedicoIdAndDataConsultaBefore(String medicoId, LocalDateTime dataAtual);
    List<ConsultaModel> findByMedicoIdAndDataConsultaAfter(String medicoId, LocalDateTime dataAtual);

}
