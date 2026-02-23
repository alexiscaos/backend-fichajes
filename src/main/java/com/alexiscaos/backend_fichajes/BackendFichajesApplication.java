package com.alexiscaos.backend_fichajes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.alexiscaos.backend_fichajes.repository")
@EntityScan("com.alexiscaos.backend_fichajes.model")
public class BackendFichajesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendFichajesApplication.class, args);
	}

}
