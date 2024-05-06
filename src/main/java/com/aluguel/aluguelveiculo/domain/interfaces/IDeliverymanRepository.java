package com.aluguel.aluguelveiculo.domain.interfaces;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aluguel.aluguelveiculo.domain.entities.Deliveryman;


@Repository
public interface IDeliverymanRepository extends JpaRepository<Deliveryman,UUID>{
       Optional<Deliveryman> findByCnpj(String cnpj);
}
