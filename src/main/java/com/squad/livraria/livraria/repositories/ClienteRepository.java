package com.squad.livraria.livraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.squad.livraria.livraria.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{}
