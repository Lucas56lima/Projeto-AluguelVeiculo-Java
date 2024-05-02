package com.aluguel.aluguelveiculo.repositories;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.aluguel.aluguelveiculo.domain.commands.DeliverymanCommand;
import com.aluguel.aluguelveiculo.domain.entities.Deliveryman;
import com.aluguel.aluguelveiculo.domain.interfaces.IDeliverymanRepository;

import jakarta.transaction.Transactional;

@Repository
public class DeliverymanRepository{
    @Autowired
    private IDeliverymanRepository repository;
    
    @Async
    @Transactional
    public CompletableFuture<ResponseEntity<Void>> PostAsyncDeliveryman(DeliverymanCommand command){
        Deliveryman deliveryMan = new Deliveryman();
        deliveryMan.setName(command.getName());
        deliveryMan.setCnpj(command.getCnpj());
        deliveryMan.setBirthday(command.getBirthday());
        deliveryMan.setCnhNumber(command.getCnhNumber());
        repository.save(deliveryMan);

        return CompletableFuture.completedFuture(ResponseEntity.ok().build());

    }
}
