package com.aluguel.aluguelveiculo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"entities","com.aluguel.aluguelveiculo.controllers"})
public class AluguelveiculoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AluguelveiculoApplication.class, args);
		openSwaggerUI();
	}	
	private static void openSwaggerUI() {
		try {
            Runtime.getRuntime().exec("cmd /c start http://localhost:8080/swagger-ui/index.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
