package com.imook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * SpringBoot的主类，运行这里，就代表启动了整个项目
 */
@SpringBootApplication
//扫描mybatis mapper 包路径
@MapperScan(basePackages = "com.imook.mapper")
//扫描所需要的包，包含一些自用的工具类包 所在的路径
@ComponentScan(basePackages ={"com.imook","org.n3r.idworker"})
public class ImoocApplication {
    public static void main(String[] args) {
        SpringApplication.run(ImoocApplication.class, args);
    }
}
