package com.br.crud.domain.products;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ProductRequestDTO(
   @NotBlank(message = "O nome do produto é obrigatório.")
   @Size(max = 100, message = "O nome do produto deve conter no máximo 100 caracteres.")
    String name,

    String description,

    @NotNull(message = "O preço do produto é obrigatório.")
    @Positive(message = "O preço do produto deve ser um valor maior que zero.")
    BigDecimal price

) {}
