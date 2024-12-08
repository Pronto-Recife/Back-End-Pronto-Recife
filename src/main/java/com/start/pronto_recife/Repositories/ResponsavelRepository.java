package com.start.pronto_recife.Repositories;

import com.start.pronto_recife.Models.ResponsavelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResponsavelRepository extends JpaRepository<ResponsavelModel, String> {

}
