package ru.netology.spring_boot_rest_task2.repository;

import org.springframework.stereotype.Repository;
import ru.netology.spring_boot_rest_task2.model.Authorities;
import ru.netology.spring_boot_rest_task2.model.User;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    final Map<User, List<Authorities>> users =
            new ConcurrentHashMap<>(Map.of(new User("Vasya", "Vasya123"),
                    List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE)));

    public List<Authorities> getUserAuthorities(User user) {return users.get(user);}
}