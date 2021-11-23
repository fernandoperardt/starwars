package br.com.fernandoperardt.starwars.planeta;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlanetaRepository extends MongoRepository<PlanetaModel, String> {

    PlanetaModel findByNome(String nome);

}