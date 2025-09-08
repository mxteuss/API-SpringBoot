package dev.java.CadastroNinja.Missoes.controller;

import dev.java.CadastroNinja.Missoes.model.Missoes;
import dev.java.CadastroNinja.Missoes.service.MissoesService;
import lombok.AllArgsConstructor;


import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping
@AllArgsConstructor
public class MissoesController {
    private final MissoesService missoesService;

    @GetMapping("/missoes")
    public ResponseEntity<Page<Missoes>> getMissoes(
            @RequestParam (defaultValue = "0") int pageNo,
            @RequestParam (defaultValue =  "10") int pageSize){
        Page<Missoes> missoesPage = missoesService.findAll(pageNo, pageSize);
        return ResponseEntity.ok(missoesPage);
    }

    @GetMapping("/missoes/{id}")
    public ResponseEntity<UUID> findById(@PathVariable  UUID id){
        missoesService.findById(id);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/missoes/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id){
        missoesService.deleteById(id);
        return ResponseEntity.noContent().build(); // 204
    }
    @PostMapping("/missoes")
    public ResponseEntity<Missoes> create(@RequestBody Missoes missoes){
        Missoes missoes1 = missoesService.create(missoes);
        URI location = URI.create("/missoes/" + missoes1.getId());
        return ResponseEntity.created(location).body(missoes1); //201
    }

    @PutMapping("/missoes/{id}")
    public ResponseEntity<Missoes> update(@PathVariable UUID id, @RequestBody Missoes missoesAtualizada){
        Missoes missoes = missoesService.findById(id);
        missoes.setName(missoesAtualizada.getName());
        missoes.setId(missoesAtualizada.getId());
        missoes.setDescricao(missoesAtualizada.getDescricao());
        missoes.setDif(missoesAtualizada.getDif());
        missoes.setNinjaModel(missoesAtualizada.getNinjaModel());
        URI location = URI.create("/missoes/" + missoes.getId());

        return ResponseEntity.created(location).body(missoes);
    }
}
