package com.imook.controller;

import com.imook.service.UserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mybatis")
public class MyBatisCRUDController {
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private Sid sid;
    @RequestMapping("/addUser")
    public void AddUser(){
        System.out.println("addssUser");
    }
}
