package dev.java.CadastroNinja.Missoes.mapper;

import dev.java.CadastroNinja.Missoes.dto.MissoesDTO;
import dev.java.CadastroNinja.Missoes.model.Missoes;
import dev.java.CadastroNinja.Ninjas.mapper.NinjaMapper;
import org.mapstruct.Mapper;
import org.postgresql.ssl.MakeSSL;

import java.util.List;

@Mapper(componentModel = "spring", uses = {NinjaMapper.class})
public interface MissoesMapper {
    MissoesDTO toDTO(Missoes missoes);
    Missoes toModel(MissoesDTO dto);
    List<Missoes> toDTOList(List<MissoesDTO> dtoList);
    List<MissoesDTO> toModelList(List<Missoes> modelList);
}
