package br.com.fernandoperardt.starwars.swapi;

import br.com.fernandoperardt.starwars.swapi.planets.PesquisaPlanetaDTO;
import org.springframework.web.client.RestTemplate;

public class PesquisadorSwapi {
    private static final String URL_BASE = "https://swapi.dev/api/";
    private static final String URL_PLANETA = "planets/";
    private static final String URL_SEARCH = "?search=";

    public int pesquisarQuantasVezesOPlanetaApareceuPorNome(String nome) {
        RestTemplate restTemplate = new RestTemplate();
        PesquisaPlanetaDTO pedido = restTemplate.getForObject(URL_BASE.concat(URL_PLANETA).concat(URL_SEARCH).concat(nome), PesquisaPlanetaDTO.class);
        if(pedido != null &&  pedido.getCount() > 0)
            return pedido.getResults()[0].getFilms().length;
        else
            return 0;
    }
}
