package com.start.pronto_recife.Service;
import com.start.pronto_recife.DTOs.DTOConsulta;
import com.start.pronto_recife.DTOs.DTOConsultaRequest;
import com.start.pronto_recife.Exceptions.CustomException;
import com.start.pronto_recife.Mapper.ConsultaMapper;
import com.start.pronto_recife.Models.ConsultaModel;
import com.start.pronto_recife.Models.MedicoModel;
import com.start.pronto_recife.Models.PacienteModel;
import com.start.pronto_recife.Repositories.ConsultaRepository;
import com.start.pronto_recife.Repositories.MedicoRepository;
import com.start.pronto_recife.Repositories.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaService {
    private final ConsultaMapper consultaMapper;
    private final ConsultaRepository consultaRepository;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    public DTOConsulta createConsulta(DTOConsulta dtoconsulta){
        try {

            ConsultaModel consultaModel = consultaMapper.toModel(dtoconsulta);

            ConsultaModel savedConsulta = consultaRepository.save(consultaModel);
            return consultaMapper.toDTO(savedConsulta);
        }catch (Exception e){
            throw new CustomException("Erro ao registrar consulta!", HttpStatus.BAD_REQUEST, null);
        }
    }
    public DTOConsulta reagendarConsulta(String id, LocalDate novaDataConsulta) {
        if (novaDataConsulta.isBefore(LocalDate.now())) {
            throw new CustomException("Não é permitido reagendar consultas para dias anteriores!", HttpStatus.BAD_REQUEST, null);
        }

        ConsultaModel consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new CustomException("ID da consulta não encontrado!", HttpStatus.NOT_FOUND, null));


        consulta.setDataConsulta(novaDataConsulta);
        consultaRepository.save(consulta);
        return consultaMapper.toDTO(consulta);
    }
    public void deleteConsulta(String id){
        if (!consultaRepository.existsById(id)) {
            throw new CustomException("ID da consulta não encontrado!", HttpStatus.NOT_FOUND, null);
        }
        consultaRepository.deleteById(id);
    }
    public List<DTOConsulta> findAll(){
        List<ConsultaModel> consultas = consultaRepository.findAll();
        return consultaMapper.listModeltoListDTO(consultas);
    }
    public DTOConsulta getConsultaById(String id){
        ConsultaModel product = consultaRepository.findById(id).orElseThrow(()
                -> new CustomException("ID da consulta não encontrado!", HttpStatus.NOT_FOUND, null));
        return consultaMapper.toDTO(product);
    }
    public DTOConsulta updateConsultaByid(String id, DTOConsulta dtoconsulta){
        ConsultaModel existingConsulta = consultaRepository.findById(id)
                .orElseThrow(() -> new CustomException("ID da consulta não encontrado!", HttpStatus.NOT_FOUND, null));
        ConsultaModel updatedModel = consultaMapper.toModel(dtoconsulta);
        updatedModel.setId(existingConsulta.getId());
        consultaRepository.save(updatedModel);
        return consultaMapper.toDTO(updatedModel);
    }

}
