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
    private String nomeCompleto;
    private String telefone;
    private String email;
    private String especialidade;
    @Column(name = "senha")
    private String senha;
    @Column(name = "id_estabelecimento", unique = true)
    private String idEstabelecimento;


    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}