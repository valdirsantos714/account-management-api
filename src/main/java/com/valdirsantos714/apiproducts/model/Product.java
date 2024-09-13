package com.valdirsantos714.apiproducts.model;

import com.valdirsantos714.apiproducts.payloads.ProductDto;
import com.valdirsantos714.apiproducts.model.enums.Category;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String productCode;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Double price;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public Product(ProductDto productDto) {
        this.productCode = productDto.productCode();
        this.name = productDto.name();
        this.quantity = productDto.quantity();
        this.price = productDto.price();
        this.category = productDto.category();
        this.user = productDto.user();
    }
}
