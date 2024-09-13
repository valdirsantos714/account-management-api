package com.valdirsantos714.apiproducts.repositories;

import com.valdirsantos714.apiproducts.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
