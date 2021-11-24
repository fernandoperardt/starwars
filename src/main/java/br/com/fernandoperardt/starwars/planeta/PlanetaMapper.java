package br.com.fernandoperardt.starwars.planeta;

public class PlanetaMapper {
    public PlanetaEntity toEntity(PlanetaDTO dto) {
        PlanetaEntity entity = new PlanetaEntity();
        entity.setNome(dto.getNome());
        entity.setClima(dto.getClima());
        entity.setTerreno(dto.getTerreno());
        return entity;
    }
}
