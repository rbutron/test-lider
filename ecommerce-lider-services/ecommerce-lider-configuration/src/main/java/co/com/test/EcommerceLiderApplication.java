package co.com.test;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import co.com.test.utility.ConstantManagers;

@SpringBootApplication
public class EcommerceLiderApplication {
	
	private static final Logger LOGGER = Logger.getLogger(EcommerceLiderApplication.class.getName());

	public static void main(String... args) {
		SpringApplication.run(EcommerceLiderApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(@Value(ConstantManagers.ENVAPP) String env) {
		return args -> LOGGER.info(env);
	}

}
