package com.aluguel.aluguelveiculo.services;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.aluguel.aluguelveiculo.domain.commands.DeliverymanCommand;
import com.aluguel.aluguelveiculo.domain.interfaces.IDeliverymanService;
import com.aluguel.aluguelveiculo.repositories.DeliverymanRepository;

@Service
public class DeliverymanService implements IDeliverymanService{
    @Autowired
    private DeliverymanRepository repository;    

    @Override
    public CompletableFuture<ResponseEntity<Void>> PostAsyncDeliveryman(DeliverymanCommand command) {
        if (command == null){
            return CompletableFuture.failedFuture(new RuntimeException("Error for implements Deliveryman"));
        }

        return repository.PostAsyncDeliveryman(command);
        
    }
    
}
