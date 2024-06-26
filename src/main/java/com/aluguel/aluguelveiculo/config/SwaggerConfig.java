package com.aluguel.aluguelveiculo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


@Configuration
@ComponentScan(basePackages = {"com.aluguel.aluguelveiculo.controllers"})
public class SwaggerConfig {

        @Bean
        public OpenAPI openAPI() {
          return new OpenAPI()
                  .info(new Info()
                          .title("Title - Rest API")
                          .description("API exemplo de uso de Springboot REST API")
                          .version("1.0")
                          .termsOfService("Termo de uso: Open Source")
                          .license(new License()
                                  .name("Apache 2.0")
                                  .url("http://www.apache.org/licenses/LICENSE-2.0")
                          )
                  );
        }
}

