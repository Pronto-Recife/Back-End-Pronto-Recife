package com.start.pronto_recife.Mapper;

import com.start.pronto_recife.DTOs.DTOAgenda;
import com.start.pronto_recife.Models.AgendaModel;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface AgendaMapper {
    AgendaModel toModel(DTOAgenda dtoAgenda);
    DTOAgenda toDTO(AgendaModel agendaModel);
    List<DTOAgenda> listEntitytoListDTO(List<AgendaModel> agendaModels);

}
