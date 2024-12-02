package com.start.pronto_recife.Models;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "password_reset_token")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PasswordResetToken {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime expiration;

    @ManyToOne
    @JoinColumn(name = "medico_id", referencedColumnName = "id", nullable = true)
    private MedicoModel medico;

    @ManyToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "id", nullable = true)
    private PacienteModel paciente;

}
