package com.aluguel.aluguelveiculo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"entities","com.aluguel.aluguelveiculo.controllers","com.aluguel.aluguelveiculo.services"})
public class AluguelveiculoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AluguelveiculoApplication.class, args);
		openSwaggerUI();
	}	
	@SuppressWarnings("deprecation")
	private static void openSwaggerUI() {
		try {
            Runtime.getRuntime().exec("cmd /c start http://localhost:8080/swagger-ui/index.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
