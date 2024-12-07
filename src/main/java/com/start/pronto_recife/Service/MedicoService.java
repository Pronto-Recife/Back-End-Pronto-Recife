package com.start.pronto_recife.Service;

import com.start.pronto_recife.DTOs.DTOMedico;
import com.start.pronto_recife.DTOs.DTOPaciente;
import com.start.pronto_recife.Exceptions.CustomException;
import com.start.pronto_recife.Mapper.MedicoMapper;
import com.start.pronto_recife.Models.MedicoModel;
import com.start.pronto_recife.Models.PacienteModel;
import com.start.pronto_recife.Repositories.MedicoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
            throw new CustomException("CRM já cadastrado por outro usuário!", HttpStatus.CONFLICT, null);
        });
        String criptSenha = passwordEncoder.encode(dtoMedico.senha());
        MedicoModel newMedico = medicoMapper.toModel(dtoMedico);
        newMedico.setSenha(criptSenha);
        medicoRepository.save(newMedico);
        return medicoMapper.toDTO(newMedico);
    }
    public DTOMedico updateMedico(String CRM, DTOMedico dtoMedico){
        MedicoModel target = medicoRepository.findByCRM(CRM)
                .orElseThrow(()->new CustomException("CRM não encontrado!", HttpStatus.NOT_FOUND, null));
        target.setCRM(dtoMedico.CRM());
//        target.setIdEstabelecimento(dtoMedico.idEstabelecimento());
        target.setNomeCompleto(dtoMedico.nomeCompleto());
        target.setTelefone(dtoMedico.telefone());
        target.setEmail(dtoMedico.email());

        return medicoMapper.toDTO(medicoRepository.save(target));
    }
    public List<DTOMedico> findAll(){
        List<MedicoModel> medicos = medicoRepository.findAll();
        return medicoMapper.listEntitytoListDTO(medicos);
    }
    public DTOMedico findByCRM(String CRM){
        MedicoModel medicoExists = medicoRepository.findByCRM(CRM).orElseThrow(() ->
                new CustomException("CRM não encontrado!", HttpStatus.NOT_FOUND, null));
        return medicoMapper.toDTO(medicoExists);
    }
    public void deleteMedico(String CRM){
        medicoRepository.findByCRM(CRM).orElseThrow(() ->
                new CustomException("CRM não encontrado!", HttpStatus.NOT_FOUND, null));
        medicoRepository.deleteByCRM(CRM);
    }

}