package com.base.dockerfiledemo.controller;

import com.alibaba.fastjson.JSON;
import com.base.dockerfiledemo.model.Step;
import com.base.dockerfiledemo.service.StepService;
import com.base.dockerfiledemo.vo.UpdateRequestVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("update")
    public int update (@RequestBody UpdateRequestVO updateRequestVO){
        log.info("修改参数：{}",JSON.toJSONString(updateRequestVO));
        Step update = new Step();
        BeanUtils.copyProperties(updateRequestVO,update);
        return  stepService.updateByPrimaryKey(update);
    }

}
