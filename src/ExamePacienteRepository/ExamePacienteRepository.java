package com.start.pronto_recife.ExamePacienteRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ExamePacienteRepository extends JpaRepository<ExamePacienteRepository, UUID> {

	<Exame> Exame save(Exame model);
	
}