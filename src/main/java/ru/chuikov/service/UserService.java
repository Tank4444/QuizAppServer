package ru.chuikov.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.chuikov.entity.User;

import java.util.Optional;

public interface UserService extends UserDetailsService,CommonService<User> {
    User getUserByEmail(String email);

}
