package com.start.pronto_recife.Mapper;

import com.start.pronto_recife.DTOs.DTOHistorico;
import com.start.pronto_recife.Models.HistoricoModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-17T20:23:04-0300",
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

        historicoModel.setCirurgias_anteriores( dtoHistorico.cirurgias_anteriores() );
        historicoModel.setCondicoes_gerais( dtoHistorico.condicoes_gerais() );
        historicoModel.setPaciente_id( dtoHistorico.paciente_id() );

        return historicoModel;
    }

    @Override
    public DTOHistorico toDTO(HistoricoModel historicoModel) {
        if ( historicoModel == null ) {
            return null;
        }

        String cirurgias_anteriores = null;
        String condicoes_gerais = null;
        String paciente_id = null;

        cirurgias_anteriores = historicoModel.getCirurgias_anteriores();
        condicoes_gerais = historicoModel.getCondicoes_gerais();
        paciente_id = historicoModel.getPaciente_id();

        DTOHistorico dTOHistorico = new DTOHistorico( cirurgias_anteriores, condicoes_gerais, paciente_id );

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
