package com.anderson.ecommerce;

import com.anderson.ecommerce.model.Product;
import com.anderson.ecommerce.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;

    public DataSeeder(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0) {
            Product p1 = new Product("Camiseta", "Camiseta de algodão", new BigDecimal("49.90"), 100);
            Product p2 = new Product("Tênis", "Tênis esportivo", new BigDecimal("199.90"), 50);
            Product p3 = new Product("Mochila", "Mochila resistente", new BigDecimal("89.90"), 75);

            productRepository.save(p1);
            productRepository.save(p2);
            productRepository.save(p3);

            System.out.println("Produtos inseridos com sucesso!");
        } else {
            System.out.println("Produtos já existem no banco.");
        }
    }
}

