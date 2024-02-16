package com.valdirsantos714.apiproducts.controllers;

import com.valdirsantos714.apiproducts.dto.UserDto;
import com.valdirsantos714.apiproducts.entities.User;
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
    public ResponseEntity<List<User>> findAllUsers() {
        List<User> list = userService.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findByIdUser (@PathVariable Long id) {
        User user = userService.findById(id);

        return ResponseEntity.ok().body(user);

    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userDto));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody @Valid UserDto userDto) {
        var user = new User(userDto);
        user = userService.update(id, userDto);

        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable  Long id) {
        userService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
