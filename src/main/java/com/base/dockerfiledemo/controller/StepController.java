package com.base.dockerfiledemo.controller;

import com.alibaba.fastjson.JSON;
import com.base.dockerfiledemo.model.Step;
import com.base.dockerfiledemo.service.StepService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/step/")
@AllArgsConstructor
@Slf4j
public class StepController {

    private final  StepService stepService;

    @PostMapping("add")
    public int add(@RequestBody Step record){
        log.info("新增参数：{}", JSON.toJSONString(record));
        return stepService.insert(record);
    }
}
