package dev.java.CadastroNinja.Ninjas.dto;

import dev.java.CadastroNinja.Missoes.dto.MissoesDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Data
@ToString
@EqualsAndHashCode
public class NinjaDTO {

    @NotNull(message = "O id não pode ser nulo")
    private Long id;
    @NotBlank(message = "O nome não pode estar em branco")
    @Size(min = 0, max = 50)
    private String nome;
    @Size(min = 13, max = 100)
    private Integer idade;
    private MissoesDTO missoes;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public MissoesDTO getMissoes() {
        return missoes;
    }

    public void setMissoes(MissoesDTO missoes) {
        this.missoes = missoes;
    }
}
