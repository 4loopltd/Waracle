package com.waracle.cake_manager_service.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("com.waracle.cake_manager_service.domain")
@EnableJpaRepositories("com.waracle.cake_manager_service.repository")
@EnableTransactionManagement
public class DomainConfig {
}
