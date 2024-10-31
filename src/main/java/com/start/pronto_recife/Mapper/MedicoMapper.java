package com.start.pronto_recife.Mapper;

import com.start.pronto_recife.DTOs.DTOMedico;
import com.start.pronto_recife.Models.MedicoModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicoMapper {
    MedicoModel toModel(DTOMedico dtoMedico);
    DTOMedico toDTO(MedicoModel medicoModel);
}
