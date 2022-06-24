package ru.chuikov.controller.user;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.chuikov.entity.User;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = {"/api/user"})
@Log4j2
public class UserController {


    @GetMapping(path = {"/",""})
    public ResponseEntity testUser(@AuthenticationPrincipal User user){
        log.info("User with id = "+user.getId()+" connected");
        return ResponseEntity.ok(Collections.singletonMap("Id",user.getId()));
    }


}
