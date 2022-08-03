package ru.netology.spring_boot_rest_task2.service;
import ru.netology.spring_boot_rest_task2.model.Authorities;
import ru.netology.spring_boot_rest_task2.model.User;
import ru.netology.spring_boot_rest_task2.exception.InvalidCredentials;
import ru.netology.spring_boot_rest_task2.exception.UnauthorizedUser;
import ru.netology.spring_boot_rest_task2.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository repository;

    public AuthorizationService(UserRepository repository) {
        this.repository = repository;
    }

    public List<Authorities> getAuthorities(User user) {

        if (isEmpty(user.getName()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = repository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }


}