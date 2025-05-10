package com.danielfreitassc.backend.domain.product;

import java.math.BigDecimal;
import java.sql.Timestamp;

public record ProductResponseDto(
    String id,
    String name,
    String description,
    BigDecimal price,
    Timestamp createdAt
) {
    
}
