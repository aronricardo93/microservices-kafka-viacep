package com.escola.matriculas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI docAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Enrollment API")
                        .version("1.0.0")
                        .description("Student Management API Documentation")
                        .contact(new Contact()
                                .name("Aron Ricardo - Backend Java")
                                .url("https://www.linkedin.com/in/aronricardo")
                                .email("aronricardo@hotmail.com"))
                );
    }
}
