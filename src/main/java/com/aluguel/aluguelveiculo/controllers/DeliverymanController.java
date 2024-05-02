package com.aluguel.aluguelveiculo.controllers;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.aluguel.aluguelveiculo.domain.commands.DeliverymanCommand;
import com.aluguel.aluguelveiculo.domain.interfaces.IDeliverymanService;

import io.swagger.annotations.ApiOperation;

@RestController
public class DeliverymanController {
    private final IDeliverymanService deliverymanService;

    public DeliverymanController(IDeliverymanService deliverymanService){
        this.deliverymanService = deliverymanService;
    }    
    @PostMapping("/postdeliveryman")
    @ApiOperation(value = "Criar um novo entregador", notes = "Este endpoint cria um novo entregador com base nos dados fornecidos.")
    public CompletableFuture<ResponseEntity<Void>>PostAsyncDeliveryman(@RequestBody DeliverymanCommand command){
        try {
            // Executar operação assíncrona e retornar o resultado diretamente
            deliverymanService.PostAsyncDeliveryman(command);
            // Retornar ResponseEntity com código de status 201 Created
            return CompletableFuture.completedFuture(ResponseEntity.status(HttpStatus.CREATED).build());
        } catch (Exception ex) {
            // Em caso de erro, retornar ResponseEntity com código de status 500 Internal Server Error
            return CompletableFuture.completedFuture(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
        } 
    }
}
