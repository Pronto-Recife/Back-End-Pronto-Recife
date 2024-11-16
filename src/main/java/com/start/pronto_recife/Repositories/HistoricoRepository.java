package com.start.pronto_recife.Repositories;

import com.start.pronto_recife.Models.HistoricoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface HistoricoRepository extends JpaRepository<HistoricoModel, UUID>  {
   }