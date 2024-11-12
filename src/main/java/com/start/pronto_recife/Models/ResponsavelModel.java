package com.start.pronto_recife.Models;

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
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idResponsavel;
    private String nome_Completo;
    private String grau_Parentesco;
    private LocalDate data_nascimento;
    private String telefone;
    private String email;
    private String genero;
}
