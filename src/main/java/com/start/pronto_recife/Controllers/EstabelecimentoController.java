package com.start.pronto_recife.Controllers;

import com.start.pronto_recife.DTOs.DTOEstabelecimento;
import com.start.pronto_recife.Service.EstabelecimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("estabelecimento")
public class EstabelecimentoController {
    private final EstabelecimentoService estabelecimentoService;

    @PostMapping("/register")
    public ResponseEntity<DTOEstabelecimento> registerEstabelecimento(@RequestBody DTOEstabelecimento dtoEstabelecimento){
        return ResponseEntity.status(HttpStatus.CREATED).body(estabelecimentoService.createEstabelecimento(dtoEstabelecimento));
    }
    @GetMapping("/all")
    public ResponseEntity<List<DTOEstabelecimento>> getAllEstabelecimentos(){
        return ResponseEntity.status(HttpStatus.OK).body(estabelecimentoService.findAll());
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<DTOEstabelecimento> getEstabelecimento(@PathVariable(value = "id")String id){
        DTOEstabelecimento estabelecimento = estabelecimentoService.findById(id);
        return ResponseEntity.ok().body(estabelecimento);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEstabelecimento(@PathVariable String id){
        estabelecimentoService.deleteEstabelecimento(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
