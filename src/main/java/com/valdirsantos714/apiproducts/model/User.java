package com.valdirsantos714.apiproducts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.valdirsantos714.apiproducts.payloads.UserDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 70)
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Product> productList = new ArrayList<>();

    public User (UserDto userDto) {
        this.email = userDto.email();
        this.password = userDto.password();
        this.productList = userDto.productList();
    }
}
