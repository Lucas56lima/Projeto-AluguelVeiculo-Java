package com.aluguel.aluguelveiculo.controllers;
import java.util.List;
import java.util.concurrent.CompletableFuture;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aluguel.aluguelveiculo.domain.commands.DeliverymanCommand;
import com.aluguel.aluguelveiculo.domain.entities.Deliveryman;
import com.aluguel.aluguelveiculo.domain.interfaces.IDeliverymanService;

import io.swagger.annotations.ApiOperation;
import jakarta.transaction.Transactional;

@RestController
public class DeliverymanController {
    private final IDeliverymanService service;  
   
    public DeliverymanController(IDeliverymanService service){
        
        this.service = service;
    }

    @Transactional
    @PostMapping("/postdeliveryman")
    @ApiOperation(value = "Criar um novo entregador", notes = "Este endpoint cria um novo entregador com base nos dados fornecidos.")
    public CompletableFuture<ResponseEntity<String>>postAsyncDeliveryman(@RequestBody DeliverymanCommand command){
        return CompletableFuture.supplyAsync(() -> {            
                service.save(command.toEntity());
                return new ResponseEntity<>("Dados inseridos com sucesso", HttpStatus.CREATED);           
        });        
        
    }
    
    @Transactional
    @GetMapping("/getdeliverman")
    @ApiOperation(value = "Lista todos os entregadores", notes = "Este endpoint recupera todos os cadastros.")
        public CompletableFuture<ResponseEntity<List<Deliveryman>>>getAsyncDeliveryman(){            
            return CompletableFuture.supplyAsync(() -> {
                try {
                    List<Deliveryman> deliveryMans = service.findAll();
                    return new ResponseEntity<>(deliveryMans, HttpStatus.OK);
                } catch (Exception ex) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            });
        }

}
