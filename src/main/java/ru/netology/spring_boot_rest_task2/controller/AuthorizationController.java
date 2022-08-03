package ru.netology.spring_boot_rest_task2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import ru.netology.spring_boot_rest_task2.model.Authorities;
import ru.netology.spring_boot_rest_task2.model.User;
import ru.netology.spring_boot_rest_task2.exception.InvalidCredentials;
import ru.netology.spring_boot_rest_task2.exception.UnauthorizedUser;
import ru.netology.spring_boot_rest_task2.service.AuthorizationService;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities(user);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCredentials.class)
    String resolveInvalidCredentials() {
        return "User name or password is empty";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UnauthorizedUser.class)
    String resolveUnauthorizedUser() {
        return "Unknown user";
    }
}