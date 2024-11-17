package com.start.pronto_recife.Controllers;

import com.start.pronto_recife.DTOs.DTOLaudo;
import com.start.pronto_recife.Service.LaudoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController("laudo")
@RequiredArgsConstructor
public class LaudoController {
    private final LaudoService laudoService;
    // GET controller
    @GetMapping("/laudo")
    public ResponseEntity<List<DTOLaudo>> getAllLaudos(){
        return ResponseEntity.status(HttpStatus.OK).body(laudoService.findAll());
    }
    // PUT controller
    @PutMapping("/laudo/{id}")
    public ResponseEntity<DTOLaudo> updateLaudo(@PathVariable String id, @RequestBody @Valid DTOLaudo dtoLaudo){
        DTOLaudo laudo = laudoService.updateLaudo(id, dtoLaudo);
        return ResponseEntity.status(HttpStatus.OK).body(laudo);
    }
    // POST controller
    @PostMapping("/laudo")
    public ResponseEntity<DTOLaudo> saveLaudo(@RequestBody DTOLaudo dtoLaudo){
        return ResponseEntity.status(HttpStatus.CREATED).body(laudoService.createLaudo(dtoLaudo));
    }
}
