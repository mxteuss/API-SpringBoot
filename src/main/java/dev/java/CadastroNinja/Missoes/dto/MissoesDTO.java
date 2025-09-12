package dev.java.CadastroNinja.Missoes.dto;

import dev.java.CadastroNinja.Ninjas.dto.NinjaDTO;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
public class MissoesDTO {
    @NotNull(message = "O id não pode ser nulo")
    private Long id;
    @NotBlank(message = "O nome não pode estar em branco")
    @Size(min = 0, max = 50)
    private String name;
    @Pattern(regexp = "DCBAS")
    @NotBlank(message = "A missão deve ter dificuldade")
    private String dif;
    @NotBlank(message = "A descrição não pode estar vazia")
    private String descricao;
    @NotBlank(message = "A missão deve ter ninjas")
    private List<NinjaDTO> ninjas;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDif() {
        return dif;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<NinjaDTO> getNinjas() {
        return ninjas;
    }
}
