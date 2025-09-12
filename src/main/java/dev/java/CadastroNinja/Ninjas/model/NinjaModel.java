package dev.java.CadastroNinja.Ninjas.model;

import dev.java.CadastroNinja.Missoes.dto.MissoesDTO;
import dev.java.CadastroNinja.Missoes.model.Missoes;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;



@Entity
@Data
@Table(name = "tb_ninjas")
public class NinjaModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min = 3, max = 20)
    private String nome;
    private Integer idade;
    // @ManyToOne O ninja tem uma única missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Foreign key
    private Missoes missoes;

    public NinjaModel(String nome, Integer idade, Missoes missoes) {
        this.nome = nome;
        this.idade = idade;
        this.missoes = missoes;
    }

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

    public Missoes getMissoes() {
        return missoes;
    }

    public void setMissoes(Missoes missoes) {
        this.missoes = missoes;
    }
}
