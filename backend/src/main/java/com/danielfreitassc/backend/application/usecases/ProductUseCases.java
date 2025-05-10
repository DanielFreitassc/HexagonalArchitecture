package com.danielfreitassc.backend.application.usecases;

import java.util.List;

import com.danielfreitassc.backend.domain.product.ProductRequestDto;
import com.danielfreitassc.backend.domain.product.ProductResponseDto;

public interface ProductUseCases {
    
    public ProductResponseDto create(ProductRequestDto productRequestDto);
    public List<ProductResponseDto> getAll();
    public ProductResponseDto getById(String id);
    public ProductResponseDto deleteById(String id);
    public ProductResponseDto updateById(String id, ProductRequestDto productRequestDto);
}
