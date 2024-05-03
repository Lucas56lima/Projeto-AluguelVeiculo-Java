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
import com.aluguel.aluguelveiculo.domain.interfaces.IDeliverymanRepository;

import io.swagger.annotations.ApiOperation;
import jakarta.transaction.Transactional;

@RestController
public class DeliverymanController {
    private final IDeliverymanRepository repository;  
   
    public DeliverymanController(IDeliverymanRepository repository){
        
        this.repository = repository;
    }

    @Transactional
    @PostMapping("/postdeliveryman")
    @ApiOperation(value = "Criar um novo entregador", notes = "Este endpoint cria um novo entregador com base nos dados fornecidos.")
    public CompletableFuture<ResponseEntity<String>>PostAsyncDeliveryman(@RequestBody DeliverymanCommand command){
        return CompletableFuture.supplyAsync(() -> {
            try {
                repository.save(command.toEntity());
                return new ResponseEntity<>("Dados inseridos com sucesso", HttpStatus.CREATED);
            } catch (Exception ex) {
                return new ResponseEntity<>("Não foi possível inserir dados",HttpStatus.INTERNAL_SERVER_ERROR);
            }
        });        
        
    }
    
    @Transactional
    @GetMapping("/getdeliverman")
    @ApiOperation(value = "Criar um novo entregador", notes = "Este endpoint recupera todos os cadastros.")
        public CompletableFuture<ResponseEntity<List<Deliveryman>>>GetAsyncDeliveryman(){            
            return CompletableFuture.supplyAsync(() -> {
                try {
                    List<Deliveryman> deliveryMans = repository.findAll();
                    return new ResponseEntity<>(deliveryMans, HttpStatus.OK);
                } catch (Exception ex) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            });
        }

}
