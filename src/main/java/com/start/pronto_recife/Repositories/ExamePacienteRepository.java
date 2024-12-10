package com.start.pronto_recife.Repositories;

import com.start.pronto_recife.Models.ExamePacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamePacienteRepository extends JpaRepository<ExamePacienteModel, String> {
    List<ExamePacienteModel> findByPacienteId(String pacienteId);

}