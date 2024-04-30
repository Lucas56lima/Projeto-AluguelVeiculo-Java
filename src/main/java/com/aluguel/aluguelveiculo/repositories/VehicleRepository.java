package com.aluguel.aluguelveiculo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aluguel.aluguelveiculo.domain.entities.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {

}
