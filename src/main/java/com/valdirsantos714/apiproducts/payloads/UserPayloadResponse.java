package com.valdirsantos714.apiproducts.payloads;

import com.valdirsantos714.apiproducts.model.Product;
import com.valdirsantos714.apiproducts.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record UserPayloadResponse(Long id,
                                  String email,
                                  String password,
                                  List<Product> productList) {

    public UserPayloadResponse(User u) {
        this(u.getId(), u.getEmail(), u.getPassword(), u.getProductList());
    }
}
