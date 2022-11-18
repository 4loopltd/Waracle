package com.waracle.cake_manager_client.service;

import com.waracle.cake_manager_client.client.CakeApiClient;
import com.waracle.cake_manager_client.model.CakeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CakeService {

    private final CakeApiClient cakeApiClient;

    public CakeService(final CakeApiClient cakeApiClient) {
        this.cakeApiClient = cakeApiClient;
    }

    public List<CakeDTO> findAll() {
        return cakeApiClient.findAll();
    }

    public void create(final CakeDTO cake) {
        cakeApiClient.save(cake);
    }

}
