package com.start.pronto_recife.ExamePacienteDTO;

import java.util.UUID;

public class ExamePacienteDTO {

    private UUID id;
    private String data_exame;
    private String resultado;
    private String nome_do_exame;
    private UUID paciente_id;
    private UUID consulta_id;

    // Getters e Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDataExame() {
        return data_exame;
    }

    public void setDataExame(String data_exame) {
        this.data_exame = data_exame;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getNomeDoExame() {
        return nome_do_exame;
    }

    public void setNomeDoExame(String nome_do_exame) {
        this.nome_do_exame = nome_do_exame;
    }

    public UUID getpaciente_id() {
        return paciente_id;
    }

    public void setpaciente_id(UUID paciente_id) {
        this.paciente_id = paciente_id;
    }

    public UUID getconsulta_id() {
        return consulta_id;
    }

    public void setconsulta_id(UUID consulta_id) {
        this.consulta_id = consulta_id;
    }
}


