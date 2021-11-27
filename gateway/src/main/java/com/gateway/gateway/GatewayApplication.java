package com.gateway.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class GatewayApplication {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
        .route(p -> p
            .path("/vendas/*")
            .uri("http://servVendas:8080"))
        .route(p -> p
            .path("/estoque/*")
            .uri("http://servEstoque:8080"))
        .build();
    }
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}

//math --> .uri("http://localhost:8081"))
//estatistica --> .uri("http://localhost:8082"))