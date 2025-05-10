package com.danielfreitassc.backend.adapters.outbound.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielfreitassc.backend.adapters.outbound.entities.JpaProductEntity;

public interface JpaProductRepository extends JpaRepository<JpaProductEntity, String>{
    
}
