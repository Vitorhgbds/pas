package com.bcopstein;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
@EntityScan(basePackages = {"com.bcopstein"})
@EnableJpaRepositories(basePackages = {"com.bcopstein"})
public class SvBkPrototipo {
    public static void main(String[] args) {
        SpringApplication.run(SvBkPrototipo.class, args);
    }
}


