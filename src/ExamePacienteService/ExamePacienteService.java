package com.start.pronto_recife.Service;

import com.start.pronto_recife.DTOs.ExamePacienteDTO;
import com.start.pronto_recife.Mapper.ExamePacienteMapper;
import com.start.pronto_recife.Models.ExamePacientModel;
import com.start.pronto_recife.Repositories.ExamePacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExamePacienteService {

    private final ExamePacienteRepository exameRepository;
    private final ExamePacienteMapper examemapper;

    
    public ExamePacienteDTO createExame(ExamePacienteDTO dto) {
        if(exameRepository.findById(dto.id()).isPresent()){
            throw new RuntimeException("Exame já existe!");
        }
        ExamePacientModel model = examemapper.toModel(dto);
        model= exameRepository.save(model);
        return examemapper.toDTO(model);
    }

    
    public ExamePacienteDTO getExameById(UUID id) {
        ExamePacientModel model  = exameRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Exame não encontrado."));
        return examemapper.toDTO(model);
    }

   
    public List<ExamePacienteDTO> getAllExames() {
        List<ExamePacientModel> exames = exameRepository.findAll();
        return examemapper.listEntitytoListDTO(exames);
    }

  
    public ExamePacienteDTO updateExame(UUID id, ExamePacienteDTO dto) {
        ExamePacientModel existingExame = exameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exame não encontrado!"));
        ExamePacientModel updatModel = examemapper.toModel(dto);
        updatModel.setId(existingExame.getId());
        exameRepository.save(updatModel);
        return examemapper.toDTO(updatModel);
    }

   
    public void  deleteExame(UUID id) {
        if (!exameRepository.existsById(id)) {
            throw new RuntimeException("Exame não encontrado.");
        }
         exameRepository.deleteById(id);
    }

}
