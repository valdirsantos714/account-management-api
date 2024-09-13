package com.valdirsantos714.apiproducts.services;

import com.valdirsantos714.apiproducts.payloads.ProductDto;
import com.valdirsantos714.apiproducts.payloads.UserDto;
import com.valdirsantos714.apiproducts.model.User;
import com.valdirsantos714.apiproducts.repositories.UserRepository;
import com.valdirsantos714.apiproducts.services.exceptions.DataBaseException;
import com.valdirsantos714.apiproducts.services.exceptions.ResourceNotFound;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        List<User> list = userRepository.findAll();
        return list;
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFound(id));
    }

    @Transactional
    public User save (UserDto userDto) {
        var user = new User(userDto);
        if (userDto.productList() == null) {
            user.setProductList(new ArrayList<>());
        }
        return userRepository.save(user);
    }

    @Transactional
    public void delete(Long id) {
        try {
            userRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFound(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    public User update (Long id, UserDto userDto) {
        try {
            User user = userRepository.getReferenceById(id);
            updateData(user, userDto);

            return userRepository.save(user);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFound(id);
        }
    }

    private void updateData(User outdateUser, UserDto updatedUser) {
        outdateUser.setEmail(updatedUser.email());
        outdateUser.setPassword(updatedUser.password());
    }

    public User saveProductInListOfUser(Long idUser, ProductDto productDto) {
        var user = findById(idUser);
        var product = productService.save(productDto);

        user.getProductList().add(product);
        userRepository.save(user);

        product.setUser(user);
        productService.save(new ProductDto(product));

        return user;
    }

    public User subtractQuantity(Long idUser, Long idProduct, Integer quantity) {
        var user = findById(idUser);
        var product = productService.findById(idProduct);

        var oldQuantity = product.getQuantity();
//        var newQuantity = oldQuantity - quantity;
//        product.setQuantity(newQuantity);
        var payload = new ProductDto(product.getProductCode(), product.getName(), oldQuantity - quantity, product.getPrice(), product.getCategory(), product.getUser());
        productService.update(idProduct, payload);
//        var oldQuantity = product.getQuantity();
//        var newQuantity = oldQuantity - quantity;
//        product.setQuantity(newQuantity);
////        if (quantity >= 1 && oldQuantity >= 1 && oldQuantity >= quantity) {
////            product.setQuantity(oldQuantity -= quantity);
////        }
//

//        productService.save(new ProductDto(product));
        return userRepository.save(user);
    }
}
