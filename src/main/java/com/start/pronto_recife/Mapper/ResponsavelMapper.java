package com.start.pronto_recife.Mapper;

import com.start.pronto_recife.DTOs.DTOResponsavel;
import com.start.pronto_recife.Models.ResponsavelModel;

import java.util.List;

public interface ResponsavelMapper {
    DTOResponsavel toDTO(ResponsavelModel responsavelModel);
    ResponsavelModel toModel(DTOResponsavel dtoresponsavel);
    List<DTOResponsavel> listEntitytoListDTO(List<ResponsavelModel> responsavel);
}
