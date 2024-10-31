package com.start.pronto_recife.Models;

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
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "cpf", unique = true, length = 14)
    private String CPF;
    private String nome_completo;
    private LocalDate data_nascimento;
    private String genero;
    private String email;
    private String telefone;
    private String contato_representante;
    private String cep;
    private String endereco;
    @Column(name = "responsavel_id", length = 16)
    private UUID responsavel_id;
}
