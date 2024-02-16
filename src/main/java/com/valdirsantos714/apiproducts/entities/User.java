package com.valdirsantos714.apiproducts.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.valdirsantos714.apiproducts.dto.UserDto;
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
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false, length = 15)
    private String sex;

    @Column(nullable = false, length = 70)
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Account> accountList = new ArrayList<>();

    public User (UserDto userDto) {
        this.name = userDto.name();
        this.age = userDto.age();
        this.sex = userDto.sex();
        this.email = userDto.email();
    }
}
