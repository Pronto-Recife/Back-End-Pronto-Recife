package com.start.pronto_recife.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "estabelecimento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstabelecimentoModel {
    @Id
    private String id;
    private String cnpj;
    private String nome;
    private String senha;
    private String endereco;
    private String telefone;
    @Column(name = "email", unique = true)
    private String email;
    private String idMedico;
    private String idConsulta;

    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
