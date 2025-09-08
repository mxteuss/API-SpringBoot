package dev.java.CadastroNinja.Missoes.controller;

import dev.java.CadastroNinja.Missoes.model.Missoes;
import dev.java.CadastroNinja.Missoes.service.MissoesService;
import lombok.AllArgsConstructor;


import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public UUID findById(@PathVariable UUID id){
        missoesService.findById(id);
        return id;
    }

    @PostMapping("/missoes")
    public Missoes create(Missoes missoes){
    return missoesService.create(missoes);
    }
    @DeleteMapping("/missoes/{id}")
    public String deleteById(@PathVariable UUID id){
        missoesService.deleteById(id);
        return "ID:" + id + "deletado com sucesso!";
    }
    @PutMapping("/missoes/{id}")
    public Missoes update(@PathVariable UUID id, @RequestBody Missoes missoesAtualizada){
        Missoes missoes = missoesService.findById(id);
        missoes.setName(missoesAtualizada.getName());
        missoes.setId(missoesAtualizada.getId());
        missoes.setDescricao(missoesAtualizada.getDescricao());
        missoes.setDif(missoesAtualizada.getDif());
        missoes.setNinjaModel(missoesAtualizada.getNinjaModel());

        return missoes;
    }
}
