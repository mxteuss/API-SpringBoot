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

    @DeleteMapping("/ninjas/{id}")
    public String deleteById(@PathVariable @NotNull UUID id){
        ninjaService.deleteById(id);
        return "Id: " + id + ". deletado com sucesso!";
    }

}

