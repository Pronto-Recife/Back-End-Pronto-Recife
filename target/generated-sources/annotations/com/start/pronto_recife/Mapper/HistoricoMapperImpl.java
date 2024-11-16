package com.start.pronto_recife.Mapper;

import com.start.pronto_recife.DTOs.DTOHistorico;
import com.start.pronto_recife.Models.HistoricoModel;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-16T20:08:25-0300",
    comments = "version: 1.6.2, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class HistoricoMapperImpl implements HistoricoMapper {

    @Override
    public HistoricoModel toModel(DTOHistorico dtoHistorico) {
        if ( dtoHistorico == null ) {
            return null;
        }

        HistoricoModel historicoModel = new HistoricoModel();

        historicoModel.setId( dtoHistorico.id() );
        historicoModel.setCirurgias_anteriores( dtoHistorico.cirurgias_anteriores() );
        historicoModel.setCondicoes_gerais( dtoHistorico.condicoes_gerais() );

        return historicoModel;
    }

    @Override
    public DTOHistorico toDTO(HistoricoModel historicoModel) {
        if ( historicoModel == null ) {
            return null;
        }

        UUID id = null;
        String cirurgias_anteriores = null;
        String condicoes_gerais = null;

        id = historicoModel.getId();
        cirurgias_anteriores = historicoModel.getCirurgias_anteriores();
        condicoes_gerais = historicoModel.getCondicoes_gerais();

        DTOHistorico dTOHistorico = new DTOHistorico( id, cirurgias_anteriores, condicoes_gerais );

        return dTOHistorico;
    }

    @Override
    public List<DTOHistorico> toListDto(List<HistoricoModel> historicoModel) {
        if ( historicoModel == null ) {
            return null;
        }

        List<DTOHistorico> list = new ArrayList<DTOHistorico>( historicoModel.size() );
        for ( HistoricoModel historicoModel1 : historicoModel ) {
            list.add( toDTO( historicoModel1 ) );
        }

        return list;
    }
}
