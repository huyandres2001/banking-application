package com.bansikah.bankingapp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Bank Account API hihi wecommit mai dinh")
                        .version("1.0")
                        .description("API to test CRUD Bank Account | Tech with Bansikah"));
    }
}
