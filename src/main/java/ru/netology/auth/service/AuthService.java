package ru.netology.auth.service;

import org.springframework.stereotype.Service;
import ru.netology.auth.exception.InvalidCredentials;
import ru.netology.auth.exception.UnauthorizedUser;
import ru.netology.auth.model.User;
import ru.netology.auth.repository.Authorities;
import ru.netology.auth.repository.UserRepository;

import java.util.List;

@Service
public class AuthService {
    UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        if (isEmpty(user)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user.getUser());
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(User user) {
        return isEmpty(user.getUser()) || isEmpty(user.getPassword());
    }
}
