package dev.java.CadastroNinja.Missoes.service;

import dev.java.CadastroNinja.Missoes.dto.MissoesDTO;
import dev.java.CadastroNinja.Missoes.mapper.MissoesMapper;
import dev.java.CadastroNinja.Missoes.model.Missoes;
import dev.java.CadastroNinja.Missoes.repository.MissoesRepository;
import dev.java.CadastroNinja.Ninjas.mapper.NinjaMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service


public class MissoesService {
    @Autowired
    private final MissoesRepository missoesRepository;
    private NinjaMapper ninjaMapper;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, NinjaMapper ninjaMapper, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.ninjaMapper = ninjaMapper;
        this.missoesMapper = missoesMapper;
    }

    public Page<MissoesDTO> findAll(int pageNO, int pageSize){
        Pageable pageable = PageRequest.of(pageNO, pageSize);
        Page<Missoes> missoesPage = missoesRepository.findAll(pageable);
        return missoesPage.map(missoes -> missoesMapper.toDTO(missoes));
    }

    public MissoesDTO save(Missoes missoes){
        if (missoes.getId() != null && missoesRepository.existsById(missoes.getId())){
            throw new IllegalArgumentException("Missão já existente com esse ID");
        }
         Missoes missoes1 =  missoesRepository.save(missoes);
        return missoesMapper.toDTO(missoes1);
    }
    public void deleteById(Long id){
        missoesRepository.deleteById(id);
    }
    public MissoesDTO findById(Long id){
        Missoes missoes = missoesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID não encontrado"));
       return missoesMapper.toDTO(missoes);
    }
    public MissoesDTO update(Long id){
        Missoes missoes = missoesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Missão não encontrada"));

        return missoesMapper.toDTO(missoes);
    }
}
