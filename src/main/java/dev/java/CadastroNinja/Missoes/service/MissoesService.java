package dev.java.CadastroNinja.Missoes.service;

import dev.java.CadastroNinja.Missoes.model.Missoes;
import dev.java.CadastroNinja.Missoes.repository.MissoesRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor

public class MissoesService {
    private final MissoesRepository missoesRepository;

    public Page<Missoes> findAll(int pageNO, int pageSize){
        Pageable pageable = PageRequest.of(pageNO, pageSize);
        return missoesRepository.findAll(pageable);
    }
    public  Missoes create(Missoes missoes){
        return missoesRepository.save(missoes);
    }
    public String deleteById(UUID id){
        missoesRepository.deleteById(id);
        return "ID:" + id + "sucessfull delete";
    }
    public Missoes findById(UUID id){
        missoesRepository.findById(id);
       return (Missoes) missoesRepository;
    }
    public Missoes update( UUID id, Missoes missoesAtualizada){
        Missoes missoes = missoesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Missão não encontrada"));
        return missoes;
    }
}
