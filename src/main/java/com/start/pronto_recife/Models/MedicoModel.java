package com.start.pronto_recife.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "medico")
@Getter @Setter
public class MedicoModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "CRM", unique = true)
    private String CRM;
    private String nome_completo;
    private String especialidade;
    private String telefone;
    private String email;
}
