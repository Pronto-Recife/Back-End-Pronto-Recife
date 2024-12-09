package com.start.pronto_recife.Controllers;

import com.start.pronto_recife.DTOs.DTOConsulta;
import com.start.pronto_recife.DTOs.DTOHistorico;
import com.start.pronto_recife.DTOs.DTOHistoricoRequest;
import com.start.pronto_recife.Service.HistoricoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("historico")
public class HistoricoController {
    private final HistoricoService historicoService;

    @GetMapping("/findAll")
    public ResponseEntity<List<DTOHistorico>> findAll(){
        List<DTOHistorico> listHistorico = historicoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listHistorico);
    }
    @PostMapping("/create")
    public ResponseEntity<DTOHistorico> createHistorico(@RequestBody @Valid DTOHistoricoRequest dtoHistorico){
        DTOHistorico createdHistorico = historicoService.createHistorico(dtoHistorico);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHistorico);
    }
    @GetMapping("/paciente/{id}/historico")
    public ResponseEntity<List<DTOHistorico>> buscarHist(@PathVariable String id) {
        List<DTOHistorico> historico = historicoService.buscarHistorico(id);
        return historico.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(historico);
    }
}