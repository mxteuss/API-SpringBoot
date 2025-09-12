package dev.java.CadastroNinja.Ninjas.mapper;

import dev.java.CadastroNinja.Missoes.mapper.MissoesMapper;
import dev.java.CadastroNinja.Ninjas.dto.NinjaDTO;
import dev.java.CadastroNinja.Ninjas.model.NinjaModel;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring", uses = {MissoesMapper.class})

public interface NinjaMapper {
    NinjaDTO toDTO(NinjaModel ninjaModel);

    NinjaModel toModel(NinjaDTO dto);
    List<NinjaDTO> toDTOList(List<NinjaModel> modelList);
    List<NinjaModel> toModelList(List<NinjaDTO> dtoList);

}
