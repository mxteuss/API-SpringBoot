package dev.java.CadastroNinja.Missoes.controller;

import dev.java.CadastroNinja.Missoes.dto.MissoesDTO;
import dev.java.CadastroNinja.Missoes.model.Missoes;
import dev.java.CadastroNinja.Missoes.service.MissoesService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
public class MissoesController {

    @Autowired
    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

        @GetMapping("/missoes")
        public ResponseEntity<Page<MissoesDTO>> getMissoes(
                @RequestParam (defaultValue = "0") int pageNo,
                @RequestParam (defaultValue =  "10") int pageSize){
            Page<MissoesDTO> missoesPage = missoesService.findAll(pageNo, pageSize);
            return ResponseEntity.ok(missoesPage);
        }

    @GetMapping("/missoes/{id}")
    public ResponseEntity<Long> findById(@Valid @PathVariable Long id){
        missoesService.findById(id);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/missoes/{id}")
    public ResponseEntity<Void> deleteById(@Valid @PathVariable Long id){
        missoesService.deleteById(id);
        return ResponseEntity.noContent().build(); // 204
    }
    @PostMapping("/missoes")
    public ResponseEntity<MissoesDTO> save( @RequestBody Missoes missoes){
        MissoesDTO dto = missoesService.save(missoes);
        URI location = URI.create("/missoes/" + missoes.getId());
        return ResponseEntity.created(location).body(dto); //201
    }

    @PutMapping("/missoes/{id}")
    public ResponseEntity<MissoesDTO> update(@Valid @PathVariable Long id, @RequestBody MissoesDTO dto){
        MissoesDTO missoes = missoesService.findById(id);
        URI location = URI.create("/missoes/" + missoes.getId());
        return ResponseEntity.created(location).body(missoes);
    }
}
