package com.imook.controller;

import com.imook.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("th")
public class thymeleafController {
    @RequestMapping("/index")
public String index(ModelMap map){
   map.addAttribute("name","thymeleaf_test测试1");
        map.addAttribute("name","thymeleaf_test测试2");
    return "thymeleaf/index";
}
@RequestMapping("test")
public String test(ModelMap map){
    User u = new User();
    u.setName("superadmin");
    u.setAge(10);
    u.setPassword("123465");
    u.setBirthday(new Date());
    u.setDesc("<font color='green'><b>hello imooc</b></font>");

    map.addAttribute("user", u);

    User u1 = new User();
    u1.setAge(19);
    u1.setName("imooc");
    u1.setPassword("123456");
    u1.setBirthday(new Date());

    User u2 = new User();
    u2.setAge(17);
    u2.setName("LeeCX");
    u2.setPassword("123456");
    u2.setBirthday(new Date());

    List<User> userList = new ArrayList<>();
    userList.add(u);
    userList.add(u1);
    userList.add(u2);

    map.addAttribute("userList", userList);
        return "thymeleaf/test";
}
@RequestMapping("postform")
public String postform(User u){
    System.out.println("姓名：" + u.getName());
    System.out.println("年龄：" + u.getAge());
    return "redirect:/th/test";
}
}
