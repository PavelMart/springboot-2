package ru.netology.auth.controller;

import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.auth.model.AuthUser;
import ru.netology.auth.model.User;
import ru.netology.auth.repository.Authorities;
import ru.netology.auth.service.AuthService;

import java.util.List;

@Validated
@RestController
public class AuthController {
    AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@AuthUser @Valid User user) {
        return service.getAuthorities(user);
    }
}
