package ua.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import ua.repository.ProductRepository;
import ua.repository.ShopRepository;
import ua.repository.impl.ProductRepositoryImpl;
import ua.repository.impl.ShopRepositoryImpl;

@Configuration
public class AppConfig {
    @Bean
    public ShopRepository shopRepository(JdbcTemplate jdbcTemplate) {
        return new ShopRepositoryImpl(jdbcTemplate);
    }

    @Bean
    public ProductRepository productRepository(JdbcTemplate jdbcTemplate) {
        return new ProductRepositoryImpl(jdbcTemplate);
    }
}
