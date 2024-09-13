package com.valdirsantos714.apiproducts.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AccountDto (@NotNull Double balance,@NotBlank String bankName) {
}
