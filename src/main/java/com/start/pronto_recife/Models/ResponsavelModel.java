package com.start.pronto_recife.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;


@Entity
@Table(name = "responsavel")
@Getter @Setter
public class ResponsavelModel {
    @Id
    private String id;
    @Column(name = "nome_completo")
    private String nomeCompleto;
    @Column(name = "grau_parentesco")
    private String grauParentesco;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
    private String genero;
    @Column(name = "cpf", unique = true, length = 14, nullable = false)
    private String cpf;


    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
