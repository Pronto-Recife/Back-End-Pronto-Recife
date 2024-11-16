package com.start.pronto_recife.Mapper;

import com.start.pronto_recife.DTOs.DTOEstabelecimento;
import com.start.pronto_recife.Models.EstabelecimentoModel;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-14T18:05:59-0300",
    comments = "version: 1.6.2, compiler: javac, environment: Java 22.0.2 (Amazon.com Inc.)"
)
@Component
public class EstabelecimentoMapperImpl implements EstabelecimentoMapper {

    @Override
    public EstabelecimentoModel toModel(DTOEstabelecimento dtoEstabelecimento) {
        if ( dtoEstabelecimento == null ) {
            return null;
        }

        EstabelecimentoModel estabelecimentoModel = new EstabelecimentoModel();

        estabelecimentoModel.setId( dtoEstabelecimento.id() );
        estabelecimentoModel.setNome( dtoEstabelecimento.nome() );
        estabelecimentoModel.setEndereco( dtoEstabelecimento.endereco() );
        estabelecimentoModel.setTelefone( dtoEstabelecimento.telefone() );
        estabelecimentoModel.setEmail( dtoEstabelecimento.email() );

        return estabelecimentoModel;
    }

    @Override
    public DTOEstabelecimento toDTO(EstabelecimentoModel estabelecimentoModel) {
        if ( estabelecimentoModel == null ) {
            return null;
        }

        UUID id = null;
        String nome = null;
        String endereco = null;
        String telefone = null;
        String email = null;

        id = estabelecimentoModel.getId();
        nome = estabelecimentoModel.getNome();
        endereco = estabelecimentoModel.getEndereco();
        telefone = estabelecimentoModel.getTelefone();
        email = estabelecimentoModel.getEmail();

        DTOEstabelecimento dTOEstabelecimento = new DTOEstabelecimento( id, nome, endereco, telefone, email );

        return dTOEstabelecimento;
    }

    @Override
    public List<DTOEstabelecimento> listEntitytoListDTO(List<EstabelecimentoModel> estabelecimentos) {
        if ( estabelecimentos == null ) {
            return null;
        }

        List<DTOEstabelecimento> list = new ArrayList<DTOEstabelecimento>( estabelecimentos.size() );
        for ( EstabelecimentoModel estabelecimentoModel : estabelecimentos ) {
            list.add( toDTO( estabelecimentoModel ) );
        }

        return list;
    }
}
