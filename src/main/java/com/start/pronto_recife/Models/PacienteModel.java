package com.start.pronto_recife.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "paciente")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PacienteModel{
    @Id
    private String id;
    @Column(name = "cpf", unique = true, length = 14)
    private String CPF;
    private String nome_completo;
    @Column(name = "data_nascimento")
    private LocalDate data_nascimento;
    private String genero;
    @Column(name = "email", unique = true)
    private String email;
    private String senha;
    private String telefone;
    private String contato_representante;
    private String cep;
    private String endereco;
    @Column(name = "responsavel_CPF", length = 14)
    private String responsavelCpf;

    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
