package com.start.pronto_recife.Service;

import com.start.pronto_recife.DTOs.Auth.AuthenticationRequestDTO;
import com.start.pronto_recife.DTOs.DTOEstabelecimento;
import com.start.pronto_recife.DTOs.DTOMedico;
import com.start.pronto_recife.DTOs.DTOPaciente;
import com.start.pronto_recife.Enum.LoginFlowEnum;
import com.start.pronto_recife.Exceptions.User.UserAuthenticationException;
import com.start.pronto_recife.Mapper.EstabelecimentoMapper;
import com.start.pronto_recife.Mapper.MedicoMapper;
import com.start.pronto_recife.Mapper.PacienteMapper;
import com.start.pronto_recife.Models.EstabelecimentoModel;
import com.start.pronto_recife.Models.MedicoModel;
import com.start.pronto_recife.Models.PacienteModel;
import com.start.pronto_recife.Repositories.EstabelecimentoRepository;
import com.start.pronto_recife.Repositories.MedicoRepository;
import com.start.pronto_recife.Repositories.PacienteRepository;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    @Value("${jjwt.secret}")
    private String jjwtSecret;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;
    private final EstabelecimentoRepository estabelecimentoRepository;
    private final PasswordEncoder passwordEncoder;

    public String authenticate(AuthenticationRequestDTO request){
        if (request.getFlow() == LoginFlowEnum.CNPJ) {
            EstabelecimentoModel estabelecimento = getEstabelecimento(request.getIdentificador());
            if (!passwordEncoder.matches(request.getSenha(), estabelecimento.getSenha())) {
                throw new UserAuthenticationException();
            }
            return generateToken(estabelecimento.getId());
        }
        if (request.getFlow() == LoginFlowEnum.CRM) {
            MedicoModel medico = getMedico(request.getIdentificador());
            if (!passwordEncoder.matches(request.getSenha(), medico.getSenha())) {
                throw new UserAuthenticationException();
            }
            return generateToken(medico.getId());
        }
        if (request.getFlow() == LoginFlowEnum.CPF) {
            PacienteModel paciente = getPaciente(request.getIdentificador());
            if (!passwordEncoder.matches(request.getSenha(), paciente.getSenha())) {
                throw new UserAuthenticationException();
            }
            return generateToken(paciente.getId());
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
    public EstabelecimentoModel getEstabelecimento(String cnpj){
         return estabelecimentoRepository.findByCnpj(cnpj).orElseThrow(() ->
                new RuntimeException("Estabelecimento Não Encontrado!"));
    }
    public String generateToken(String id){
        return Jwts.builder()
                .subject(id)
                .issuedAt(new Date())
                .expiration(Date.from(Instant.now().plus(24, ChronoUnit.HOURS)))
                .signWith(getSecretKey())
                .compact();
    }
    private SecretKey getSecretKey() {
        return new SecretKeySpec(jjwtSecret.getBytes(), "HmacSHA256");
    }
}