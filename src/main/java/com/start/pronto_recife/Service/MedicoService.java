package com.start.pronto_recife.Service;

import com.start.pronto_recife.DTOs.DTOMedico;
import com.start.pronto_recife.DTOs.DTOPaciente;
import com.start.pronto_recife.Mapper.MedicoMapper;
import com.start.pronto_recife.Models.MedicoModel;
import com.start.pronto_recife.Models.PacienteModel;
import com.start.pronto_recife.Repositories.MedicoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MedicoService {
    private final MedicoMapper medicoMapper;
    private final MedicoRepository medicoRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public DTOMedico createMedico(DTOMedico dtoMedico){
        medicoRepository.findByCRM(dtoMedico.CRM()).ifPresent(medicoModel -> {
            throw new RuntimeException("CRM já cadastrado");
        });
        String criptSenha = passwordEncoder.encode(dtoMedico.senha());
        MedicoModel medicoModel = medicoMapper.toModel(dtoMedico);
        medicoModel.setSenha(criptSenha);
        medicoRepository.save(medicoModel);
        return medicoMapper.toDTO(medicoModel);
    }

    public DTOMedico updateMedico(String CRM, DTOMedico dtoMedico){
        MedicoModel target = medicoRepository.findByCRM(CRM).orElseThrow(()->new RuntimeException("CRM não encontrado no banco"));
        target.setCRM(dtoMedico.CRM());
        target.setNome_completo(dtoMedico.nome_completo());
        target.setEspecialidade(dtoMedico.especialidade());
        target.setTelefone(dtoMedico.telefone());
        target.setEmail(dtoMedico.email());
        target.setSenha(passwordEncoder.encode(dtoMedico.senha()));


        return medicoMapper.toDTO(medicoRepository.save(target));
    }

    public List<DTOMedico> findAll(){
        List<MedicoModel> medicos = medicoRepository.findAll();
        return medicoMapper.listEntitytoListDTO(medicos);
    }

    public DTOMedico findByCRM(String CRM){
        MedicoModel medicoExists = medicoRepository.findByCRM(CRM).orElseThrow(() ->
                new RuntimeException("CRM Não Existe!!"));
        return medicoMapper.toDTO(medicoExists);
    }

}
