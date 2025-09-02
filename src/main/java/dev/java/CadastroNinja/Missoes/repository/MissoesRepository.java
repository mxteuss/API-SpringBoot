package dev.java.CadastroNinja.Missoes.repository;

import dev.java.CadastroNinja.Missoes.model.Missoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MissoesRepository extends JpaRepository<Missoes, UUID> {
}
