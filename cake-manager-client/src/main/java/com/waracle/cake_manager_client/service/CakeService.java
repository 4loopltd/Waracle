package com.waracle.cake_manager_client.service;

import com.waracle.cake_manager_client.model.CakeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CakeService {

    public List<CakeDTO> findAll() {
        // stub
        return List.of(new CakeDTO());
    }

}
