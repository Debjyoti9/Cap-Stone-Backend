package com.example.SpringCloudAPIGateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p-> p.path("/v1/**").uri("http://localhost:8085"))
                .route(p->p.path("/v2/**").uri("http://localhost:8084"))
                .route(p->p.path("/v3/**").uri("http://localhost:8086"))
                .route(p->p.path("/v4/**").uri("http://localhost:8087"))
                .route(p->p.path("/v5/**").uri("http://localhost:8090"))
                .route(p->p.path("/v6/**").uri("http://localhost:8091"))
                .route(p->p.path("/v7/**").uri("http://localhost:8092"))
                .build();
    }
}
