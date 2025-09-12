package dev.java.CadastroNinja.Ninjas.controller;

import dev.java.CadastroNinja.Ninjas.dto.NinjaDTO;
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

public class NinjaController {
    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/ninjas")
    public ResponseEntity<Page<NinjaDTO>> findAll(
            @RequestParam(defaultValue = "0") int pageNO,
            @RequestParam(defaultValue = "10") int pageSize) {
        Page<NinjaDTO> ninjas = ninjaService.findAll(pageNO, pageSize);
        return ResponseEntity.ok(ninjas);
    }

     @PostMapping("/ninjas")
    public NinjaDTO save(NinjaDTO ninja){
        return ninjaService.save(ninja);
    }
    @PutMapping("/ninjas/{id}")
    public NinjaDTO update(@PathVariable @NotNull Long id, NinjaDTO ninja){
        return ninjaService.update(id);
    }
    @DeleteMapping("/ninjas/{id}")
    public void deleteById(@PathVariable @NotNull Long id){
        ninjaService.deleteById(id);
    }
    @GetMapping("/ninjas/{id}")
    public NinjaDTO findById(@PathVariable @NotNull Long id){
        return ninjaService.findById(id);
    }

}

