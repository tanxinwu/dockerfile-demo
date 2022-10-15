package com.base.dockerfiledemo;


import com.base.dockerfiledemo.model.Step;
import com.base.dockerfiledemo.service.StepService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DockerfileDemoApplicationTests {
        @Autowired
        private StepService stepService;
        @Test
        public String test(){
            Step step  = new Step();
            step.setCode("123");
            stepService.insert(step);
            return "success";
        }
}
