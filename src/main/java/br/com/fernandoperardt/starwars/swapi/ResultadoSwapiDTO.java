package br.com.fernandoperardt.starwars.swapi;

import java.util.List;

public class ResultadoSwapiDTO<T> {
    private int count;
    private List<T> results;

    public ResultadoSwapiDTO() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
