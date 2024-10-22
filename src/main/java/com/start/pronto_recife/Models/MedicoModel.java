package com.start.pronto_recife.Models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "medico")
public class MedicoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CRM")
    private String CRM;
    private String nome_completo;
    private String especialidade;
    private String telefone;
    private String email;

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
