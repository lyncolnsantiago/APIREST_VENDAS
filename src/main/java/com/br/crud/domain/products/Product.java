package com.br.crud.domain.products;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "products")
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    public Product(ProductRequestDTO dto) {
        this.name = dto.name();
        this.description = dto.description();
        this.price = dto.price();
    }

    public void updateData(ProductRequestDTO dto) {
        if (dto.name() != null && !dto.name().isBlank()) {
            this.name = dto.name();
        }
        if (dto.description() != null) {
            this.description = dto.description();
        }
        if (dto.price() != null && dto.price().compareTo(BigDecimal.ZERO) > 0) {
            this.price = dto.price();
        }
    }
}
