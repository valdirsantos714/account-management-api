package com.valdirsantos714.apiproducts.controllers;

import com.valdirsantos714.apiproducts.payloads.ProductDto;
import com.valdirsantos714.apiproducts.payloads.UserDto;
import com.valdirsantos714.apiproducts.model.User;
import com.valdirsantos714.apiproducts.payloads.UserPayloadResponse;
import com.valdirsantos714.apiproducts.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity findAllUsers() {
        List<User> list = userService.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findByIdUser (@PathVariable Long id) {
        User user = userService.findById(id);

        return ResponseEntity.ok().body(user);

    }

    @PostMapping
    public ResponseEntity saveUser(@RequestBody @Valid UserDto userDto) {
        var user = userService.save(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserPayloadResponse(user));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody @Valid UserDto userDto) {
        var user = new User(userDto);
        user = userService.update(id, userDto);

        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteUser(@PathVariable  Long id) {
        userService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/product/{idUser}/{idProduct}/{quantity}")
    public ResponseEntity subtractQuantity(@PathVariable(name = "idUser") Long idUser,
                                           @PathVariable(name = "idProduct") Long idProduct,
                                           @PathVariable(name = "quantity") Integer quantity) {

        userService.subtractQuantity(idUser, idProduct, quantity);

        return ResponseEntity.status(HttpStatus.CREATED).body("new UserPayloadResponse(user)");
    }

    @PostMapping("/product/{idUser}")
    public ResponseEntity saveProduct(@PathVariable(name = "idUser") Long idUser,
                                      @RequestBody @Valid ProductDto productDto) {

        var user = userService.saveProductInListOfUser(idUser, productDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(new UserPayloadResponse(user));
    }
}
