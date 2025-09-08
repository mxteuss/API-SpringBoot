package dev.java.CadastroNinja.Missoes.model;

import dev.java.CadastroNinja.Ninjas.model.NinjaModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_missoes")
public class Missoes implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String dif;
    @Size(min = 4, max = 25)
    private String name;
    private String descricao;
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjaModel;
}
