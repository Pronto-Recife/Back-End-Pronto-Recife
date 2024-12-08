package com.start.pronto_recife.Repositories;

import com.start.pronto_recife.Models.LaudoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LaudoRepository extends JpaRepository <LaudoModel, String> {
    Optional<LaudoModel> findById(String id);
}
