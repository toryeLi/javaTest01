package com.imook.controller;

import com.imook.pojo.Resource;
import com.imook.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Controller
//@RestController
@RequestMapping("ft1")
public class FreemarkerController {
    @Autowired
    private Resource resource;
    @RequestMapping("/index")
    public String index(ModelMap map){
        System.out.println("进入了freemark_index");
        map.addAttribute("resource",resource);
        return "freemarker/index";
    }
    @RequestMapping("center")
   public String center(ModelMap map){
       User user = new User();
       user.setName("fre在emark_torey");
       user.setAge(32);
       // u.setBirthday(new Date());
     // user.setBirthday(new Date());
        System.out.println("容器为："+user.getBirthday());
       map.addAttribute("user",user);
       return "freemarker/center/center";
   }
}
