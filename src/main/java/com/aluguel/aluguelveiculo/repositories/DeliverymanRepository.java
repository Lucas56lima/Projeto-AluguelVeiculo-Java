package com.aluguel.aluguelveiculo.repositories;

import org.springframework.stereotype.Repository;
// import java.util.concurrent.CompletableFuture;
// import org.springframework.dao.DataAccessException;
// import org.springframework.dao.DataAccessResourceFailureException;
// import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import com.aluguel.aluguelveiculo.domain.entities.Deliveryman;
import java.util.Optional;

@Repository
public interface DeliverymanRepository extends JpaRepository<Deliveryman, UUID>{
    Optional<Deliveryman> findByCnpj(String cnpj);             
        
}
