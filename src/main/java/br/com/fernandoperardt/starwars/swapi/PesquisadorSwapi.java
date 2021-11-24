package br.com.fernandoperardt.starwars.swapi;

import br.com.fernandoperardt.starwars.swapi.planeta.PlanetaSwapiDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class PesquisadorSwapi {
    private static final String URL_BASE = "https://swapi.dev/api/";
    private static final String URL_PLANETA = "planets/";
    private static final String URL_SEARCH = "?search=";

    public int pesquisarQuantasVezesOPlanetaApareceuPorNome(String nome) {
        RestTemplate restTemplate = new RestTemplate();
        // workaround to ResultadoDTO<PlanetaDTO> planetaPesquisado = restTemplate.getForObject(URL_BASE.concat(URL_PLANETA).concat(URL_SEARCH).concat(nome), ResultadoDTO.class);
        // java.lang.ClassCastException: java.util.LinkedHashMap cannot be cast[...]
        ResultadoSwapiDTO<PlanetaSwapiDTO> planetaPesquisado = restTemplate.exchange(URL_BASE.concat(URL_PLANETA).concat(URL_SEARCH).concat(nome),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ResultadoSwapiDTO<PlanetaSwapiDTO>>() {}).getBody();
        if(planetaPesquisado != null &&  planetaPesquisado.getCount() > 0)
            return planetaPesquisado.getResults().get(0).getFilms().size();
        else
            return 0;
    }
}
