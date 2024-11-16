package com.start.pronto_recife.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.time.LocalDate;
import java.util.UUID;


@Entity
@Table(name = "responsavel")
@Getter @Setter
public class ResponsavelModel {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    @JdbcTypeCode(Types.VARCHAR)
    private UUID id;
    private String nomeCompleto;
    private String grauParentesco;
    @Column(name = "dataNascimento")
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
    private String genero;
}
