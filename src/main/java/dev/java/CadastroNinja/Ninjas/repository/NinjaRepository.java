package dev.java.CadastroNinja.Ninjas.repository;

import dev.java.CadastroNinja.Ninjas.model.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NinjaRepository extends JpaRepository<NinjaModel, UUID> {
}
