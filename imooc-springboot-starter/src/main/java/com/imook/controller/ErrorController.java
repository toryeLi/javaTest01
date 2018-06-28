package com.imook.controller;

import com.imook.pojo.LessJSONResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("err")
public class ErrorController {
    @RequestMapping("/error")
    public String errordd(ModelMap map){
        int a=1/0;
        map.addAttribute("name","thymeleaf_test测试");
        return "thymeleaf/index";
    }
    @RequestMapping("/ajaxError")
    public String ajaxError(ModelMap map){
        return "thymeleaf/ajaxerror";
    }
    @RequestMapping("/getAjaxerror")
    @ResponseBody
    public LessJSONResult getAjaxerror() {

        int a = 1 / 0;

        return LessJSONResult.ok();
    }
}
