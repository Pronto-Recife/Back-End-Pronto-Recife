package com.start.pronto_recife.Mapper;

import com.start.pronto_recife.DTOs.DTOResponsavel;
import com.start.pronto_recife.Models.ResponsavelModel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-15T17:29:47-0300",
    comments = "version: 1.6.2, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class ResponsavelMapperImpl implements ResponsavelMapper {

    @Override
    public DTOResponsavel toDTO(ResponsavelModel responsavelModel) {
        if ( responsavelModel == null ) {
            return null;
        }

        LocalDate dataNascimento = null;
        String nomeCompleto = null;
        String grauParentesco = null;
        String telefone = null;
        String email = null;
        String genero = null;

        dataNascimento = responsavelModel.getDataNascimento();
        nomeCompleto = responsavelModel.getNomeCompleto();
        grauParentesco = responsavelModel.getGrauParentesco();
        telefone = responsavelModel.getTelefone();
        email = responsavelModel.getEmail();
        genero = responsavelModel.getGenero();

        DTOResponsavel dTOResponsavel = new DTOResponsavel( nomeCompleto, grauParentesco, dataNascimento, telefone, email, genero );

        return dTOResponsavel;
    }

    @Override
    public ResponsavelModel toModel(DTOResponsavel dtoresponsavel) {
        if ( dtoresponsavel == null ) {
            return null;
        }

        ResponsavelModel responsavelModel = new ResponsavelModel();

        responsavelModel.setDataNascimento( dtoresponsavel.dataNascimento() );
        responsavelModel.setNomeCompleto( dtoresponsavel.nomeCompleto() );
        responsavelModel.setGrauParentesco( dtoresponsavel.grauParentesco() );
        responsavelModel.setTelefone( dtoresponsavel.telefone() );
        responsavelModel.setEmail( dtoresponsavel.email() );
        responsavelModel.setGenero( dtoresponsavel.genero() );

        return responsavelModel;
    }

    @Override
    public List<DTOResponsavel> listEntitytoListDTO(List<ResponsavelModel> responsavel) {
        if ( responsavel == null ) {
            return null;
        }

        List<DTOResponsavel> list = new ArrayList<DTOResponsavel>( responsavel.size() );
        for ( ResponsavelModel responsavelModel : responsavel ) {
            list.add( toDTO( responsavelModel ) );
        }

        return list;
    }
}
