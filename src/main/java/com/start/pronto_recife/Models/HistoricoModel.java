package com.start.pronto_recife.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.UUID;

@Entity
@Table(name = "historico_medico")
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
public class HistoricoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(Types.VARCHAR)
    private UUID id;
//    private String nomePaciente;
//    private String dataConsulta;
//    private String diagnostico;
//    private String medicamentosPrescritos;
//    private String observacoes;
    @Column(columnDefinition = "TEXT")
    private String cirurgias_anteriores;
    private String condicoes_gerais;
}