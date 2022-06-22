package ru.chuikov.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.chuikov.entity.User;
import ru.chuikov.repository.UserRepository;
import ru.chuikov.service.UserService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service @AllArgsConstructor @Transactional @Log4j2
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    private final PasswordEncoder encoder;

    private final String TAG_LOG="USER_SERVICE";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("load user by username = {}",username);
        var user = getUserByEmail(username);
        //return getUserByEmail(username).orElseThrow(()->new UsernameNotFoundException("User with name "+username+" not found"));
        if(user.isPresent()) {
            log.info("user loaded with email {} and password {}",user.get().getEmail(),user.get().getPassword());
            return new org.springframework.security.core.userdetails.User(
                    user.get().getUsername(),
                    user.get().getPassword(),
                    new ArrayList<>()
            );
        }
        else throw  new UsernameNotFoundException("User with name "+username+" not found");

    }

    @Override
    public void add(User user) {

        user.setPassword(encoder.encode(user.getPassword()));
        log.info("add user with username {} and password = {}",user.getEmail(),user.getPassword());
        userRepository.save(user);
    }

    @Override
    public Optional<User> getById(Long id) {
        log.info("get user with id {}",id);
        return Optional.of(userRepository.findById(id).orElseThrow(()-> new UsernameNotFoundException("User with id ="+id+" not found")));
    }

    @Override
    public void updateById(User user) {
        User oldUser = getUserByEmail(user.getEmail()).orElseThrow(()->new UsernameNotFoundException("User with name "+user.getEmail()+" not found"));
        oldUser = user;
        userRepository.saveAndFlush(oldUser);
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
