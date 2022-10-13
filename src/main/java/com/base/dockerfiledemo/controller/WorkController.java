package com.base.dockerfiledemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class WorkController {

    private List<String> list = new ArrayList<>();
    @GetMapping()

    public String test(){
        while (true) {
            list.add("dlsdfjl");
        }
    }
}
