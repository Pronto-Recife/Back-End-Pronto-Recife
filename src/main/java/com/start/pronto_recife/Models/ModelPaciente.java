package com.start.pronto_recife.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "paciente")

public class ModelPaciente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CPF")
    private String CPF;

    private String nome_completo;
    private LocalDate data_nascimento;
    private String genero;
    private String email;
    private String telefone;
    private String contato_representante;
    private String cep;
    private String endereco;
    private String responsavel_CPF;

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getContato_representante() {
        return contato_representante;
    }

    public void setContato_representante(String contato_representante) {
        this.contato_representante = contato_representante;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getResponsavel_CPF() {
        return responsavel_CPF;
    }

    public void setResponsavel_CPF(String responsavel_CPF) {
        this.responsavel_CPF = responsavel_CPF;
    }
}
