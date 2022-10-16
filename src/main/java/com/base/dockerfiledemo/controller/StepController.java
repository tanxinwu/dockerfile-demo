package com.base.dockerfiledemo.controller;

import com.alibaba.fastjson.JSON;
import com.base.dockerfiledemo.model.Step;
import com.base.dockerfiledemo.service.StepService;
import com.base.dockerfiledemo.vo.SearchRequestVO;
import com.base.dockerfiledemo.vo.UpdateRequestVO;
import com.base.dockerfiledemo.vo.response.BaseResponseVO;
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

    @RequestMapping(value = "get",method = RequestMethod.GET)
    public BaseResponseVO<Step> get(@RequestBody SearchRequestVO searchRequestVO){
        log.info("查询参数{}",JSON.toJSONString(searchRequestVO));
        Step step = stepService.selectByPrimaryKey(searchRequestVO.getId());
        BaseResponseVO<Step> responseVO = new BaseResponseVO<>(0, "查询成功", step);
        return responseVO;
    }
    @RequestMapping(value = "delete",method = RequestMethod.DELETE)
    public int delete(@RequestBody SearchRequestVO searchRequestVO){
        log.info("删除参数{}",JSON.toJSONString(searchRequestVO));
        return stepService.deleteByPrimaryKey(searchRequestVO.getId());
    }

}
