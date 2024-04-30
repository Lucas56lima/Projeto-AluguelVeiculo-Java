package com.aluguel.aluguelveiculo.controllers;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aluguel.aluguelveiculo.domain.commands.DeliverymanCommand;
import com.aluguel.aluguelveiculo.domain.entities.Vehicle;

@RestController
@RequestMapping("/api/deliveryman")
public class DeliverymanController {
    

    @Async
    @PostMapping("/postdeliveryman")
    public CompletableFuture<ResponseEntity<Vehicle>>postAsyncDeliveryman(@RequestBody DeliverymanCommand command){
        return CompletableFuture.supplyAsync(() ->{
            Vehicle vehicle;           
        })
    }
}
