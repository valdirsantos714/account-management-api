package com.valdirsantos714.apiproducts.services;

import com.valdirsantos714.apiproducts.dto.ProductDto;
import com.valdirsantos714.apiproducts.entities.Product;
import com.valdirsantos714.apiproducts.repositories.ProductRepository;
import com.valdirsantos714.apiproducts.services.exceptions.DataBaseException;
import com.valdirsantos714.apiproducts.services.exceptions.ResourceNotFound;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Product save(ProductDto productDto) {

        var product = new Product(productDto);

        return productRepository.save(product);
    }

     /*
    @Transactional
    public Product save(Product product, Account account) {

        double amount = product.getPrice() * product.getQuantity();

        if (amount <= account.getBalance()) {

            account.reduceBalance(amount);

            accountRepository.save(account);

            return productRepository.save(product);

        } else {
            throw new DataBaseException("Insufficient balance error");
        }
    }*/


    public List<Product> findAll() {
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    public Product findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow(() -> new ResourceNotFound(id));
    }

    public Product update(Long id, ProductDto updatedProduct) {
        try {
            Product product = productRepository.getReferenceById(id);

            updateData(product, updatedProduct);

            return productRepository.save(product);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFound(id);
        }
    }

    private void updateData(Product outdatedProduct, ProductDto updatedProduct) {
        outdatedProduct.setName(updatedProduct.name());
        outdatedProduct.setQuantity(updatedProduct.quantity());
        outdatedProduct.setPrice(updatedProduct.price());
    }

    @Transactional
    public void delete(Long id) {
        try {
            productRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFound(id);

        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }
}
