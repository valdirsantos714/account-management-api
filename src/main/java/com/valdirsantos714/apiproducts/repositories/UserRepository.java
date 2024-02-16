package com.valdirsantos714.apiproducts.repositories;

import com.valdirsantos714.apiproducts.entities.Account;
import com.valdirsantos714.apiproducts.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
