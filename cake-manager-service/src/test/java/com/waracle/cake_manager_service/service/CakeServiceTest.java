package com.waracle.cake_manager_service.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.waracle.cake_manager_service.domain.Cake;
import com.waracle.cake_manager_service.model.CakeDTO;
import com.waracle.cake_manager_service.repository.CakeRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CakeServiceTest {

    @Mock
    private CakeRepository repository;

    @InjectMocks
    private CakeService service;

    @Test
    public void should_find_all_cakes() {
        Cake cake  = new Cake();
        cake.setId(123L);
        cake.setTitle("A cake title");
        cake.setDescription("A cake description");
        cake.setImage("A cake image");
        when(repository.findAll(any(Sort.class))).thenReturn(List.of(cake));

        List<CakeDTO> cakes = service.findAll();
        assertThat(cakes).hasSize(1);
        assertThat(cakes.get(0).getTitle()).isEqualTo(cake.getTitle());
        assertThat(cakes.get(0).getDescription()).isEqualTo(cake.getDescription());
        assertThat(cakes.get(0).getImage()).isEqualTo(cake.getImage());

        verify(repository, times(1)).findAll(any(Sort.class));
    }

    @Test
    public void should_create_a_cake() {
        Cake cake  = new Cake();
        cake.setId(123L);
        cake.setTitle("A cake title");
        cake.setDescription("A cake description");
        cake.setImage("A cake image");
        when(repository.save(any())).thenReturn(cake);

        Long id = service.create(new CakeDTO());
        assertThat(id).isEqualTo(cake.getId());

        verify(repository, times(1)).save(any());
    }
}