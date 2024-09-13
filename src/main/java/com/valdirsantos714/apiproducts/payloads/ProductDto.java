package com.valdirsantos714.apiproducts.payloads;

import com.valdirsantos714.apiproducts.model.Product;
import com.valdirsantos714.apiproducts.model.User;
import com.valdirsantos714.apiproducts.model.enums.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductDto(@NotBlank(message = "Não pode ser null o código") String productCode,
                         @NotBlank(message = "Não pode ser null o name") String name,
                         @NotNull(message = "Não pode ser null a quantity") Integer quantity,
                         @NotNull(message = "Não pode ser null o price") Double price,
                         @NotNull(message = "Não pode ser null a category") Category category,
                         User user) {

    public ProductDto(Product p) {
        this(p.getProductCode(), p.getName(), p.getQuantity(), p.getPrice(), p.getCategory(), p.getUser());
    }
}
