package com.start.pronto_recife.Service;
import com.start.pronto_recife.DTOs.DTOConsulta;
import com.start.pronto_recife.Mapper.ConsultaMapper;
import com.start.pronto_recife.Models.ConsultaModel;
import com.start.pronto_recife.Models.PacienteModel;
import com.start.pronto_recife.Repositories.ConsultaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ConsultaService {
    private final ConsultaMapper consultaMapper;
    private final ConsultaRepository consultaRepository;

    public DTOConsulta createConsulta(DTOConsulta dtoconsulta){
        //consultaRepository.findById(dtoconsulta.id()).orElseThrow(()
                //-> new RuntimeException("Id nao encontrado"));
        ConsultaModel consultaModel = consultaMapper.toModel(dtoconsulta);
        ConsultaModel savedConsulta = consultaRepository.save(consultaModel);


        return consultaMapper.toDTO(savedConsulta);

    }
    public void deleteConsulta(UUID id){
        if (!consultaRepository.existsById(id)) {
            throw new RuntimeException("Consulta não encontrada.");
        }
        consultaRepository.deleteById(id);
    }
    public List<DTOConsulta> findAll(){
        List<ConsultaModel> consultas = consultaRepository.findAll();

        return consultaMapper.listModeltoListDTO(consultas);

    }
    public DTOConsulta getConsultaById(UUID id){
        ConsultaModel product = consultaRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Produto não encontrado."));
        return consultaMapper.toDTO(product);
    }
    public DTOConsulta updateConsultaByid(UUID id, DTOConsulta dtoconsulta){
        ConsultaModel existingConsulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id não encontrado!"));
        ConsultaModel updatedModel = consultaMapper.toModel(dtoconsulta);
        updatedModel.setId(existingConsulta.getId());
        consultaRepository.save(updatedModel);
        return consultaMapper.toDTO(updatedModel);

    }
}
