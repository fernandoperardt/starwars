package br.com.fernandoperardt.starwars.planeta;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class PlanetaEntity {
    @Id
    private String id;
    @NotNull
    private String nome;
    @NotNull
    private String clima;
    @NotNull
    private String terreno;
    private int qtdFilmesApareceu;

    public PlanetaEntity() {}

    public PlanetaEntity(String nome, String clima, String terreno) {
        this.nome = nome;
        this.clima = clima;
        this.terreno = terreno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }

    public int getQtdFilmesApareceu() {
        return qtdFilmesApareceu;
    }

    public void setQtdFilmesApareceu(int qtdFilmesApareceu) {
        this.qtdFilmesApareceu = qtdFilmesApareceu;
    }

    @Override
    public String toString() {
        return "PlanetaModel{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", clima='" + clima + '\'' +
                ", terreno='" + terreno + '\'' +
                ", qtdFilmesApareceu=" + qtdFilmesApareceu +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanetaEntity that = (PlanetaEntity) o;
        return qtdFilmesApareceu == that.qtdFilmesApareceu && Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(clima, that.clima) && Objects.equals(terreno, that.terreno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, clima, terreno, qtdFilmesApareceu);
    }
}
