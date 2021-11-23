package br.com.fernandoperardt.starwars.swapi.planets;

public class PesquisaPlanetaDTO {
    private int count;
    private ResultadosDTO[] results;

    public PesquisaPlanetaDTO() {
    }

    public PesquisaPlanetaDTO(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ResultadosDTO[] getResults() {
        return results;
    }

    public void setResults(ResultadosDTO[] results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "PesquisaPlanetaDTO{" +
                "count=" + count +
                ", results=" + results +
                '}';
    }

}
