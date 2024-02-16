package com.valdirsantos714.apiproducts.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AccountDto (@NotNull Double balance,@NotBlank String bankName) {
}
