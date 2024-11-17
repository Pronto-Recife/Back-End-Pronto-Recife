package com.start.pronto_recife.Controllers;

import com.start.pronto_recife.DTOs.DTOHistorico;
import com.start.pronto_recife.Service.HistoricoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("historico")
@RequiredArgsConstructor
public class HistoricoController {
    private final HistoricoService historicoService;

    @GetMapping("/historico")
    public ResponseEntity<List<DTOHistorico>> findAll(){
        List<DTOHistorico> listHistorico = historicoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listHistorico);
    }
    @PostMapping("/historico")
    public ResponseEntity<DTOHistorico> createHistorico(@RequestBody @Valid DTOHistorico dtoHistorico){
        DTOHistorico createdHistorico = historicoService.createHistorico(dtoHistorico);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHistorico);
    }
}