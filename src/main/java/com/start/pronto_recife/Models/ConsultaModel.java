package com.start.pronto_recife.Models;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name ="consulta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaModel {

    @Id
    private String id;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "data_consulta")
    private LocalDateTime dataConsulta;
    @Column(name = "tratamentos_prescritos")
    private String tratamentosPrescritos;
    @Column(name = "instrucoes_recomendacoes")
    private String instrucoesRecomendacoes;
    @Column(name = "sintomas")
    private String sintomas;
    @Column(name = "historico_familiar")
    private String historicoFamiliar;
    @Column(name = "condicoes_gerais")
    private String condicoesGerais;
    @Column(name = "diagnostico")
    private String diagnostico;
    @Column(name = "paciente_id")
    private String pacienteId;
    @Column(name = "medico_id")
    private String medicoId;
    @Column(name = "laudos_id")
    private String laudoId;



    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
