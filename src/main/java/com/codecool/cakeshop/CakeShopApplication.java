package com.codecool.cakeshop;

import com.codecool.cakeshop.entity.Cake;
import com.codecool.cakeshop.entity.ProductType;
import com.codecool.cakeshop.repository.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class CakeShopApplication {

    @Autowired
    private CakeRepository cakeRepository;

    public static void main(String[] args) {
        SpringApplication.run(CakeShopApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
            Cake dobostorta = Cake.builder()
                    .name("dobostorta")
                    .productType(ProductType.TRADITIONAL_CAKE)
                    .build();

            Cake sachertorta = Cake.builder()
                    .name("sachertorta")
                    .productType(ProductType.TRADITIONAL_CAKE)
                    .build();

            cakeRepository.save(dobostorta);
            cakeRepository.save(sachertorta);
        };
    }

    @Controller
    public class CakeController {


        @GetMapping("/products")
        public String main(Model model) {
            model.addAttribute("cakes", cakeRepository.findAll());
            return "products";
        }
    }

}
