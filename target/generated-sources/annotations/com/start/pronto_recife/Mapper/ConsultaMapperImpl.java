package com.start.pronto_recife.Mapper;

import com.start.pronto_recife.DTOs.DTOConsulta;
import com.start.pronto_recife.Models.ConsultaModel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-09T19:42:50-0300",
    comments = "version: 1.6.2, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class ConsultaMapperImpl implements ConsultaMapper {

    @Override
    public ConsultaModel toModel(DTOConsulta dtoconsulta) {
        if ( dtoconsulta == null ) {
            return null;
        }

        ConsultaModel consultaModel = new ConsultaModel();

        consultaModel.setId( dtoconsulta.id() );
        consultaModel.setData_consulta( dtoconsulta.data_consulta() );
        consultaModel.setTratamentos_prescritos( dtoconsulta.tratamentos_prescritos() );
        consultaModel.setInstrucoes_recomendacoes( dtoconsulta.instrucoes_recomendacoes() );
        consultaModel.setSintomas( dtoconsulta.sintomas() );
        consultaModel.setHistorico_familiar( dtoconsulta.historico_familiar() );

        return consultaModel;
    }

    @Override
    public DTOConsulta toDTO(ConsultaModel consultaModel) {
        if ( consultaModel == null ) {
            return null;
        }

        UUID id = null;
        LocalDate data_consulta = null;
        String tratamentos_prescritos = null;
        String instrucoes_recomendacoes = null;
        String sintomas = null;
        String historico_familiar = null;

        id = consultaModel.getId();
        data_consulta = consultaModel.getData_consulta();
        tratamentos_prescritos = consultaModel.getTratamentos_prescritos();
        instrucoes_recomendacoes = consultaModel.getInstrucoes_recomendacoes();
        sintomas = consultaModel.getSintomas();
        historico_familiar = consultaModel.getHistorico_familiar();

        DTOConsulta dTOConsulta = new DTOConsulta( id, data_consulta, tratamentos_prescritos, instrucoes_recomendacoes, sintomas, historico_familiar );

        return dTOConsulta;
    }

    @Override
    public List<DTOConsulta> listModeltoListDTO(List<ConsultaModel> consultas) {
        if ( consultas == null ) {
            return null;
        }

        List<DTOConsulta> list = new ArrayList<DTOConsulta>( consultas.size() );
        for ( ConsultaModel consultaModel : consultas ) {
            list.add( toDTO( consultaModel ) );
        }

        return list;
    }
}
