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
    @Column(name = "crm", unique = true)
    private String CRM;
    @Column(name = "email")
    private String email;
    @Column(name = "senha")
    private String senha;
    @Column(name = "nome_completo")
    private String nomeCompleto;
    private String telefone;




    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}