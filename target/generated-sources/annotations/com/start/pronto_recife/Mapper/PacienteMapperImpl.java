package com.start.pronto_recife.Mapper;

import com.start.pronto_recife.DTOs.DTOPaciente;
import com.start.pronto_recife.Models.PacienteModel;
import java.time.LocalDate;
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
public class PacienteMapperImpl implements PacienteMapper {

    @Override
    public PacienteModel toModel(DTOPaciente dtoPaciente) {
        if ( dtoPaciente == null ) {
            return null;
        }

        PacienteModel pacienteModel = new PacienteModel();

        pacienteModel.setId( dtoPaciente.id() );
        pacienteModel.setCPF( dtoPaciente.CPF() );
        pacienteModel.setNome_completo( dtoPaciente.nome_completo() );
        pacienteModel.setData_nascimento( dtoPaciente.data_nascimento() );
        pacienteModel.setGenero( dtoPaciente.genero() );
        pacienteModel.setEmail( dtoPaciente.email() );
        pacienteModel.setTelefone( dtoPaciente.telefone() );
        pacienteModel.setContato_representante( dtoPaciente.contato_representante() );
        pacienteModel.setCep( dtoPaciente.cep() );
        pacienteModel.setEndereco( dtoPaciente.endereco() );

        return pacienteModel;
    }

    @Override
    public DTOPaciente toDTO(PacienteModel pacienteModel) {
        if ( pacienteModel == null ) {
            return null;
        }

        UUID id = null;
        String cPF = null;
        String nome_completo = null;
        LocalDate data_nascimento = null;
        String genero = null;
        String email = null;
        String telefone = null;
        String contato_representante = null;
        String cep = null;
        String endereco = null;

        id = pacienteModel.getId();
        cPF = pacienteModel.getCPF();
        nome_completo = pacienteModel.getNome_completo();
        data_nascimento = pacienteModel.getData_nascimento();
        genero = pacienteModel.getGenero();
        email = pacienteModel.getEmail();
        telefone = pacienteModel.getTelefone();
        contato_representante = pacienteModel.getContato_representante();
        cep = pacienteModel.getCep();
        endereco = pacienteModel.getEndereco();

        String responsavel_CPF = null;

        DTOPaciente dTOPaciente = new DTOPaciente( id, cPF, nome_completo, data_nascimento, genero, email, telefone, contato_representante, cep, endereco, responsavel_CPF );

        return dTOPaciente;
    }

    @Override
    public List<DTOPaciente> listEntitytoListDTO(List<PacienteModel> pacientes) {
        if ( pacientes == null ) {
            return null;
        }

        List<DTOPaciente> list = new ArrayList<DTOPaciente>( pacientes.size() );
        for ( PacienteModel pacienteModel : pacientes ) {
            list.add( toDTO( pacienteModel ) );
        }

        return list;
    }
}
