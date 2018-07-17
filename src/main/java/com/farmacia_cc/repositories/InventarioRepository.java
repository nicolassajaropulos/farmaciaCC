package com.farmacia_cc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmacia_cc.models.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Integer> {

}
