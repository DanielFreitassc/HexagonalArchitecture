package com.danielfreitassc.backend.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import com.danielfreitassc.backend.adapters.outbound.entities.JpaProductEntity;
import com.danielfreitassc.backend.domain.product.Product;
import com.danielfreitassc.backend.domain.product.ProductRequestDto;
import com.danielfreitassc.backend.domain.product.ProductResponseDto;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponseDto toDto(Product product);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "createdAt", ignore = true)
    })
    Product dtoToEntity(ProductRequestDto productRequestDto);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "createdAt", ignore = true)
    })
    void toUpdate(ProductRequestDto productRequestDto, @MappingTarget Product product);

    @Mappings({
        @Mapping(source = "jpaProductEntity.id", target = "id"),
        @Mapping(source = "jpaProductEntity.name", target = "name"),
        @Mapping(source = "jpaProductEntity.description", target = "description"),
        @Mapping(source = "jpaProductEntity.price", target = "price"),
        @Mapping(source = "jpaProductEntity.createdAt", target = "createdAt"),
    })
    Product jpaToDomain(JpaProductEntity jpaProductEntity);
}
