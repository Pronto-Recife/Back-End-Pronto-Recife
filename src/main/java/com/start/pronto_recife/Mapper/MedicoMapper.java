package com.start.pronto_recife.Mapper;

import com.start.pronto_recife.DTOs.DTOMedico;
import com.start.pronto_recife.Models.MedicoModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicoMapper {
    MedicoModel toModel(DTOMedico dtoMedico);
    DTOMedico toDTO(MedicoModel medicoModel);
    List<DTOMedico> listEntitytoListDTO(List<MedicoModel> medicos);

}
