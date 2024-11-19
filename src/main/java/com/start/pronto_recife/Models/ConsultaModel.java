package com.start.pronto_recife.Models;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "data_consulta")
    private LocalDate data_consulta;
    private String tratamentos_prescritos;
    private String instrucoes_recomendacoes;
    private String sintomas;
    private String historico_familiar;

    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
