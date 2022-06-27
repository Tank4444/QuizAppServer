package ru.chuikov.controller.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.chuikov.entity.actor.User;
import ru.chuikov.service.UserService;

import java.util.Collections;

@RestController
@RequestMapping(path = {"/api/user"})
@Log4j2
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/test")
    public ResponseEntity testUser(@AuthenticationPrincipal User user){
        log.info("User with id = "+user.getId()+" connected");
        return ResponseEntity.ok(Collections.singletonMap("Id",user.getId()));
    }

    @GetMapping(path = "")
    public ResponseEntity userInfo(@AuthenticationPrincipal User user){
        log.info("User info by user = {}",user.getEmail());
        return ResponseEntity.ok(user);
    }

//    @GetMapping(path = "/file/add")
//    public ResponseEntity addFile(@AuthenticationPrincipal User user, @RequestParam MultipartFile file) throws IOException {
//        log.info("user {} upload file {}",user.getEmail(),file.getName());
//        userService.addFile(file.getBytes(),user.getId());
//        return ResponseEntity.ok(Collections.singletonMap("Status","OK"));
//    }
//    @GetMapping(path = "/file")
//    @Transactional
//    public  ResponseEntity listFiles(@AuthenticationPrincipal User user){
//        log.info("user {} request list of files",user.getEmail());
//        List list = user.getFiles();
//        return ResponseEntity.ok(user.getFiles());
//    }


}
