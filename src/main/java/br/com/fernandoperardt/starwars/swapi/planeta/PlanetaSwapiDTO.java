package br.com.fernandoperardt.starwars.swapi.planeta;

import java.util.List;

public class PlanetaSwapiDTO<T> {
    private List<String> films;

    public PlanetaSwapiDTO() {
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }
}
