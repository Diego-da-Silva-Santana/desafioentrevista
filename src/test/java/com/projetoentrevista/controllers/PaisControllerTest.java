package com.projetoentrevista.controllers;

import com.projetoentrevista.dto.DadosListagemPaisDTO;
import com.projetoentrevista.dto.PaisDTO;
import com.projetoentrevista.services.PaisService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PaisController.class)
class PaisControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PaisService paisService;

    @Test
    void listarPaises_QuandoReceberRequisicao_DeveRetornar200ComListaDePaises() throws Exception {
        DadosListagemPaisDTO pais1 = new DadosListagemPaisDTO("Brasil", "BR");
        DadosListagemPaisDTO pais2 = new DadosListagemPaisDTO("Argentina", "AR");

        when(paisService.listagemPaises()).thenReturn(Arrays.asList(pais1, pais2));

        mockMvc.perform(MockMvcRequestBuilders.get("/paises")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nome").value("Brasil"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].codigoInternacionalIso").value("BR"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].nome").value("Argentina"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].codigoInternacionalIso").value("AR"));

    }

    @Test
    void listarPais_QuandoReceberRequisicaoComParametroCodigoInternacionalIso_DeveRetornar200ComDadosDoPais() throws Exception {
        LocalDateTime dataCriacao = LocalDateTime.parse("2023-11-28T20:35:30");
        PaisDTO pais = new PaisDTO(1L, "Brasil", "BRA", "América do Sul", 10.000, dataCriacao);

        when(paisService.listarPais("BR")).thenReturn(pais);

        mockMvc.perform(MockMvcRequestBuilders.get("/paises/BR")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("Brasil"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.codigoInternacionalIso").value("BRA"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.continente").value("América do Sul"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.populacao").value(10.000))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dataCriacao").value("2023-11-28T20:35:30"));

    }

    @Test
    void deletarPais_QuandoReceberRequisicaoComParametroId_DeveRetornar204() throws Exception {
        Long id = 1L;

        mockMvc.perform(MockMvcRequestBuilders.delete("/paises" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        Mockito.verify(paisService, Mockito.timeout(1)).deletarpais(id);

    }

}