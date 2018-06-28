package com.imook.exception;

import com.imook.pojo.LessJSONResult;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice //@RestControllerAdvice当程序抛出异常时，会被这个类捕获
public class ExceptionHandler
{
    //ERROR_VIEW="error"这是一个错误页面（自己定义的页面），需要配置，
    // 这个页面在templates下的error.html
    public static final String ERROR_VIEW="error";
    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response,Exception e)throws Exception{
        if(isAjax(request)){ //如果是ajax请求
            return  LessJSONResult.errorException(e.getMessage());
        }else{
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", request.getRequestURI());
            mav.setViewName(ERROR_VIEW);
            return mav;
        }
    }

    public static boolean isAjax(HttpServletRequest request){
        return (request.getHeader("X-Requested-With")!=null&&"XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
    }
}
