package ru.chuikov.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.chuikov.entity.User;

public interface UserService extends UserDetailsService,CommonService<User> {

}
