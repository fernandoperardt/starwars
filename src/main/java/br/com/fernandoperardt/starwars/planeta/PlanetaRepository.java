package br.com.fernandoperardt.starwars.planeta;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PlanetaRepository extends MongoRepository<PlanetaEntity, String> {

    PlanetaEntity findByNome(String nome);

    List<PlanetaEntity> findListByNome(String nome);

    List<PlanetaEntity> findListById(String id);

}