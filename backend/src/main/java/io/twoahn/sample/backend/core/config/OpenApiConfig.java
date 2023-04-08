package io.twoahn.sample.backend.core.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openApi(@Value("${spring.profiles.active}") String active) {
        Info info = new Info().title("Spring-Api-App - " + active).version("appVersion")
                .description("시스템 API 명세서입니다.")
                .termsOfService("http://")
                .contact(new Contact().name("junghak"))
                ;

        List<Server> servers = Arrays.asList(new Server().url("/api").description("API Server Context Path"));

        SecurityScheme securityScheme = new SecurityScheme()
                .type(SecurityScheme.Type.APIKEY)
                .in(SecurityScheme.In.HEADER).name("Authorization");


        SecurityRequirement securityRequirement = new SecurityRequirement().addList("BearerAuth");

        return new OpenAPI()
                .components(new Components().addSecuritySchemes("Bearer", securityScheme))
                .security(Arrays.asList(securityRequirement))
                .info(info)
                .servers(servers);

    }
}
