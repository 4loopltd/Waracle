package com.waracle.cake_manager_client.controller;

import com.waracle.cake_manager_client.model.CakeDTO;
import com.waracle.cake_manager_client.service.CakeService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CakeController.class)
public class CakeControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CakeService service;

    @Test
    public void when_getRoot_then_returnView() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void given_cakes_when_getCakes_then_returnViewModel() throws Exception {

        CakeDTO cake = new CakeDTO();
        cake.setTitle("A cake title");
        cake.setDescription("A cake description");
        cake.setImage("a cake image");
        List<CakeDTO> cakes = List.of(cake);

        given(service.findAll()).willReturn(cakes);

        mvc.perform(get("/cakes"))
                .andExpect(status().isOk())
                .andExpect(view().name("cakes"))
                .andExpect(model().attribute("cakes", hasSize(1)))
                .andExpect(model().attribute("cakes", hasItem(
                        allOf(
                                hasProperty("title", is(cake.getTitle())),
                                hasProperty("description", is(cake.getDescription())),
                                hasProperty("image", is(cake.getImage()))
                        )
                )));

        verify(service, times(1)).findAll();
    }

    @Test
    public void should_returnErrorView_onException() throws Exception {

        given(service.findAll()).willThrow(new RuntimeException());

        mvc.perform(get("/cakes"))
                .andExpect(status().isOk())
                .andExpect(view().name("error"));

        verify(service, times(1)).findAll();
    }

}