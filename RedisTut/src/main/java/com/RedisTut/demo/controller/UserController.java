package com.RedisTut.demo.controller;

import com.RedisTut.demo.Animal;
import com.RedisTut.demo.entity.User;
import com.RedisTut.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "Deleted user with id: " + id;
    }

    @GetMapping("/do/{id}")                 // this example is for checking if the serializer is working for polymorphic classes and how it is storing it in the redis cache
    public Animal action(@PathVariable int id) {
        return userService.getAnimal(id);
    }


}


