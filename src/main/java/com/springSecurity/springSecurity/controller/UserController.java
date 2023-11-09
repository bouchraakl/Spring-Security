package com.springSecurity.springSecurity.controller;

import com.springSecurity.springSecurity.entity.User;
import com.springSecurity.springSecurity.service.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class UserController {

    public UserDetailsServiceImpl service;

    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        User user = service.findById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = service.findAll();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<String> post(@RequestBody User user) {
        try {
            service.post(user);
            return ResponseEntity.ok(String.format("O cadastro de '%s' foi realizado com sucesso.",
                    user.getUsername()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ocorreu um erro durante o cadastro: "
                    + e.getMessage());
        }
    }

    @GetMapping("/home")
    public String freeRoute(){
        return  "<h1> HOME PAGE </h1>";
    }

    @GetMapping("/admin")
    public String admin(){
        return  "<h1> ADMIN PAGE </h1>";
    }

    @GetMapping("/user-register")
    public String user(){
        return  "<h1> USER PAGE </h1>";
    }


}
