package com.cpan252.tekkenreborn;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cpan252.tekkenreborn.model.Fighter;
import com.cpan252.tekkenreborn.model.Fighter.Anime;
import com.cpan252.tekkenreborn.repository.FighterRepository;

/**
 * mvn spring-boot:run does following steps
 * 1. mvn clean
 * 2. mvn compile
 * 3. mvn package
 * 4. java -jar target/tekkenreborn-0.0.1-SNAPSHOT.jar
 * 5. deploys jar to embedded tomcat
 */
@SpringBootApplication
public class TekkenrebornApplication {

	/**
	 * This is the main method that starts the application
	 * Spring Application Context is created here
	 * You can configure your application properties using @param args
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(TekkenrebornApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(FighterRepository repository) {
		return args -> {
			repository.save(Fighter.builder()
					.name("Pain")
					.animeFrom(Anime.NARUTO)
					.damagePerHit(41)
					.health(4000)
					.resistance(new BigDecimal(0.6)).build());

			repository.save(Fighter.builder()
					.name("Naruto Uzimaki")
					.animeFrom(Anime.NARUTO)
					.damagePerHit(55)
					.health(3400)
					.resistance(new BigDecimal(0.6)).build());

			repository.save(Fighter.builder()
					.name("Sasuke Uchiha")
					.animeFrom(Anime.NARUTO)
					.damagePerHit(44)
					.health(3300)
					.resistance(new BigDecimal(0.6)).build());

			repository.save(Fighter.builder()
					.name("Itachi Uchiha")
					.animeFrom(Anime.NARUTO)
					.damagePerHit(62)
					.health(2500)
					.resistance(new BigDecimal(0.6)).build());
		};
	}

}
