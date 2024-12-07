package com.start.pronto_recife.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "responsavel")
@Getter @Setter
public class ResponsavelModel {
    @Id
    private String id;
    @Column(name = "nome_completo")
    private String nomeCompleto;
    @Column(name = "cpf")
    private String responsavelCpf;
    @Column(name = "grau_parentesco")
    private String grauParentesco;
    private String endereco;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
    @OneToMany(mappedBy = "responsavel")
//    @JsonBackReference
    @JsonManagedReference
    private List<PacienteModel> paciente;


    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
