package com.example.ApiClima.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
@Configuration
public class SwaggerConfing {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Consumo de Api a Api Meteorologica")
                        .version("1.0")
                        .description("\n" +
                                "Desarrolladé una API en Spring Boot que consume datos meteorológicos y de polución desde una API externa." +
                                " La API tiene varios endpoints que ofrecen información del clima actual, niveles de contaminación y pronósticos," +
                                " utilizando un RestTemplate para realizar las peticiones HTTP." +
                                " Además, implementamos una capa de caché para mejorar el rendimiento y almacenamos las credenciales en variables de entorno" +
                                " para garantizar la seguridad."));
    }
}
