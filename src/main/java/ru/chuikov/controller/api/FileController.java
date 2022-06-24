package ru.chuikov.controller.api;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.chuikov.entity.User;
import ru.chuikov.service.FileService;
import ru.chuikov.service.UserService;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/api/file")
@Log4j2
public class FileController {
    @Autowired
    private UserService userService;
    @Autowired
    private FileService fileService;


    @GetMapping(path = "/add")
    public ResponseEntity addFile(@AuthenticationPrincipal User user, @RequestParam MultipartFile file) throws IOException {
        log.info("user {} upload file {}",user.getEmail(),file.getName());
        fileService.addFile(file.getBytes(),user.getId());
        return ResponseEntity.ok(Collections.singletonMap("Status","OK"));
    }
    @GetMapping(path = "/")
    @Transactional
    public  ResponseEntity listFiles(@AuthenticationPrincipal User user){
        log.info("user {} request list of files",user.getEmail());
        var list = fileService.getListFilesByUserId(user.getId());
        return ResponseEntity.ok(list);
    }
}
