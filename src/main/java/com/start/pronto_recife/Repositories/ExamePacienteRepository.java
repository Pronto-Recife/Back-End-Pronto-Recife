package com.start.pronto_recife.Repositories;

import com.start.pronto_recife.Models.ExamePacientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ExamePacienteRepository extends JpaRepository<ExamePacientModel, UUID> {

}