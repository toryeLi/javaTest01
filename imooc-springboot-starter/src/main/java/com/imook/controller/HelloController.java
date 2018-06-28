package com.imook.controller;

import com.imook.pojo.LessJSONResult;
import com.imook.pojo.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 该类必须在com.imook包下，否则访问不成功
 */
@RestController
public class HelloController {
    @Autowired
    private Resource resource;
    @RequestMapping("/hello")
    public Object hello(){
        return "hello springboot~~~";
    }
    @RequestMapping("/getResource")
    public LessJSONResult getResource(){
        Resource bean=new Resource();
        BeanUtils.copyProperties(resource,bean);
        LessJSONResult ok = LessJSONResult.ok(bean);
        return ok;
    }
}
