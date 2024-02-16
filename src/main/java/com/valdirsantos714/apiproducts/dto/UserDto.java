package com.valdirsantos714.apiproducts.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserDto(@NotBlank String name, @NotNull Integer age, @NotBlank @Size(max = 15) String sex, @NotBlank String email) {
}
