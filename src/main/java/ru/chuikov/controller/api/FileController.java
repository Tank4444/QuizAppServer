package ru.chuikov.controller.api;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.chuikov.entity.actor.User;
import ru.chuikov.service.FileService;
import ru.chuikov.service.UserService;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Collections;
import java.util.Objects;

@RestController
@RequestMapping(path = "/api/file")
@Log4j2
public class FileController {
    @Autowired
    private UserService userService;
    @Autowired
    private FileService fileService;


    @PostMapping(path = "/add")
    public ResponseEntity addFile(@AuthenticationPrincipal User user, @RequestParam MultipartFile file) throws IOException {
        log.info("user {} upload file {}",user.getEmail(),file.getName());
        fileService.addFile(file.getBytes(),user.getId());
        return ResponseEntity.ok(Collections.singletonMap("Status","OK"));
    }
    @PostMapping(path = "/del/{id}")
    public ResponseEntity delFile(@AuthenticationPrincipal User user,@PathVariable Long id) throws IOException {
        log.info("user with id {} and username {} try remove file with id {}",user.getId(),user.getEmail(),id);
        var file = fileService.getById(id);
        if(file == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        if(!Objects.equals(file.getCreator().getId(), user.getId()))return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        fileService.deleteFile(id);
        log.info("user with id {} del file with id {}",user.getId(),id);
        return ResponseEntity.ok(null);
    }


    @GetMapping(path = "/")
    @Transactional
    public  ResponseEntity listFiles(@AuthenticationPrincipal User user){
        log.info("user {} request list of files",user.getEmail());
        var list = fileService.getListFilesByUserId(user.getId());
        return ResponseEntity.ok(list);
    }


}
