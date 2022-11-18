package com.waracle.cake_manager_service.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.waracle.cake_manager_service.domain.Cake;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CakeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CakeRepository repository;

    @Test
    public void should_find_no_cakes_when_empty(){
        List<Cake> results = repository.findAll();
        assertThat(results).isEmpty();
    }

    @Test
    public void should_find_all_cakes(){

        Cake expected1 = new Cake();
        expected1.setTitle("Title1");
        expected1.setDescription("Description1");
        expected1.setImage("Image1");
        Cake expected2 = new Cake();
        expected2.setTitle("Title2");
        expected2.setDescription("Description2");
        expected2.setImage("Image2");

        entityManager.persist(expected1);
        entityManager.persist(expected2);

        List<Cake> results = repository.findAll();
        assertThat(results).hasSize(2);
        assertThat(results).contains(expected1,expected2);
    }

    @Test
    public void should_save_a_cake(){
        Cake expected = new Cake();
        expected.setTitle("Title");
        expected.setDescription("Description");
        expected.setImage("Image");

        Cake entity = repository.save(expected);
        assertThat(entity.getId()).isGreaterThan(0);
        assertThat(entity).hasFieldOrPropertyWithValue("title", expected.getTitle());
        assertThat(entity).hasFieldOrPropertyWithValue("description", expected.getDescription());
        assertThat(entity).hasFieldOrPropertyWithValue("image", expected.getImage());
    }
}