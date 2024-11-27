package com.start.pronto_recife.Service;

import com.start.pronto_recife.DTOs.PasswordResetTokenDTO;
import com.start.pronto_recife.Models.MedicoModel;
import com.start.pronto_recife.Models.PacienteModel;
import com.start.pronto_recife.Models.PasswordResetToken;
import com.start.pronto_recife.Mapper.MedicoMapper;
import com.start.pronto_recife.Mapper.PacienteMapper;
import com.start.pronto_recife.Repositories.MedicoRepository;
import com.start.pronto_recife.Repositories.PacienteRepository;
import com.start.pronto_recife.Repositories.PasswordResetTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PasswordResetService {

    private final PasswordResetTokenRepository tokenRepository;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;
    private final MedicoMapper medicoMapper;
    private final PacienteMapper pacienteMapper;

    // Gera o token de reset de senha
    public PasswordResetTokenDTO generateToken(String email, boolean isMedico) {
        PasswordResetToken token = new PasswordResetToken();
        token.setToken(generateNumericToken());
        token.setExpiration(LocalDateTime.now().plusMinutes(30));

        if (isMedico) {
            MedicoModel medicoModel = medicoRepository.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("Médico não encontrado com o email fornecido."));
            token.setMedico(medicoModel);
        } else {
            PacienteModel pacienteModel = pacienteRepository.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("Paciente não encontrado com o email fornecido."));
            token.setPaciente(pacienteModel);
        }

        PasswordResetToken savedToken = tokenRepository.save(token);
        return new PasswordResetTokenDTO(savedToken.getToken(), savedToken.getExpiration());
    }

    // Valida o token
    public boolean validateToken(String token) {
        Optional<PasswordResetToken> optionalToken = tokenRepository.findByToken(token);
        if (optionalToken.isEmpty()) {
            throw new RuntimeException("Token inválido!");
        }

        PasswordResetToken resetToken = optionalToken.get();
        if (resetToken.getExpiration().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Token expirado!");
        }

        return true;
    }


    public void resetPassword(String token, String newPassword) {
        PasswordResetToken resetToken = tokenRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Token inválido ou expirado!"));

        if (resetToken.getMedico() != null) {
            MedicoModel medico = resetToken.getMedico();
            medico.setSenha(newPassword);
            medicoRepository.save(medico);
        } else if (resetToken.getPaciente() != null) {
            PacienteModel paciente = resetToken.getPaciente();
            paciente.setSenha(newPassword);
            pacienteRepository.save(paciente);
        }

        tokenRepository.delete(resetToken);
    }

    // Gera o token numérico
    private String generateNumericToken() {
        return String.valueOf((int) (Math.random() * 900000) + 100000); // Gera um token numérico de 6 dígitos
    }
}
