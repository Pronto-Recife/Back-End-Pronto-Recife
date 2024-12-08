package com.start.pronto_recife.Models;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "vacinas")
@Getter
@Setter
public class Vacinas {
    @Id
    private String id;
    @Column(name = "paciente_id")
    private String pacienteId;
    @Column(name = "nome_vacina")
    private String nomeVacina;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "data_aplicacao")
    private LocalDate dataAplicacao;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "proxima_dose")
    private LocalDate proximaDose;






    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
