package dev.java.CadastroNinja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"dev.java.CadastroNinja.Ninjas.model", "dev.java.CadastroNinja.Missoes.model"})
public class CadastroNinjaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroNinjaApplication.class, args);

	}

}
