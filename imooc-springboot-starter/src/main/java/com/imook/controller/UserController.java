package com.imook.controller;

import com.imook.pojo.LessJSONResult;
import com.imook.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 该类必须在com.imook包下，否则访问不成功
 */
   @RestController //@Controller+@ResponseBody
   // @Controller
    @RequestMapping("/user")
public class UserController {

    @RequestMapping("/getUser")
   // @ResponseBody//代表返回的是JS字符串，或者是js对象
    public User hello(){
        User u=new User();
        u.setName("tor6666ey");
        u.setAge(30);
        u.setBirthday(new Date());
        u.setPassword("123是是是456");
        return u;
    }
    @RequestMapping("/getUserJson")
  //  @ResponseBody//代表返回的是JS字符串，或者是js对象
    public LessJSONResult getUser(){
        User u=new User();
        u.setName("torey22");
        u.setAge(30);
        u.setBirthday(new Date());
        u.setPassword("123456");
        LessJSONResult ok = LessJSONResult.ok(u);

        return ok;
    }
}
