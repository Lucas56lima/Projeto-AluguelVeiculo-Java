package com.aluguel.aluguelveiculo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aluguel.aluguelveiculo.domain.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
