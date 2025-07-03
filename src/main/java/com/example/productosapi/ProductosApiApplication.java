package com.example.productosapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Productos API", version = "1.0", description = "API para gestión de productos"))
public class ProductosApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductosApiApplication.class, args);
    }
}