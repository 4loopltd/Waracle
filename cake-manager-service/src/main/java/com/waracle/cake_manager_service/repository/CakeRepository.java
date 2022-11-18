package com.waracle.cake_manager_service.repository;

import com.waracle.cake_manager_service.domain.Cake;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CakeRepository extends JpaRepository<Cake, Long> {
}
