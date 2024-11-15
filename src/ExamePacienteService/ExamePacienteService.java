package com.start.pronto_recife.ExamePacienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.start.pronto_recife.ExamePacienteDTO.ExamePacienteDTO;
import com.start.pronto_recife.ExamePacienteMapper.ExamePacienteMapper;
import com.start.pronto_recife.ExamePacienteRepository.ExamePacienteRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ExamePacienteService<Exame> {

    @Autowired
    private ExamePacienteRepository exameRepository;

    @Autowired
    private ExamePacienteMapper mapper;

    public ExamePacienteDTO createExame(ExamePacienteDTO dto) {
        Exame model = mapper.toModel(dto);
        Exame savedExame = exameRepository.save(model);
        return mapper.toDTO(savedExame);
    }

    public ExamePacienteDTO getExameById(UUID id) {
        Optional<Exame> exame = exameRepository.findById(id);
        return exame.map(mapper::toDTO).orElse(null);
    }
    
    public List<ExamePacienteDTO> getAllExames() {
        List<ExamePacienteRepository> exames = exameRepository.findAll();
        return exames.stream().map(mapper::toDTO).toList();
    }
    
    public ExamePacienteDTO updateExame(UUID id, ExamePacienteDTO dto) {
        if (!exameRepository.existsById(id)) {
            return null; 
        }
        Exame model = mapper.toModel(dto);
        model.setId(id);
        ExamePacienteRepository updatedExame = ExamePacienteRepository.save(model);
        return mapper.toDTO(updatedExame);
    }

    public boolean deleteExame(UUID id) {
        if (!ExamePacienteRepository.existsById(id)) {
            return false;
        }
        exameRepository.deleteById(id);
        return true;
    }
}


