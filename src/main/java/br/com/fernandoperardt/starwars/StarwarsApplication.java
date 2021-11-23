package br.com.fernandoperardt.starwars;

import br.com.fernandoperardt.starwars.planeta.PlanetaModel;
import br.com.fernandoperardt.starwars.planeta.PlanetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StarwarsApplication  {

	public static void main(String[] args) {
		SpringApplication.run(StarwarsApplication.class, args);
	}

}
