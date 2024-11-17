package com.start.pronto_recife.Models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
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
    private LocalDate data_consulta;
    private String tratamentos_prescritos;
    private String instrucoes_recomendacoes;
    private String sintomas;
    private String historico_familiar;
    private String paciente_id;
    private String medico_id;
    private String laudos_id;

    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}