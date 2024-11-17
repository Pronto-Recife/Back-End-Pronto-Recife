package com.start.pronto_recife.Service;

import com.start.pronto_recife.DTOs.DTOPaciente;
import com.start.pronto_recife.Mapper.PacienteMapper;
import com.start.pronto_recife.Models.PacienteModel;
import com.start.pronto_recife.Repositories.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteMapper pacienteMapper;
    private final PacienteRepository pacienteRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public DTOPaciente createPaciente(DTOPaciente dtoPaciente){
        if(pacienteRepository.findByCPF(dtoPaciente.CPF()).isPresent()){
            throw new RuntimeException("CPF já existe!");
        }
        String criptSenha = passwordEncoder.encode(dtoPaciente.senha());
        PacienteModel newPaciente = pacienteMapper.toModel(dtoPaciente);
        newPaciente.setSenha(criptSenha);
        pacienteRepository.save(newPaciente);
        return pacienteMapper.toDTO(newPaciente);
    }
    public String loginPaciente(String cpf, String senha){
        PacienteModel pacienteExists = pacienteRepository.findByCPF(cpf)
                .orElseThrow(() -> new RuntimeException("CPF Não Encontrado!"));

        if (!passwordEncoder.matches(senha, pacienteExists.getSenha())) {
            throw new RuntimeException("Senha incorreta!");
        }

        return "Login Bem-Sucedido!";
    }
    public DTOPaciente updatePaciente(String id, DTOPaciente dtoPaciente){
        PacienteModel existingPaciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id não encontrado!"));
        PacienteModel updatedModel = pacienteMapper.toModel(dtoPaciente);
        updatedModel.setId(existingPaciente.getId());
        pacienteRepository.save(updatedModel);
        return pacienteMapper.toDTO(updatedModel);
    }
    public List<DTOPaciente> findAll(){
        List<PacienteModel> pacientes = pacienteRepository.findAll();
        return pacienteMapper.listEntitytoListDTO(pacientes);
    }
    public DTOPaciente findByCPF(String CPF){
        PacienteModel pacientExists = pacienteRepository.findByCPF(CPF).orElseThrow(() ->
                new RuntimeException("CPF Não Existe!!"));
        return pacienteMapper.toDTO(pacientExists);
    }
    public void deletePaciente(String id){
        PacienteModel pacienteExists = pacienteRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuario não existe!"));
        pacienteRepository.delete(pacienteExists);
    }
}
