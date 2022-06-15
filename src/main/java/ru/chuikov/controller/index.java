package ru.chuikov.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping(path = {"/",""})
public class index {

    @GetMapping
    public Map indexGet(){
        return Collections.singletonMap("Hello","world");
    }
}
