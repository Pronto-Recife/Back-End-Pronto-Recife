package com.start.pronto_recife.Repositories;

import com.start.pronto_recife.Models.LaudoModel;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LaudoRepository extends JpaRepository <LaudoModel, UUID> {
    Optional<LaudoModel> findById(UUID id);
}
