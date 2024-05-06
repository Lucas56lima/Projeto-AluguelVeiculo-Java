package com.aluguel.aluguelveiculo.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.aluguel.aluguelveiculo.domain.commands.DeliverymanCommand;
import com.aluguel.aluguelveiculo.domain.entities.Deliveryman;
import com.aluguel.aluguelveiculo.domain.interfaces.IDeliverymanRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Service
public class DelivermanService {

    @Autowired
    private IDeliverymanRepository repository;
    
    
    @Async
    public CompletableFuture<ResponseEntity<String>> postAsyncDeliveryman(@RequestBody DeliverymanCommand command){
        
        LocalDate todayDate = LocalDate.now();

        if (command == null) {
            return CompletableFuture.supplyAsync(() -> {                
                return new ResponseEntity<>("Todos os campos são obrigatórios!", HttpStatus.UNPROCESSABLE_ENTITY);
            });
        }

        Deliveryman deliveryman = command.toEntity();
        var deliverManDb = repository.findByCnpj(deliveryman.getCnpj());
        Period period = Period.between(todayDate, deliveryman.getBirthday());

        int years = period.getYears();
        if (deliverManDb.isPresent()) {
            return CompletableFuture.supplyAsync(() -> {                
                return new ResponseEntity<>("Usuário já cadastrado.", HttpStatus.UNPROCESSABLE_ENTITY);
            });
        }
        
        if (years < 18){
            return CompletableFuture.supplyAsync(() -> {                
                return new ResponseEntity<>("Usuário precisa ter mais de 18 anos.", HttpStatus.UNPROCESSABLE_ENTITY);
            });
        }
        
        
        return CompletableFuture.supplyAsync(() -> {
        repository.save(deliveryman);
        return new ResponseEntity<>("Dados inseridos com sucesso", HttpStatus.CREATED);
        });
        
        
                
    }

}
