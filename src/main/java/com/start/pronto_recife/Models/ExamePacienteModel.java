package com.start.pronto_recife.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.time.LocalDate;
import java.util.UUID;
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
    private LocalDate dataExame;
    @Column(name = "resultado", nullable = false)
    private String resultado;
    @Column(name = "nome_do_exame", nullable = false, length = 100)
    private String nomeDoExame;
    @Column(name = "paciente_cpf", nullable = false)
    private String pacienteCPF;
    @Column(name = "consulta_id")
    private String consultaId;
}