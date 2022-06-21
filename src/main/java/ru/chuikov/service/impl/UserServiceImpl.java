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
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;


    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = getUserByEmail(username);
        //return getUserByEmail(username).orElseThrow(()->new UsernameNotFoundException("User with name "+username+" not found"));
        if(user.isPresent()) return user.get();
        else throw  new UsernameNotFoundException("User with name "+username+" not found");

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
        User oldUser = getUserByEmail(user.getEmail()).orElseThrow(()->new UsernameNotFoundException("User with name "+user.getEmail()+" not found"));
        oldUser = user;
        userRepository.saveAndFlush(oldUser);
        return user;
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteById(User user) {
        deleteById(user.getId());
    }

    @Override
    public Collection<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByUsername(email);
    }
}
