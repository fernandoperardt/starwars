package br.com.fernandoperardt.starwars.planeta;

import br.com.fernandoperardt.starwars.swapi.PesquisadorSwapi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlanetaService {

    @Autowired
    private PlanetaRepository repository;

    public PlanetaEntity criarPlaneta(PlanetaDTO planetaDTO) {
        PlanetaEntity planeta = new PlanetaMapper().toEntity(planetaDTO);
        planeta.setQtdFilmesApareceu(new PesquisadorSwapi().pesquisarQuantasVezesOPlanetaApareceuPorNome(planeta.getNome()));
        repository.save(planeta);
        return planeta;
    }

    public List<PlanetaEntity> pesquisarPlanetasPorNome(String nome) {
        return repository.findListByNome(nome);
    }

    public List<PlanetaEntity> pesquisarPlanetasPorId(String id) {
        return repository.findListById(id);
    }

    public List<PlanetaEntity> pesquisarTodosPlanetas() {
        return repository.findAll();
    }

    public void apagarPlanetaPorId(String id) {
        repository.deleteById(id);
    }

}
