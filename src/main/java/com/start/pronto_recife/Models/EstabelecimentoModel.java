package com.start.pronto_recife.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "estabelecimento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstabelecimentoModel {
    @Id
    private String id;
    private String cnpj;
    private String nome;
    private String senha;
    private String endereco;
    private String telefone;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "id_medico", unique = true)
    private String idMedico;
    @Column(name = "id_consulta", unique = true)
    private String idConsulta;
    @Column(name = "id_paciente", unique = true)
    private String idpaciente;
    @Column(name = "id_agente_saude", unique = true)
    private String idagenteSaude;

    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
