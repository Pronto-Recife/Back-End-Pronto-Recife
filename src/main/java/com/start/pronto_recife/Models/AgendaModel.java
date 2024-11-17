package com.start.pronto_recife.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.UUID;

@Entity
@Table(name = "agenda")
@Getter
@Setter
public class AgendaModel {
    @Id
    private String id;
    private LocalDate data;
    private LocalTime time;
    //private MedicoModel medicoModel;
    //private ArrayList<PacienteModel> pacienteModels;
    private String status;
    private String observacoes;

    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
