package com.danielfreitassc.backend.adapters.outbound.repositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.danielfreitassc.backend.adapters.outbound.entities.JpaProductEntity;
import com.danielfreitassc.backend.domain.product.Product;
import com.danielfreitassc.backend.domain.product.ProductRepository;
import com.danielfreitassc.backend.utils.mappers.ProductMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    private final JpaProductRepository jpaProductRepository;
    private final ProductMapper productMapper;

    @Override
    public Product save(Product product) {
        JpaProductEntity productEntity = new JpaProductEntity(product);
        this.jpaProductRepository.save(productEntity);
        return new Product(productEntity.getId(),productEntity.getName(),productEntity.getDescription(),productEntity.getPrice(),productEntity.getCreatedAt());
    }

    @Override
    public Optional<Product> findById(String id) {
        Optional<JpaProductEntity> productEntity = this.jpaProductRepository.findById(id);
        return productEntity.map(productMapper::jpaToDomain);
    }

    @Override
    public List<Product> findAll() {
        return this.jpaProductRepository.findAll().stream().map(entity -> new Product(entity.getId(),entity.getName(),entity.getDescription(),entity.getPrice(),entity.getCreatedAt())).collect(Collectors.toList());
    }
         
    @Override
    public void delete(Product product) {
        jpaProductRepository.deleteById(product.getId());
    }
}
