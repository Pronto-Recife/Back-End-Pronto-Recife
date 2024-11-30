package com.start.pronto_recife.Service;

import com.start.pronto_recife.DTOs.ExamePacienteDTO;
import com.start.pronto_recife.Exceptions.CustomException;
import com.start.pronto_recife.Mapper.ExamePacienteMapper;
import com.start.pronto_recife.Models.ExamePacienteModel;
import com.start.pronto_recife.Repositories.ExamePacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamePacienteService {

    private final ExamePacienteRepository exameRepository;
    private final ExamePacienteMapper examePacienteMapper;

    public ExamePacienteDTO createExame(ExamePacienteDTO examePacienteDTO) {
        try {
            ExamePacienteModel exame = examePacienteMapper.toModel(examePacienteDTO);
            exame = exameRepository.save(exame);
            return examePacienteMapper.toDTO(exame);
        }catch (Exception e){
            throw new CustomException("Erro ao criar Exame!", HttpStatus.BAD_REQUEST, null);
        }
    }
    public ExamePacienteDTO getExameById(String id) {
        ExamePacienteModel model  = exameRepository.findById(id).orElseThrow(()
                -> new CustomException("Exame não encontrado!", HttpStatus.NOT_FOUND, null));
        return examePacienteMapper.toDTO(model);
    }
    public List<ExamePacienteDTO> getAllExames() {
        List<ExamePacienteModel> exames = exameRepository.findAll();
        return examePacienteMapper.listEntitytoListDTO(exames);
    }
    public ExamePacienteDTO updateExame(String id, ExamePacienteDTO dto) {
        ExamePacienteModel existingExame = exameRepository.findById(id)
                .orElseThrow(() -> new CustomException("Exame não encontrado!", HttpStatus.NOT_FOUND, null));
        ExamePacienteModel updatModel = examePacienteMapper.toModel(dto);
        updatModel.setId(existingExame.getId());
        exameRepository.save(updatModel);
        return examePacienteMapper.toDTO(updatModel);
    }
    public void deleteExame(String id) {
        if (!exameRepository.existsById(id)) {
            throw new CustomException("Exame não encontrado!", HttpStatus.NOT_FOUND, null);
        }
        exameRepository.deleteById(id);
    }
}