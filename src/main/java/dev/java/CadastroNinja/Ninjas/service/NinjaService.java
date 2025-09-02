package dev.java.CadastroNinja.Ninjas.service;

import dev.java.CadastroNinja.Ninjas.model.NinjaModel;
import dev.java.CadastroNinja.Ninjas.repository.NinjaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class NinjaService {
    private final NinjaRepository ninjaRepository;

    public Page<NinjaModel> findAll(int pageNO, int pageSize){
        Pageable pageable = PageRequest.of(pageNO, pageSize);
        return ninjaRepository.findAll(pageable);
    }

    public NinjaModel save(NinjaModel ninjaModel){
        return ninjaRepository.save(ninjaModel);
    }

    public String deleteById( UUID id){
        ninjaRepository.deleteById(id);
        return "Id: " + id + ". sucessfull delete!";
    }
}
