package com.start.pronto_recife.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Entity
@Table(name = "medico")
@Getter @Setter
public class MedicoModel{

    @Id
    private String id;
    @Column(name = "CRM", unique = true)
    private String CRM;
    private String nome_completo;
    private String especialidade;
    private String telefone;
    private String email;

    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}

