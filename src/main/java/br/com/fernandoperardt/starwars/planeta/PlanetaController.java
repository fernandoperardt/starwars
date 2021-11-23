package br.com.fernandoperardt.starwars.planeta;

import br.com.fernandoperardt.starwars.swapi.PesquisadorSwapi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/planeta")
public class PlanetaController {

    @Autowired
    private PlanetaRepository repository;

    @GetMapping
    public Object pesquisarPlaneta(@RequestParam(value = "nome", required = false) String nome, @RequestParam(value = "id", required = false) String id) {
        if (nome != null && !nome.isBlank())
            return repository.findByNome(nome);
        else if (id != null)
            return repository.findById(id);
        else
            return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> criarPlaneta(@Valid @RequestBody PlanetaModel planeta) {
        if(repository.findByNome(planeta.getNome()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        planeta.setQtdFilmesApareceu(new PesquisadorSwapi().pesquisarQuantasVezesOPlanetaApareceuPorNome(planeta.getNome()));
        return ResponseEntity.ok(repository.save(planeta));
    }

    @DeleteMapping
    public void deletarPlanetaPeloId(@RequestParam(value = "id", required = false) String id ){
        repository.deleteById(id);
    }
}
