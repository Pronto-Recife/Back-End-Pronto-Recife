package com.start.pronto_recife.Service;

import com.start.pronto_recife.DTOs.DTOMedico;
import com.start.pronto_recife.Mapper.MedicoMapper;
import com.start.pronto_recife.Models.MedicoModel;
import com.start.pronto_recife.Repositories.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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
        MedicoModel medicoModel = medicoRepository.save(medicoMapper.toModel(dtoMedico));
        medicoModel.setSenha(criptSenha);
        return medicoMapper.toDTO(medicoModel);
    }

    public DTOMedico updateMedico(String CRM, DTOMedico dtoMedico){
        MedicoModel target = medicoRepository.findByCRM(CRM).orElseThrow(()->new RuntimeException("CRM não encontrado no banco"));
        target.setCRM(dtoMedico.CRM());
        target.setNome_completo(dtoMedico.nome_completo());
        target.setEspecialidade(dtoMedico.especialidade());
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
                new RuntimeException("CRM Não Existe!!"));
        return medicoMapper.toDTO(medicoExists);
    }

    public void deleteMedico(String CRM){
        medicoRepository.findByCRM(CRM).orElseThrow(() ->
                new RuntimeException("CRM Não Existe!!"));
        medicoRepository.deleteByCRM(CRM);
    }

}
