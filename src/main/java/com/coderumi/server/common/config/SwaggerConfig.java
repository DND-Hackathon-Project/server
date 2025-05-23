package com.coderumi.server.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI pitchainOpenAPI() {
        return new OpenAPI()
                .servers(List.of(new Server().url("http://localhost:8080")));
    }

}
