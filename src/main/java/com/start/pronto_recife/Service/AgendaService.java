package com.start.pronto_recife.Service;

import com.start.pronto_recife.DTOs.DTOAgenda;
import com.start.pronto_recife.DTOs.DTOMedico;
import com.start.pronto_recife.Mapper.AgendaMapper;
import com.start.pronto_recife.Models.AgendaModel;
import com.start.pronto_recife.Models.MedicoModel;
import com.start.pronto_recife.Repositories.AgendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgendaService {
    private final AgendaMapper agendaMapper;
    private final AgendaRepository agendaRepository;

    public DTOAgenda createAgenda(DTOAgenda dtoAgenda){
        agendaRepository.findById(dtoAgenda.id()).ifPresent(agendaModel -> {
            throw new RuntimeException("Consulta já cadastrado");
        });
        AgendaModel agendaModel = agendaRepository.save(agendaMapper.toModel(dtoAgenda));
        return agendaMapper.toDTO(agendaModel);

    }

//    public DTOAgenda findById(String id){
//        AgendaModel agendaExists = agendaRepository.findById(id).orElseThrow(() ->
//                new RuntimeException("id Não Existe!!"));
//        return agendaMapper.toDTO(agendaExists);
//    }

}