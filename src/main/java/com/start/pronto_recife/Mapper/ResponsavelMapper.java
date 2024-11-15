package com.start.pronto_recife.Mapper;

import com.start.pronto_recife.DTOs.DTOResponsavel;
import com.start.pronto_recife.Models.ResponsavelModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ResponsavelMapper {
    @Mapping(source = "dataNascimento", target = "dataNascimento")
    DTOResponsavel toDTO(ResponsavelModel responsavelModel);
    @Mapping(source = "dataNascimento", target = "dataNascimento")
    ResponsavelModel toModel(DTOResponsavel dtoresponsavel);
    List<DTOResponsavel> listEntitytoListDTO(List<ResponsavelModel> responsavel);
}
