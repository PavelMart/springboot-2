package ru.netology.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.auth.repository.Authorities;
import ru.netology.auth.service.AuthService;

import java.util.List;

@RestController
public class AuthController {
    AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }
}
