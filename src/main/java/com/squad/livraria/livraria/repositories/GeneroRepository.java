package com.squad.livraria.livraria.repositories;

import com.squad.livraria.livraria.entities.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer> {
}
