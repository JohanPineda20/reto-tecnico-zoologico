package com.nelumbo.zoo.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@SecurityScheme(name = "jwt", description = "auth using jwt", scheme = "bearer", bearerFormat = "JWT", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class OpenApiConfig {
    @Bean
    public OpenAPI openApiConfiguration(){

        Schema<?> exceptionSchema = new Schema<Map<String, String>>()
                .addProperty("exceptionName", new StringSchema().example("DataNotFoundException"))
                .addProperty("message", new StringSchema().example("Role not found"))
                .addProperty("statusCode", new StringSchema().example("404"))
                .addProperty("timestamp", new StringSchema().example("2024-04-27 14:15:50"))
                .addProperty("controllerError", new StringSchema().example("class com.nelumbo.zoo.controller.UserController"));

        return new OpenAPI()
                .info(new Info()
                        .title("zoo-api hexagonal")
                        .description("zoo management")
                        .version("1.0.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                        .termsOfService("http://swagger.io/terms/"))
                .components(new Components()
                        .addSchemas("Exception", exceptionSchema));
    }
}
