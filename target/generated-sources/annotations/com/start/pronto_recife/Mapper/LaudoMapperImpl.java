package com.start.pronto_recife.Mapper;

import com.start.pronto_recife.DTOs.DTOLaudo;
import com.start.pronto_recife.Models.LaudoModel;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-15T17:29:46-0300",
    comments = "version: 1.6.2, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class LaudoMapperImpl implements LaudoMapper {

    @Override
    public DTOLaudo toDTO(LaudoModel laudoModel) {
        if ( laudoModel == null ) {
            return null;
        }

        UUID id = null;
        String descricao = null;

        id = laudoModel.getId();
        descricao = laudoModel.getDescricao();

        DTOLaudo dTOLaudo = new DTOLaudo( id, descricao );

        return dTOLaudo;
    }

    @Override
    public LaudoModel toModel(DTOLaudo dtoLaudo) {
        if ( dtoLaudo == null ) {
            return null;
        }

        LaudoModel laudoModel = new LaudoModel();

        laudoModel.setId( dtoLaudo.id() );
        laudoModel.setDescricao( dtoLaudo.descricao() );

        return laudoModel;
    }

    @Override
    public List<DTOLaudo> listEntitytoListDTO(List<LaudoModel> laudos) {
        if ( laudos == null ) {
            return null;
        }

        List<DTOLaudo> list = new ArrayList<DTOLaudo>( laudos.size() );
        for ( LaudoModel laudoModel : laudos ) {
            list.add( toDTO( laudoModel ) );
        }

        return list;
    }
}
