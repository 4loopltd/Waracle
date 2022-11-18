package com.waracle.cake_manager_service.service;

import com.waracle.cake_manager_service.domain.Cake;
import com.waracle.cake_manager_service.model.CakeDTO;
import com.waracle.cake_manager_service.repository.CakeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CakeService {

    private final CakeRepository cakeRepository;

    public CakeService(final CakeRepository cakeRepository) {
        this.cakeRepository = cakeRepository;
    }

    public List<CakeDTO> findAll() {
        return cakeRepository.findAll(Sort.by("id"))
                .stream()
                .map(cake -> mapToDTO(cake, new CakeDTO()))
                .collect(Collectors.toList());
    }

    public Long create(final CakeDTO cakeDTO) {
        final Cake cake = new Cake();
        mapToEntity(cakeDTO, cake);
        return cakeRepository.save(cake).getId();
    }

    private CakeDTO mapToDTO(final Cake cake, final CakeDTO cakeDTO) {
        cakeDTO.setId(cake.getId());
        cakeDTO.setTitle(cake.getTitle());
        cakeDTO.setDescription(cake.getDescription());
        cakeDTO.setImage(cake.getImage());
        return cakeDTO;
    }

    private Cake mapToEntity(final CakeDTO cakeDTO, final Cake cake) {
        cake.setTitle(cakeDTO.getTitle());
        cake.setDescription(cakeDTO.getDescription());
        cake.setImage(cakeDTO.getImage());
        return cake;
    }

}
