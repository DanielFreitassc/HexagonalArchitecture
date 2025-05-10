package com.danielfreitassc.backend.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.danielfreitassc.backend.application.usecases.ProductUseCases;
import com.danielfreitassc.backend.domain.product.Product;
import com.danielfreitassc.backend.domain.product.ProductRepository;
import com.danielfreitassc.backend.domain.product.ProductRequestDto;
import com.danielfreitassc.backend.domain.product.ProductResponseDto;
import com.danielfreitassc.backend.utils.mappers.ProductMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductUseCases {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductResponseDto create(ProductRequestDto productRequestDto) {
        return productMapper.toDto(productRepository.save(productMapper.dtoToEntity(productRequestDto)));
    }

    public List<ProductResponseDto> getAll() {
        return productRepository.findAll().stream().map(productMapper::toDto).toList();
    }

    public ProductResponseDto getById(String id) {
        return productMapper.toDto(findProductOrThrow(id));
    }
    
    public ProductResponseDto deleteById(String id) {
        Product product = findProductOrThrow(id);
        productRepository.delete(product);
        return productMapper.toDto(product);
    }

    public ProductResponseDto updateById(String id, ProductRequestDto productRequestDto) {
        Product product = findProductOrThrow(id);
        productMapper.toUpdate(productRequestDto, product);
        return productMapper.toDto(productRepository.save(product));
    }

    private Product findProductOrThrow(String id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Nenhum produto encontrado");
        return product.get();
    }
}
