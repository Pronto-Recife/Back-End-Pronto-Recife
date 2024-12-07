package com.start.pronto_recife.Service;

import com.start.pronto_recife.DTOs.DTOPaciente;
import com.start.pronto_recife.Exceptions.CustomException;
import com.start.pronto_recife.Mapper.PacienteMapper;
import com.start.pronto_recife.Models.PacienteModel;
import com.start.pronto_recife.Models.ResponsavelModel;
import com.start.pronto_recife.Repositories.PacienteRepository;
import com.start.pronto_recife.Repositories.ResponsavelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteMapper pacienteMapper;
    private final PacienteRepository pacienteRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final ResponsavelRepository responsavelRepository;

    public DTOPaciente createPaciente(DTOPaciente dtoPaciente){
        if(pacienteRepository.findByCPF(dtoPaciente.CPF()).isPresent()){
            throw new CustomException("CPF já cadastrado por outro usuário!", HttpStatus.CONFLICT, null);
        }
        ResponsavelModel responsavelModel =responsavelRepository.findById(dtoPaciente.responsavelId()).orElseThrow();
        String criptSenha = passwordEncoder.encode(dtoPaciente.senha());
        PacienteModel newPaciente = pacienteMapper.toModel(dtoPaciente);
        newPaciente.setSenha(criptSenha);
        newPaciente.setResponsavel(responsavelModel);
        pacienteRepository.save(newPaciente);
        return pacienteMapper.toDTO(newPaciente);
    }
    public DTOPaciente updatePaciente(String cpf, DTOPaciente dtoPaciente){
        PacienteModel existingPaciente = pacienteRepository.findByCPF(cpf)
                .orElseThrow(() -> new CustomException("CPF não encontrado!", HttpStatus.NOT_FOUND, null));
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
                new CustomException("Paciente não encontrado!", HttpStatus.NOT_FOUND, null));
        return pacienteMapper.toDTO(pacientExists);
    }
    public void deletePaciente(String id){
        PacienteModel pacienteExists = pacienteRepository.findById(id).orElseThrow(() ->
                new CustomException("Paciente não Existe!", HttpStatus.NOT_FOUND, null));
        pacienteRepository.delete(pacienteExists);
    }
}
