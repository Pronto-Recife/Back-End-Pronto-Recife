package com.start.pronto_recife.Repositories;

import com.start.pronto_recife.Models.ConsultaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaModel, String> {
    boolean isHorarioDisponivel(LocalDate novaDataConsulta);
}
