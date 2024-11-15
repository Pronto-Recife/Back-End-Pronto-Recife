package com.start.pronto_recife.ExamePacienteModel;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "exame_do_paciente")
public class ExamePacienteModel {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "data_exame", nullable = false)
    private String dataExame;

    @Column(name = "resultado", nullable = false)
    private String resultado;

    @Column(name = "nome_do_exame", nullable = false, length = 100)
    private String nomeDoExame;

    @Column(name = "paciente_id", nullable = false)
    private UUID pacienteId;

    @Column(name = "consulta_id")
    private UUID consultaId;
}

//Getters e Setters
public UUID getId() {
    return id;
}

public void setId(UUID id) {
    this.id = id;
}

public String getDataExame() {
    return dataExame;
}

public void setDataExame(String dataExame) {
    this.dataExame = dataExame;
}

public String getResultado() {
    return resultado;
}

public void setResultado(String resultado) {
    this.resultado = resultado;
	}

public String getNomeDoExame() {
    return nomeDoExame;
	}

public void setNomeDoExame(String nomeDoExame) {
    this.nomeDoExame = nomeDoExame;
	}

public UUID getPacienteId() {
    return pacienteId;
    }

public void setPacienteId(UUID pacienteId) {
    this.pacienteId = pacienteId;
	}

public UUID getConsultaId() {
    return consultaId;
	}

public void setConsultaId(UUID consultaId) {
    this.consultaId = consultaId;
	}
}
