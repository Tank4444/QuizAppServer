package ru.chuikov.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.chuikov.entity.User;
import ru.chuikov.service.UserService;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/reg")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Map> addUser( @RequestBody User user){
        var user1 =userService.getUserByEmail(user.getEmail());
        if(user1.isPresent()) return new ResponseEntity<>(Collections.singletonMap("status","User with this email present"), HttpStatus.BAD_REQUEST);
        userService.add(user);
        return new ResponseEntity<>(Collections.singletonMap("status","User created"), HttpStatus.OK);
    }

}
