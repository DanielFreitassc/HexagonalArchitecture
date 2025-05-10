package com.danielfreitassc.backend.domain.product;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRequestDto(
    @NotBlank(message = "Nome é obrigatório")
    String name,
    @NotBlank(message = "Descrição não é obrigatória")
    String description,
    @NotNull(message = "Preço é obrigatório")
    BigDecimal price
) {
    
}
