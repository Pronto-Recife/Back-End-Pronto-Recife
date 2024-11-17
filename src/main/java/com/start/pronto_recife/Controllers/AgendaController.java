package com.start.pronto_recife.Controllers;

import com.start.pronto_recife.DTOs.DTOAgenda;
import com.start.pronto_recife.DTOs.DTOMedico;
import com.start.pronto_recife.Mapper.AgendaMapper;
import com.start.pronto_recife.Repositories.AgendaRepository;
import com.start.pronto_recife.Repositories.MedicoRepository;
import com.start.pronto_recife.Service.AgendaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AgendaController {
    private final AgendaRepository agendaRepository;
    private final AgendaMapper agendaMapper;
    private final AgendaService agendaService;

    @PostMapping("/agenda")
    public ResponseEntity<DTOAgenda> saveAgenda(@RequestBody @Valid DTOAgenda dtoAgenda){
        return ResponseEntity.status(HttpStatus.CREATED).body(agendaService.createAgenda(dtoAgenda));
    }

}
