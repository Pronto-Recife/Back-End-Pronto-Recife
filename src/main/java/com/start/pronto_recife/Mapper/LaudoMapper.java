package com.start.pronto_recife.Mapper;

import com.start.pronto_recife.DTOs.DTOLaudo;
import com.start.pronto_recife.Models.LaudoModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LaudoMapper {
    DTOLaudo toDTO(LaudoModel laudoModel);
    LaudoModel toModel(DTOLaudo dtoLaudo);
    List<DTOLaudo> listEntitytoListDTO(List<LaudoModel> laudos);
}
