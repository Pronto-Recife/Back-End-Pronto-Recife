package com.start.pronto_recife.Mapper;

import com.start.pronto_recife.DTOs.DTOMedico;
import com.start.pronto_recife.Models.MedicoModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-07T16:33:38-0300",
    comments = "version: 1.6.2, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class MedicoMapperImpl implements MedicoMapper {

    @Override
    public MedicoModel toModel(DTOMedico dtoMedico) {
        if ( dtoMedico == null ) {
            return null;
        }

        MedicoModel medicoModel = new MedicoModel();

        medicoModel.setCRM( dtoMedico.CRM() );
        medicoModel.setNome_completo( dtoMedico.nome_completo() );
        medicoModel.setEspecialidade( dtoMedico.especialidade() );
        medicoModel.setTelefone( dtoMedico.telefone() );
        medicoModel.setEmail( dtoMedico.email() );

        return medicoModel;
    }

    @Override
    public DTOMedico toDTO(MedicoModel medicoModel) {
        if ( medicoModel == null ) {
            return null;
        }

        String cRM = null;
        String nome_completo = null;
        String especialidade = null;
        String telefone = null;
        String email = null;

        cRM = medicoModel.getCRM();
        nome_completo = medicoModel.getNome_completo();
        especialidade = medicoModel.getEspecialidade();
        telefone = medicoModel.getTelefone();
        email = medicoModel.getEmail();

        DTOMedico dTOMedico = new DTOMedico( cRM, nome_completo, especialidade, telefone, email );

        return dTOMedico;
    }

    @Override
    public List<DTOMedico> listEntitytoListDTO(List<MedicoModel> medicos) {
        if ( medicos == null ) {
            return null;
        }

        List<DTOMedico> list = new ArrayList<DTOMedico>( medicos.size() );
        for ( MedicoModel medicoModel : medicos ) {
            list.add( toDTO( medicoModel ) );
        }

        return list;
    }
}
