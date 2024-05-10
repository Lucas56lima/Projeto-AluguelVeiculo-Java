package com.aluguel.aluguelveiculo.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.aluguel.aluguelveiculo.domain.commands.DeliverymanCommand;
import com.aluguel.aluguelveiculo.domain.entities.Deliveryman;
import com.aluguel.aluguelveiculo.repositories.DeliverymanRepository;
import jakarta.transaction.Transactional;

@Service
public class DelivermanService{   
   
    private Logger logger = LoggerFactory.getLogger(DelivermanService.class); 
    @Autowired
    private DeliverymanRepository repository;

    /**
     * @param command entidade que possui características do Deliverycommand
     * Faz validações se o usuário é existente, idade e categoria da CNH.
     * @return
     */
    @Transactional    
    public ResponseEntity<String> postAsyncDeliveryman(DeliverymanCommand command) {
            logger.info("O Método postAsyncDeliveryman foi chamado");
            
            LocalDate todayDate = LocalDate.now();    
                        
            var deliverManDb = repository.findByCnpj(command.getCnpj());
            Period period = Period.between(command.getBirthday(),todayDate);
    
            int years = period.getYears();    
              
            if (deliverManDb.isPresent()) {                                    
                return new ResponseEntity<>("Usuário já cadastrado.", HttpStatus.UNPROCESSABLE_ENTITY);                    
            }
            
            if (years < 18){             
                return new ResponseEntity<>("Usuário precisa ter mais de 18 anos.", HttpStatus.UNPROCESSABLE_ENTITY);                    
            }           
                         
            if (!isValidCnhType(command.getCnhType())){                                   
                return new ResponseEntity<>("O tipo de CNH especificado é inválido. Somente categorias A e AB são permitidas.", HttpStatus.UNPROCESSABLE_ENTITY);                
            }
        try{
            // Salvando o entregador no banco de dados                                 
            repository.save(command.toEntity());
            return ResponseEntity.ok("Dados inseridos com sucesso");
        }catch(Exception ex){
            logger.error("Erro ao salvar entregador no banco de dados: " + ex.getMessage());
            return new ResponseEntity<>("Erro ao salvar entregador no banco de dados.", HttpStatus.INTERNAL_SERVER_ERROR);
        }                  
                         
    }

    @Transactional
    public ResponseEntity<List<Deliveryman>>getAsyncDeliveryman(){
        try {
            List<Deliveryman> deliveryMans = repository.findAll();
            return ResponseEntity.ok(deliveryMans);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Verifica se o tipo de CNH é válido.
    * 
    * @param cnhType tipo da CNH
    * @return true se o tipo de CNH for válido, false caso contrário.
     */
    private boolean isValidCnhType(String cnhType) {
        return "A".equals(cnhType.toUpperCase()) || "AB".equals(cnhType.toUpperCase());
    }
           
}


                      

