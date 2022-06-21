package ru.chuikov.controller.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.chuikov.entity.User;

@RestController
@RequestMapping(path = {"/user"})
public class UserController {


    @GetMapping
    public ResponseEntity testUser(@AuthenticationPrincipal User user){
        System.out.println("User with id = "+user.getId()+" connected");
        return new ResponseEntity(HttpStatus.OK);
    }

}
