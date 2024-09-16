package com.backpruebatecnica.backpruebatecnica.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("sprinboot-apis")
                .pathsToMatch("/**")
                .addOpenApiCustomizer(openApi -> openApi.info(apiInfo()))
                .build();
    }

    @Bean
    public Info apiInfo() {
        return new Info()
                .title("Practica para backend")
                .description("API para la autenticación de usuarios y la gestión de creación de actividades y notas")
                .version("1.0")
                .contact(new Contact()
                        .name("Jonathan")
                        .url("https://github.com/dekklabs")
                        .email("jjacobo@utp.edu.pe"))
                .license(new License()
                        .name("Licencia GPL")
                        .url("http://www.licencia.com"));
    }
}
