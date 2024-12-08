package com.start.pronto_recife.Mapper;

import com.start.pronto_recife.DTOs.DTOResponsavel;
import com.start.pronto_recife.DTOs.DTOResponsavelRequest;
import com.start.pronto_recife.Models.ResponsavelModel;
import org.mapstruct.Mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Mapper(componentModel = "spring")
public interface ResponsavelMapper {
    DTOResponsavel toDTO(ResponsavelModel responsavelModel);
    ResponsavelModel toModel(DTOResponsavel dtoresponsavel);
    ResponsavelModel toModel(DTOResponsavelRequest dtoresponsavel);
    List<DTOResponsavel> listEntitytoListDTO(List<ResponsavelModel> responsavel);
    default String map(LocalDate value){
        return value != null ? value.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")):null;
    }
    default LocalDate map(String value){
        return value != null ? LocalDate.parse(value, DateTimeFormatter.ofPattern("dd/MM/yyyy")) : null;
    }
}