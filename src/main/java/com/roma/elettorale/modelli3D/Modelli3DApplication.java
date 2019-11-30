package com.roma.elettorale.modelli3D;

import com.roma.elettorale.modelli3D.service.ElaborazioneModelli;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaAuditing
public class Modelli3DApplication {

	Logger logger = LoggerFactory.getLogger(Modelli3DApplication.class);

	@Autowired
	Environment env;

	@Autowired
	ElaborazioneModelli elaborazioneModelli;


	public static void main(String[] args) {
		SpringApplication.run(Modelli3DApplication.class, args);
	}


	@Bean
	public CommandLineRunner run(ApplicationContext appContext) {
		return args -> {
		    elaborazioneModelli.getModelliProtocolloForDate();
			elaborazioneModelli.getModelliMailForDate();
		};
	}

}
