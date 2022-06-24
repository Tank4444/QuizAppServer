package ru.chuikov.controller.api;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.chuikov.entity.User;
import ru.chuikov.entity.UserRole;
import ru.chuikov.service.UserService;

import java.util.Collections;

@RestController
@RequestMapping(path = "/api/reg")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping(
            //consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public ResponseEntity addUser(@RequestBody SimpleUserInfo info){
        var user =userService.getUserByEmail(info.username);
        if(user!=null) return new ResponseEntity<>(Collections.singletonMap("status","User with this email present"), HttpStatus.BAD_REQUEST);
        User newUser = new User(info.username,info.password,UserRole.USER);
        userService.add(newUser);
        return new ResponseEntity<>(Collections.singletonMap("status","User created"), HttpStatus.OK);
    }
    @NoArgsConstructor
    public static class SimpleUserInfo{
        public String username;
        public String password;

    }

}
