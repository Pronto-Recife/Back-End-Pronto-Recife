package com.start.pronto_recife.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "paciente")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PacienteModel{
    @Id
    private String id;
    @Column(name = "cpf", unique = true, length = 14)
    private String CPF;
    @Column (name = "estado_civil")
    private String estadoCivil;
    @Column (name = "nome_completo")
    private String nomeCompleto;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    private String genero;
    @Column(name = "email", unique = true)
    private String email;
    private String senha;
    private String telefone;
    private String contatoRepresentante;
    private String endereco;
//    @Column(name = "responsavel_CPF", length = 14)
//    private String responsavelCpf;
    @ManyToOne
    @JoinColumn(name="responsavel_id")
    @JsonBackReference
    private ResponsavelModel responsavel;
    @OneToMany(mappedBy = "paciente")
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
