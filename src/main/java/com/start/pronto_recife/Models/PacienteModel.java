package com.start.pronto_recife.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "paciente")
@Getter @Setter
public class PacienteModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private UUID id;
    @Column(name = "CPF")
    private String CPF;
    private String nome_completo;
    private LocalDate data_nascimento;
    private String genero;
    private String email;
    private String telefone;
    private String contato_representante;
    private String cep;
    private String endereco;
    private String responsavel_CPF;
}
