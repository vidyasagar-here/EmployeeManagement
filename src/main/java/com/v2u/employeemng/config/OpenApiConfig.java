package com.v2u.employeemng.config;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("V2U Employee Management")
                                .version("1.0")
                                .description("Employee Management API"))
                .externalDocs(new ExternalDocumentation()
                        .description("**Download OpenAPI Spec:**\n\n- [YAML]   (/v3/api-docs.yaml)\n- [JSON]   (/v3/api-docs)")
                        .url("#"));
    }
}

