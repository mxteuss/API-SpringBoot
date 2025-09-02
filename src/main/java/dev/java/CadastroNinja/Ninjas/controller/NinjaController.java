package dev.java.CadastroNinja.Ninjas.controller;

import dev.java.CadastroNinja.Ninjas.model.NinjaModel;
import dev.java.CadastroNinja.Ninjas.service.NinjaService;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping
@AllArgsConstructor
public class NinjaController {
    private final NinjaService ninjaService;

    @GetMapping("/ninjas")
    public ResponseEntity<Page<NinjaModel>> findAll(
            @RequestParam(defaultValue = "0") int pageNO,
            @RequestParam(defaultValue = "10") int pageSize) {
        Page<NinjaModel> ninjas = ninjaService.findAll(pageNO, pageSize);
        return ResponseEntity.ok(ninjas);
    }

     @PostMapping("/ninjas")
    public NinjaModel save(NinjaModel ninjaModel){
        return ninjaService.save(ninjaModel);
    }
    @PutMapping("/ninjas/{id}")
    public NinjaModel update(@PathVariable @NotNull UUID id, NinjaModel ninja){
        NinjaModel ninjaModel = ninjaService.update(id);
        ninja.setId(ninjaModel.getId());
        ninja.setNome(ninjaModel.getNome());
        ninja.setIdade(ninjaModel.getIdade());
        ninja.setMissoes(ninjaModel.getMissoes());

        return ninja;
    }
    @DeleteMapping("/ninjas/{id}")
    public String deleteById(@PathVariable @NotNull UUID id){
        ninjaService.deleteById(id);
        return "Id: " + id + ". deletado com sucesso!";
    }
    @GetMapping("/ninjas/{id}")
    public NinjaModel findById(@PathVariable @NotNull UUID id){
        return ninjaService.findById(id);
    }

}

