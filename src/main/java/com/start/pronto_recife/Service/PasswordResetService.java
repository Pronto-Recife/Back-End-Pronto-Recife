package com.start.pronto_recife.Service;

import com.start.pronto_recife.DTOs.PasswordResetTokenDTO;
import com.start.pronto_recife.Exceptions.CustomException;
import com.start.pronto_recife.Models.MedicoModel;
import com.start.pronto_recife.Models.PacienteModel;
import com.start.pronto_recife.Models.PasswordResetToken;
import com.start.pronto_recife.Repositories.MedicoRepository;
import com.start.pronto_recife.Repositories.PacienteRepository;
import com.start.pronto_recife.Repositories.PasswordResetTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PasswordResetService {

    private final PasswordResetTokenRepository tokenRepository;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;
    private final EmailService emailService;


    public void sendTokenMail(String to, PasswordResetTokenDTO resetTokenDto){
            emailService.sendEmail(to, resetTokenDto.token(), resetTokenDto.expiration().toString());

    }
    public PasswordResetTokenDTO generateToken(String email) {
        if(pacienteRepository.findByEmail(email).isEmpty()){
            throw new CustomException("Email não existe!", HttpStatus.NO_CONTENT, null);
        }
        if(medicoRepository.findByEmail(email).isEmpty()){
            throw new CustomException("Email não existe!", HttpStatus.NO_CONTENT, null);
        }

        PasswordResetToken token = new PasswordResetToken();
        token.setToken(generateNumericToken());
        token.setExpiration(LocalDateTime.now().plusMinutes(30));

        PasswordResetToken savedToken = tokenRepository.save(token);
        PasswordResetTokenDTO savedTokenDto = new PasswordResetTokenDTO(savedToken.getToken(), savedToken.getExpiration());

//      Envia o email
        sendTokenMail(email, savedTokenDto);

        return savedTokenDto;
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


        if (!validateToken(resetToken.getToken())){
           throw new CustomException("Token Invalido", HttpStatus.UNAUTHORIZED, null);
        }
        if(resetToken.getIdMedico() != null){
            MedicoModel medico = medicoRepository.findById(resetToken.getIdMedico()).orElseThrow(() ->
                    new CustomException("Profissional não encontrado!", HttpStatus.NOT_FOUND, null));
            medico.setSenha(newPassword);
            medicoRepository.save(medico);
        }

        if(resetToken.getIdPaciente() != null){
            PacienteModel paciente = pacienteRepository.findById(resetToken.getIdPaciente()).orElseThrow(() ->
                    new CustomException("Paciente não encontrado!", HttpStatus.NOT_FOUND, null));
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