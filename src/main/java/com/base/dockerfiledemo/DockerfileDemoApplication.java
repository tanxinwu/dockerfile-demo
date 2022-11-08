package com.base.dockerfiledemo;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="com.base.dockerfiledemo.mapper")
@NacosPropertySource(dataId = "example",autoRefreshed = true)
public class DockerfileDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerfileDemoApplication.class, args);
    }

}
