package com.start.pronto_recife.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "historico_medico")
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
public class HistoricoModel {

    @Id
    private String id;
    @Column(name = "cirurgias_anteriores",columnDefinition = "TEXT")
    private String cirurgias_anteriores;
    @Column(name = "paciente_id")
    private String pacienteId;



    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}