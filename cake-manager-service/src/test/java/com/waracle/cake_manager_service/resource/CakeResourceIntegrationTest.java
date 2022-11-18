package com.waracle.cake_manager_service.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.waracle.cake_manager_service.model.CakeDTO;
import com.waracle.cake_manager_service.service.CakeService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CakeResource.class)
public class CakeResourceIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CakeService service;

    @Test
    public void given_cakes_when_get_then_returnString() throws Exception {

        CakeDTO cake = new CakeDTO();
        cake.setId(123L);
        cake.setTitle("A cake title");
        cake.setDescription("A cake description");
        cake.setImage("a cake image");
        List<CakeDTO> cakes = List.of(cake);

        given(service.findAll()).willReturn(cakes);

        mvc.perform(get("/").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(cake.toString())));

        verify(service, times(1)).findAll();
    }

    @Test
    public void given_cakes_when_getCakes_then_returnJsonList() throws Exception {

        CakeDTO cake = new CakeDTO();
        cake.setId(123L);
        cake.setTitle("A cake title");
        cake.setDescription("A cake description");
        cake.setImage("a cake image");
        List<CakeDTO> cakes = List.of(cake);

        given(service.findAll()).willReturn(cakes);

        mvc.perform(get("/cakes").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title", is(cake.getTitle())))
                .andExpect(jsonPath("$[0].description", is(cake.getDescription())))
                .andExpect(jsonPath("$[0].image", is(cake.getImage())));

        verify(service, times(1)).findAll();
    }

    @Test
    public void given_cake_when_postCakes_then_status_created() throws Exception {

        CakeDTO cake = new CakeDTO();
        cake.setId(123L);
        cake.setTitle("A cake title");
        cake.setDescription("A cake description");
        cake.setImage("a cake image");

        given(service.create(cake)).willReturn(cake.getId());

        mvc.perform(post("/cakes").contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(cake)))
                .andExpect(status().isCreated());

        verify(service, times(1)).create(any(CakeDTO.class));
    }

    @Test
    public void given_invalidCake_when_postCakes_then_status_badRequest() throws Exception {

        CakeDTO cake = new CakeDTO();
        cake.setId(123L);

        mvc.perform(post("/cakes").contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(cake)))
                .andExpect(status().isBadRequest());

    }

}