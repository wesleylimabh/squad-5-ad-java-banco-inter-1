package com.aceleradev.squad5.centralerros.controllers;

import com.aceleradev.squad5.centralerros.CentralErrosApplication;
import com.aceleradev.squad5.centralerros.entity.Erro;
import com.aceleradev.squad5.centralerros.enums.AmbienteEnum;
import com.aceleradev.squad5.centralerros.enums.LevelEnum;
import com.aceleradev.squad5.centralerros.repository.ErroRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.GsonBuilder;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {CentralErrosApplication.class})
@WebAppConfiguration
class ErroControllerTest {
    @Autowired
    private ErroRepository erroRepository;
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mvc;

    @Test
    public void deveCriarNovoErro() throws Exception {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        String uri = "/erro";
        Erro novoErro = Erro.builder()
                .arquivado(false)
                .level(LevelEnum.DEBUG)
                .ambiente(AmbienteEnum.DESENVOLVIMENTO)
                .coletor("Coletor 01")
                .descricao("Descricao 01")
                .detalhes("Detalhe 01")
                .eventos(1)
                .origem("Evento 01")
                .titulo("Titulo 01")
                .data_hora("20/01/2020")
                .build();

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(uri)
                .content(asJsonString(novoErro))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = this.mvc.perform(request).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(201L, status);
        String result = mvcResult.getResponse().getContentAsString();
        Erro erroCriado = (Erro) mapFromJson(result, Erro.class);
        Assert.assertThat(erroRepository.findById(erroCriado.getId()).get(), Matchers.notNullValue());
    }

    protected <T> T mapFromJson(String json, Class<T> clazz) {
        return (new GsonBuilder()).create().fromJson(json, clazz);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}