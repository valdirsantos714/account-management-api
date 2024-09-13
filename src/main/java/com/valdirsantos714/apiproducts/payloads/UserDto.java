package com.valdirsantos714.apiproducts.payloads;

import com.valdirsantos714.apiproducts.model.Product;
import com.valdirsantos714.apiproducts.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record UserDto(@NotBlank String email,
                      @NotBlank String password,
                      List<Product> productList) {

    public UserDto(User u) {
        this(u.getEmail(), u.getPassword(), u.getProductList());
    }
}
