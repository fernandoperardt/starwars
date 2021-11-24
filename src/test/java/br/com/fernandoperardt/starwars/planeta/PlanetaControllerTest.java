package br.com.fernandoperardt.starwars.planeta;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PlanetaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PlanetaService service;


    @Test
    void criarPlaneta() throws Exception {
        PlanetaDTO dto = new PlanetaDTO("tatooine", "arido", "deserto");
        PlanetaEntity entity = new PlanetaEntity("tatooine", "arido", "deserto");

        given(service.criarPlaneta(dto)).willReturn(entity);

        mockMvc.perform(post("/planeta")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());
    }

    @Test
    void pesquisarPlanetas() throws Exception {
        PlanetaEntity entity = new PlanetaEntity("tatooine", "arido", "deserto");
        List<PlanetaEntity> planetas = Arrays.asList(entity);

        given(service.pesquisarTodosPlanetas()).willReturn(planetas);

        mockMvc.perform(get("/planeta")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(planetas)))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(planetas)));
    }

    @Test
    void tentaCriarPlanetaComNomeQueJaExiste() throws Exception {
        PlanetaDTO dto = new PlanetaDTO("tatooine", "arido", "deserto");
        PlanetaEntity entity = new PlanetaEntity("tatooine", "arido", "deserto");

        given(service.criarPlaneta(dto)).willReturn(entity);
        given(service.pesquisarPlanetasPorNome("tatooine")).willReturn(Arrays.asList(entity));

        mockMvc.perform(post("/planeta")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(""));

    }
}
