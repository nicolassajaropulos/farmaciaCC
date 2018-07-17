package com.farmacia_cc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmacia_cc.models.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {

}
