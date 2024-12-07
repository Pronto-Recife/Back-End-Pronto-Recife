package com.start.pronto_recife.Models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name ="consulta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaModel {

    @Id
    private String id;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "data_consulta")
    private LocalDate data_consulta;
    @Column(name = "tratamentos_prescritos")
    private String tratamentosPrescritos;
    @Column(name = "instrucoes_recomendacoes")
    private String instrucoesRecomendacoes;
    @Column(name = "sintomas")
    private String sintomas;
    @Column(name = "historico_familiar")
    private String historicoFamiliar;

    @ManyToOne
    @JoinColumn(name="paciente_id")
    @JsonBackReference
    private PacienteModel paciente;
    @ManyToOne
    @JoinColumn(name="medico_id")
    @JsonBackReference
    private MedicoModel medico;
    @OneToMany(mappedBy = "consulta")
//    @JsonBackReference
    @JsonManagedReference
    private List<ExamePacienteModel> exame;

    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
