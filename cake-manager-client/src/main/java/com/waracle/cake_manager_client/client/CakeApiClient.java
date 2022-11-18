package com.waracle.cake_manager_client.client;

import com.waracle.cake_manager_client.model.CakeDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Component
public class CakeApiClient {

    @Value("${cake.url}")
    private String cakeUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public List<CakeDTO> findAll() {
        final CakeDTO[] cakes = restTemplate.getForObject(cakeUrl + "/cakes", CakeDTO[].class);
        return cakes == null ? Collections.emptyList() :  List.of(cakes);
    }

    public void save(CakeDTO cake) {
        restTemplate.postForObject(cakeUrl + "/cakes", cake, Long.class);
    }
}
