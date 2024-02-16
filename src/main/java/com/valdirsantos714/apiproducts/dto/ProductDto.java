package com.valdirsantos714.apiproducts.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductDto(@NotBlank String name, @NotNull Integer quantity, @NotNull Double price) {
}
