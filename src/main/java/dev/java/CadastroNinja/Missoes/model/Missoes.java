package dev.java.CadastroNinja.Missoes.model;

import dev.java.CadastroNinja.Ninjas.model.NinjaModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
@Table(name = "tb_missoes")
public class Missoes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String dif;
    @Size(min = 4, max = 25)
    private String name;
    private String descricao;
    @OneToMany(mappedBy = "missoes", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NinjaModel> ninjaModel = new ArrayList<>();

    public Missoes(String name, String dif, String descricao) {
        this.name = name;
        this.dif = dif;
        this.descricao = descricao;

    }

    public String getDif() {
        return dif;
    }

    public void setDif(String dif) {
        this.dif = dif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
