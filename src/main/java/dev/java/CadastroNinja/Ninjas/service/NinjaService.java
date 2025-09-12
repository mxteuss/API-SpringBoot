package dev.java.CadastroNinja.Ninjas.service;


import dev.java.CadastroNinja.Missoes.mapper.MissoesMapper;
import dev.java.CadastroNinja.Ninjas.dto.NinjaDTO;
import dev.java.CadastroNinja.Ninjas.mapper.NinjaMapper;
import dev.java.CadastroNinja.Ninjas.model.NinjaModel;
import dev.java.CadastroNinja.Ninjas.repository.NinjaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service

public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;
    private MissoesMapper missoesMapper;


    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper, MissoesMapper missoesMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
        this.missoesMapper = missoesMapper;
    }

    public Page<NinjaDTO> findAll(int pageNO, int pageSize){
        Pageable pageable = PageRequest.of(pageNO, pageSize);
        Page<NinjaModel> page = ninjaRepository.findAll(pageable);
        return  page.map(ninjaMapper::toDTO);
    }
    public NinjaDTO findById(Long id){
        NinjaModel ninjaModel = ninjaRepository.findById(id)
                .orElseThrow(() ->  new RuntimeException("Id não encontrado"));
        return ninjaMapper.toDTO(ninjaModel);
    }
    public NinjaDTO save(NinjaDTO ninja){
        NinjaDTO dto = new NinjaDTO();
        if (ninja.getId() != null && ninjaRepository.existsById(ninja.getId())){
            throw new IllegalArgumentException("Ninja não encontrado!");
        }
        return dto;
    }

    public NinjaDTO update(Long id) {
        NinjaDTO dto = new NinjaDTO();
        NinjaModel ninja = ninjaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ninja não encontrado!"));
        dto.setId(ninja.getId());
        dto.setNome(ninja.getNome());
        dto.setIdade(ninja.getIdade());
        dto.setMissoes(missoesMapper.toDTO(ninja.getMissoes()));

        return dto;
    }
    public void deleteById(Long id){
        ninjaRepository.deleteById(id);
    }
}
