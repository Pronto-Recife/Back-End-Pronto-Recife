package com.start.pronto_recife.Mapper;

import com.start.pronto_recife.DTOs.DTOAgenteSaude;
import com.start.pronto_recife.Models.AgenteSaudeModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AgenteSaudeMapper {
@Mapping(source = "CPF",target = "cpf")
    AgenteSaudeModel toModel (DTOAgenteSaude dtoAgenteSaude);
@Mapping(source = "cpf",target = "CPF")
    DTOAgenteSaude toDTO (AgenteSaudeModel dtoAgenteSaude);
    List<DTOAgenteSaude> listEntitytoDTO(List<AgenteSaudeModel> AgentesSaude);
}
