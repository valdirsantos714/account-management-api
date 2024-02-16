package com.valdirsantos714.apiproducts.entities;

import com.valdirsantos714.apiproducts.dto.ProductDto;
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

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "id_account")
    private Account account;

    public Product(ProductDto productDto) {
        this.name = productDto.name();
        this.quantity = productDto.quantity();
        this.price = productDto.price();
    }
}
