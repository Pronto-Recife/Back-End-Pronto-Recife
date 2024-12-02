package com.start.pronto_recife.Service;

import com.start.pronto_recife.Exceptions.CustomException;
import com.start.pronto_recife.DTOs.Auth.AuthenticationRequestDTO;
import com.start.pronto_recife.Models.EstabelecimentoModel;
import com.start.pronto_recife.Models.MedicoModel;
import com.start.pronto_recife.Models.PacienteModel;
import com.start.pronto_recife.Models.ProfissionalSaudeModel;
import com.start.pronto_recife.Repositories.MedicoRepository;
import com.start.pronto_recife.Repositories.PacienteRepository;
import com.start.pronto_recife.Enum.LoginFlowEnum;
import com.start.pronto_recife.Repositories.ProfissionalSaudeRepository;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    @Value("${jjwt.secret}")
    private String jjwtSecret;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;
    private final ProfissionalSaudeRepository profissionalSaudeRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public String authenticate(AuthenticationRequestDTO request){
        if (request.getFlow() == LoginFlowEnum.COREN) {
            ProfissionalSaudeModel profissionalSaude = getProfissional(request.getIdentificador());
            if (!passwordEncoder.matches(request.getSenha(), profissionalSaude.getSenha())) {
                throw new CustomException("COREN ou Senha Incorreta!", HttpStatus.UNAUTHORIZED, null);
            }
            return tokenService.generateToken(profissionalSaude.getId());
        }
        if (request.getFlow() == LoginFlowEnum.CRM) {
            MedicoModel medico = getMedico(request.getIdentificador());
            if (!passwordEncoder.matches(request.getSenha(), medico.getSenha())) {
                throw new CustomException("CRM ou Senha Incorreta!", HttpStatus.UNAUTHORIZED, null);
            }
            return tokenService.generateToken(medico.getId());
        }
        if (request.getFlow() == LoginFlowEnum.CPF) {
            PacienteModel paciente = getPaciente(request.getIdentificador());
            if (!passwordEncoder.matches(request.getSenha(), paciente.getSenha())) {
                throw new CustomException("CPF ou Senha Incorreta!", HttpStatus.UNAUTHORIZED, null);
            }
            return tokenService.generateToken(paciente.getId());
        }
        return "Invalid Flow!";
    }
    public MedicoModel getMedico(String crm){
        return medicoRepository.findByCRM(crm).orElseThrow(() ->
                new RuntimeException("Medico Não Encontrado!"));
    }
    public PacienteModel getPaciente(String cpf){
        return pacienteRepository.findByCPF(cpf).orElseThrow(() ->
                new RuntimeException("Paciente Não Encontrado!"));
    }
    public ProfissionalSaudeModel getProfissional(String coren){
         return profissionalSaudeRepository.findByCoren(coren).orElseThrow(() ->
                new RuntimeException("Estabelecimento Não Encontrado!"));
    }
    private SecretKey getSecretKey() {
        return new SecretKeySpec(jjwtSecret.getBytes(), "HmacSHA256");
    }
}