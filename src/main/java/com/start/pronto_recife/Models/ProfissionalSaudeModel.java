package com.start.pronto_recife.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "profissional_saude")
public class ProfissionalSaudeModel {
    @Id
    private String id;
    @Column(name = "coren", unique = true)
    private String coren;
    private String nome;
    private String email;
    private String telefone;
    @Column (name = "senha")
    private String senha;

    @PrePersist
    public void prePersist(){
        if (id == null)
            id = UUID.randomUUID().toString();

    }

}
