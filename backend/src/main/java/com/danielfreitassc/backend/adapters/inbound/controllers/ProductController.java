package com.danielfreitassc.backend.adapters.inbound.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danielfreitassc.backend.application.services.ProductServiceImpl;
import com.danielfreitassc.backend.domain.product.ProductRequestDto;
import com.danielfreitassc.backend.domain.product.ProductResponseDto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductServiceImpl productServiceImpl;

    @PostMapping
    public ProductResponseDto create(@RequestBody @Valid ProductRequestDto productRequestDto) {
        return productServiceImpl.create(productRequestDto);
    }

    @GetMapping
    public List<ProductResponseDto> getAll() {
        return productServiceImpl.getAll();
    }

    @GetMapping("/{id}")
    public ProductResponseDto getById(@PathVariable String id) {
        return productServiceImpl.getById(id);
    }

    @DeleteMapping("/{id}")
    public ProductResponseDto deleteById(@PathVariable String id) {
        return productServiceImpl.deleteById(id);
    }  
    
    @PutMapping("/{id}")
    public ProductResponseDto updateById(@PathVariable String id,@RequestBody @Valid ProductRequestDto productRequestDto) {
        return productServiceImpl.updateById(id, productRequestDto);
    }
}
