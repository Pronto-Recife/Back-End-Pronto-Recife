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
    @Column(name = "coren")
    private String coren;
    private String nome;
    private String email;
    @Column (name = "senha")
    private String senha;
    private String telefone;
    @Column (name = "id_estabelecimento")
    private String idEstabelecimento;

    @PrePersist
    public void prePersist(){
        if (id == null)
            id = UUID.randomUUID().toString();

    }

}
