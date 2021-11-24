package br.com.fernandoperardt.starwars.planeta;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlanetaMapperTest {

    @Test
    public void toEntity() throws Exception {
        PlanetaDTO dto = new PlanetaDTO("tatooine", "arido", "deserto");
        PlanetaEntity entityEsperada = new PlanetaEntity("tatooine", "arido", "deserto");
        PlanetaEntity entity = new PlanetaMapper().toEntity(dto);
        assertThat(entity).isEqualTo(entityEsperada).withFailMessage("Planeta entidade diferente da esperada!");
    }
}
