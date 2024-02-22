package com.valdirsantos714.apiproducts.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.valdirsantos714.apiproducts.dto.AccountDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Double balance;

    @Column(nullable = false, length = 50)
    private String bankName;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<Product> productList = new ArrayList<>();

    public Account(AccountDto accountDto) {
        this.balance = accountDto.balance();
        this.bankName = accountDto.bankName();
    }

    /*
    public void reduceBalance(Double amount) {
        double newBalance = balance -= amount;
        setBalance(newBalance);
    }*/

}
