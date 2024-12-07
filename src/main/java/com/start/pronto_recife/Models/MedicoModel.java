package com.start.pronto_recife.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "medico")
@Getter @Setter
public class MedicoModel{

    @Id
    private String id;
    @Column(name = "CRM", unique = true)
    private String CRM;
    @Column(name = "nome_completo")
    private String nomeCompleto;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "email")
    private String email;
    @Column(name = "senha")
    private String senha;


    @OneToMany(mappedBy = "medico")
//    @JsonBackReference
    @JsonManagedReference
    private List<ConsultaModel> consulta;

    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}