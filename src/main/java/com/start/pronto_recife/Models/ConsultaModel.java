package com.start.pronto_recife.Models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name ="consulta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDate data_consulta;
    private String tratamentos_prescritos;
    private String instrucoes_recomendacoes;
    private String sintomas;
    private String historico_familiar;
//    private UUID paciente_id;
//    private UUID medico_id;



}
