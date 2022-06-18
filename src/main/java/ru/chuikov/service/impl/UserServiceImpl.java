package ru.chuikov.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.chuikov.entity.User;
import ru.chuikov.repository.UserRepository;
import ru.chuikov.service.UserService;

import java.util.Collection;
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public void save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new UsernameNotFoundException("User with id ="+id+" not found"));
    }

    @Override
    public User updateById(User user) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteById(User user) {

    }

    @Override
    public Collection<User> getAll() {
        return null;
    }
}
