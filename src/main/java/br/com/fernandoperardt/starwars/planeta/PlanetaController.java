package br.com.fernandoperardt.starwars.planeta;

import br.com.fernandoperardt.starwars.swapi.PesquisadorSwapi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/planeta")
public class PlanetaController {
    @Autowired
    private PlanetaService service;

    @GetMapping
    public List<PlanetaEntity> pesquisarPlaneta(@RequestParam(value = "nome", required = false) String nome, @RequestParam(value = "id", required = false) String id) {
        if (nome != null && !nome.isBlank())
            return service.pesquisarPlanetasPorNome(nome);
        else if (id != null)
            return service.pesquisarPlanetasPorId(id);
        else
            return service.pesquisarTodosPlanetas();
    }

    @PostMapping
    public ResponseEntity<PlanetaEntity> criarPlaneta(@Valid @RequestBody PlanetaDTO planetaDTO) {
        List<PlanetaEntity> planetasPesquisados = service.pesquisarPlanetasPorNome(planetaDTO.getNome());
        if(planetasPesquisados != null && !planetasPesquisados.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        PlanetaEntity planetaEntity = service.criarPlaneta(planetaDTO);
        return ResponseEntity.ok(planetaEntity);
    }

    @DeleteMapping
    public void deletarPlanetaPeloId(@RequestParam(value = "id", required = false) String id ){
        service.apagarPlanetaPorId(id);
    }
}
