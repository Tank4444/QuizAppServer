package ru.chuikov.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.chuikov.entity.actor.User;
import ru.chuikov.repository.actor.UserRepository;
import ru.chuikov.service.UserService;

import java.util.Collection;
import java.util.List;

@Service @Log4j2
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getByUsername(username);
        if(user!=null){
            log.info("load user email:{}; password:{};",user.getEmail(),user.getPassword());
            return user;
        }else {
            log.error("fail load user with email:{};",username);
            throw new UsernameNotFoundException("fail load user with email:"+username+";");
        }
    }

    @Override
    public User add(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        log.info("add user with username {} and password = {}",user.getEmail(),user.getPassword());
        return userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> addAll(Collection<User> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public User getById(Long id) {
        log.info("get user with id {}",id);
        User user = userRepository.getByID(id);
        if(user!=null){
            log.info("load user email:{}; password:{};",user.getEmail(),user.getPassword());
            return user;
        }else {
            log.error("fail load user with id:{};",id);
            throw new UsernameNotFoundException("fail load user with email:"+id+";");
        }
    }

    @Override
    public User update(User user) {
        User userById = userRepository.getByID(user.getId());
        if((userById!=null)&&(userById.getEmail().equals(user.getEmail()))){
            return userRepository.saveAndFlush(user);
        }else{
            throw new UsernameNotFoundException("user not found");
        }
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
    public User getUserByEmail(String email) {

        return userRepository.getByUsername(email);
    }


}
