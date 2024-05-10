package com.aluguel.aluguelveiculo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.aluguel.aluguelveiculo.domain.commands.DeliverymanCommand;
import com.aluguel.aluguelveiculo.domain.entities.Deliveryman;
// import com.aluguel.aluguelveiculo.domain.interfaces.IDeliverymanRepository;
import com.aluguel.aluguelveiculo.services.DelivermanService;
import java.util.List;
import io.swagger.annotations.ApiOperation;

import jakarta.transaction.Transactional;

@RestController
public class DeliverymanController {

    @Autowired
    private DelivermanService service;       

    @Transactional
    @PostMapping("/postdeliveryman")     
    @ApiOperation(value = "Criar um novo entregador", notes = "Este endpoint cria um novo entregador com base nos dados fornecidos.")
    public ResponseEntity<?>postAsyncDeliveryman(@RequestBody DeliverymanCommand command){              
        
        var deliveryManCreate = service.postAsyncDeliveryman(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(deliveryManCreate);                                  
    }
    
    @Transactional
    @GetMapping("/getdeliverman")
    @ApiOperation(value = "Lista todos os entregadores", notes = "Este endpoint recupera todos os cadastros.")
    public ResponseEntity<List<Deliveryman>> getAsyncDeliveryman(){         
        
        return service.getAsyncDeliveryman();         
    }

}
