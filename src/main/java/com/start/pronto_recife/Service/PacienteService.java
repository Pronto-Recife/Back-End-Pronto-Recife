package com.start.pronto_recife.Service;

import com.start.pronto_recife.DTOs.DTOPaciente;
import com.start.pronto_recife.Mapper.PacienteMapper;
import com.start.pronto_recife.Models.PacienteModel;
import com.start.pronto_recife.Repositories.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PacienteService {
    private final PacienteMapper pacienteMapper;
    private  final PacienteRepository pacienteRepository;

    public DTOPaciente createPaciente(DTOPaciente dtoPaciente){
        Optional<PacienteModel> cpfExist = pacienteRepository.findByCPF(dtoPaciente.CPF());
        if (cpfExist.isPresent()) {
            throw new RuntimeException("CPF Já Cadastrado!!");
        }
        PacienteModel pacienteModel = pacienteRepository.save(pacienteMapper.toModel(dtoPaciente));
        return pacienteMapper.toDTO(pacienteModel);
    }
}
