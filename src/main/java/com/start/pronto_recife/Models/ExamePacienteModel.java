package com.start.pronto_recife.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.time.LocalDate;

@Entity
@Table(name = "exame_do_paciente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExamePacienteModel {
    @Id
    @GeneratedValue(strategy =GenerationType.UUID)
    @JdbcTypeCode(Types.VARCHAR)
    private String id;
    @Column(name = "data_exame")
    private LocalDate dataExame;
    @Column(name = "resultado", nullable = false)
    private String resultado;
    @Column(name = "nome_do_exame", nullable = false, length = 100)
    private String nomeDoExame;
    @Column(name = "paciente_id", nullable = false)
    private String pacienteId;
    @Column(name = "consulta_id")
    private String consultaId;
}