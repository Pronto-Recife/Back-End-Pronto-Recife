package com.start.pronto_recife.Mapper;

import com.start.pronto_recife.DTOs.DTOHistorico;
import com.start.pronto_recife.Models.HistoricoModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HistoricoMapper {
    HistoricoModel toModel(DTOHistorico dtoHistorico);
    DTOHistorico toDTO(HistoricoModel historicoModel);
    List < DTOHistorico > toListDto(List<HistoricoModel> historicoModel);
}