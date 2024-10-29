package com.start.pronto_recife.Mapper;

import com.start.pronto_recife.DTOs.DTOPaciente;
import com.start.pronto_recife.Models.PacienteModel;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-29T11:38:50-0300",
    comments = "version: 1.6.2, compiler: javac, environment: Java 22.0.2 (Amazon.com Inc.)"
)
@Component
public class PacienteMapperImpl implements PacienteMapper {

    @Override
    public PacienteModel toModel(DTOPaciente dtoPaciente) {
        if ( dtoPaciente == null ) {
            return null;
        }

        PacienteModel pacienteModel = new PacienteModel();

        pacienteModel.setCPF( dtoPaciente.CPF() );
        pacienteModel.setNome_completo( dtoPaciente.nome_completo() );
        pacienteModel.setData_nascimento( dtoPaciente.data_nascimento() );
        pacienteModel.setGenero( dtoPaciente.genero() );
        pacienteModel.setEmail( dtoPaciente.email() );
        pacienteModel.setTelefone( dtoPaciente.telefone() );
        pacienteModel.setContato_representante( dtoPaciente.contato_representante() );
        pacienteModel.setCep( dtoPaciente.cep() );
        pacienteModel.setResponsavel_CPF( dtoPaciente.responsavel_CPF() );

        return pacienteModel;
    }

    @Override
    public DTOPaciente toDTO(PacienteModel pacienteModel) {
        if ( pacienteModel == null ) {
            return null;
        }

        String cPF = null;
        String nome_completo = null;
        LocalDate data_nascimento = null;
        String genero = null;
        String email = null;
        String telefone = null;
        String contato_representante = null;
        String cep = null;
        String responsavel_CPF = null;

        cPF = pacienteModel.getCPF();
        nome_completo = pacienteModel.getNome_completo();
        data_nascimento = pacienteModel.getData_nascimento();
        genero = pacienteModel.getGenero();
        email = pacienteModel.getEmail();
        telefone = pacienteModel.getTelefone();
        contato_representante = pacienteModel.getContato_representante();
        cep = pacienteModel.getCep();
        responsavel_CPF = pacienteModel.getResponsavel_CPF();

        String endereço = null;

        DTOPaciente dTOPaciente = new DTOPaciente( cPF, nome_completo, data_nascimento, genero, email, telefone, contato_representante, cep, endereço, responsavel_CPF );

        return dTOPaciente;
    }
}
