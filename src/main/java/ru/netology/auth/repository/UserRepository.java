package ru.netology.auth.repository;

import org.springframework.stereotype.Repository;
import ru.netology.auth.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class UserRepository {
    private CopyOnWriteArrayList<User> users = new CopyOnWriteArrayList<>();

    public UserRepository() {
        final var authorities = List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        final var user = new User("user", "password", authorities);
        users.add(user);
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        final var searchUser = new User(user, password);
        final var userFromRepo = users.stream().filter(u -> u.equals(searchUser)).findFirst();
        return userFromRepo.map(User::getAuthorities).orElse(null);
    }
}
