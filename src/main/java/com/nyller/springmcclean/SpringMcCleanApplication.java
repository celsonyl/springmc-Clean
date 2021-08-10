package com.nyller.springmcclean;

import com.nyller.springmcclean.gateway.h2database.model.CategoryDatabase;
import com.nyller.springmcclean.gateway.h2database.model.ProductDatabase;
import com.nyller.springmcclean.gateway.h2database.repository.CategoryRepository;
import com.nyller.springmcclean.gateway.h2database.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class SpringMcCleanApplication implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringMcCleanApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        CategoryDatabase category1 = new CategoryDatabase(null, "Escritório");
        CategoryDatabase category2 = new CategoryDatabase(null, "Informática");
        categoryRepository.saveAll(Arrays.asList(category1, category2));

        ProductDatabase product1 = new ProductDatabase(null, "Computador", 1500.00, Arrays.asList(category1, category2));
        ProductDatabase product2 = new ProductDatabase(null, "Mesa", 500.00, Collections.singletonList(category1));
        productRepository.saveAll(Arrays.asList(product1, product2));
    }
}
