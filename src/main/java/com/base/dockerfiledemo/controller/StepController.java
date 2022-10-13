package com.base.dockerfiledemo.controller;

import com.base.dockerfiledemo.model.Step;
import com.base.dockerfiledemo.service.StepService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/step/")
@AllArgsConstructor
public class StepController {

    private final  StepService stepService;

    @PostMapping("add")
    public int add(@RequestBody Step record){
        return stepService.insert(record);
    }
}
