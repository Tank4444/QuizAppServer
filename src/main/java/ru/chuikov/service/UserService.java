package ru.chuikov.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.chuikov.entity.actor.User;

public interface UserService extends UserDetailsService,CommonService<User> {
    User getUserByEmail(String email);

}
