package com.aluguel.aluguelveiculo.domain.interfaces;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.aluguel.aluguelveiculo.domain.entities.Deliveryman;

public interface IDeliverymanService extends JpaRepository<Deliveryman,UUID>{
    Optional<Deliveryman> findByCnpj(String cnpj);
}
