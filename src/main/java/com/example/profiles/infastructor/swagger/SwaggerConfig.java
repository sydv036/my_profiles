package com.example.profiles.infastructor.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
//    @Bean
//    public GroupedOpenApi publicApi(){
//        return GroupedOpenApi.builder()
//                .group("admin")
//                .pathsToMatch("/api/v1/admin/**")
//                .build();
//    }

    @Bean
    public OpenAPI customOpenApi(){
        return  new OpenAPI()
                .info(new Info()
                        .title("API Documentation")
                        .version("1.0")
                        .description("API"));
    }
}
