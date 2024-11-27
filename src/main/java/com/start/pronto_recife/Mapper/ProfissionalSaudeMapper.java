package com.start.pronto_recife.Mapper;

import com.start.pronto_recife.DTOs.DTOProfissionalSaude;
import com.start.pronto_recife.Models.ProfissionalSaudeModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper (componentModel = "spring")
public interface ProfissionalSaudeMapper {
    @Mapping(source = "coren",target = "coren")
    ProfissionalSaudeModel toModel (DTOProfissionalSaude dtoProfissionalSaude);
    @Mapping(source = "coren", target = "coren")
    DTOProfissionalSaude  toDTO (ProfissionalSaudeModel profissionalSaudeModel);
    List<DTOProfissionalSaude>listEntitytoDTO(List<ProfissionalSaudeModel> ProfissionaisSaude);
}
