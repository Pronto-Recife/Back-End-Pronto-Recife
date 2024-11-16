package com.start.pronto_recife.Mapper;

import com.start.pronto_recife.DTOs.DTOEstabelecimento;
import com.start.pronto_recife.Models.EstabelecimentoModel;
import com.start.pronto_recife.Models.PacienteModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstabelecimentoMapper {
    EstabelecimentoModel toModel(DTOEstabelecimento dtoEstabelecimento);
    DTOEstabelecimento toDTO(EstabelecimentoModel estabelecimentoModel);
    List<DTOEstabelecimento> listEntitytoListDTO(List<EstabelecimentoModel> estabelecimentos);
}
