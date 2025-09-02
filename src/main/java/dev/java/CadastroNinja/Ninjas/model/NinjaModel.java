package dev.java.CadastroNinja.Ninjas.model;

import dev.java.CadastroNinja.Missoes.model.Missoes;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "tb_ninjas")
public class NinjaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Size(min = 3, max = 20)
    private String nome;
    private Integer idade;
    // @ManyToOne O ninja tem uma única missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Foreign key
    private Missoes missoes;
}
