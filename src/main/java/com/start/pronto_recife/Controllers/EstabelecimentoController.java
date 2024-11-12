package com.start.pronto_recife.Controllers;

import com.start.pronto_recife.DTOs.DTOEstabelecimento;
import com.start.pronto_recife.Service.EstabelecimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("estabelecimento")
@RequiredArgsConstructor
public class EstabelecimentoController {
    private final EstabelecimentoService estabelecimentoService;

    @PostMapping("/register")
    public ResponseEntity<DTOEstabelecimento> registerEstabelecimento(@RequestBody DTOEstabelecimento dtoEstabelecimento){
        return ResponseEntity.status(HttpStatus.CREATED).body(estabelecimentoService.createEstabelecimento(dtoEstabelecimento));
    }
}
