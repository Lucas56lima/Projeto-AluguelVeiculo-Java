package com.aluguel.aluguelveiculo.domain.interfaces;


import java.util.concurrent.CompletableFuture;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;


import com.aluguel.aluguelveiculo.domain.commands.DeliverymanCommand;


public interface IDeliverymanService{
    @Async
    CompletableFuture<ResponseEntity<Void>>PostAsyncDeliveryman(DeliverymanCommand command);
}
