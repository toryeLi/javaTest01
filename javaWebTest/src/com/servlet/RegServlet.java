package com.servlet;

import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegServlet extends HttpServlet {
    public RegServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        User u=new User();
        String username,mypassword,gender,email,introduce,isAccpet;
        Date birthday;
        String[] favorites;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try{
            //接收表单提交的订单
            username=request.getParameter("username");
            mypassword=request.getParameter("mypassword");
            gender=request.getParameter("gender");
            email=request.getParameter("email");
            introduce=request.getParameter("introduce");
            birthday=sdf.parse(request.getParameter("birthday"));
            if (request.getParameterValues("isAccpet") != null) {
                isAccpet=request.getParameter("isAccpet");
            }else {
                isAccpet="false";
            }
            //用来获取多个复选按钮的值
            favorites=request.getParameterValues("favorites");
            u.setUsername(username);
            u.setMypassword(mypassword);
            u.setGender(gender);
            u.setEmail(email);
            u.setFavorite(favorites);
            //regUser.getFavorite()

            u.setIntroduce(introduce);
            if (isAccpet.equalsIgnoreCase("true")) {
                u.setAcc(true);
            }else {
                u.setAcc(false);
            }
            u.setBirthday(birthday);
//把注册成功的用户对象保存到session中
            request.getSession().setAttribute("regUser",u);
            //跳转
            request.getRequestDispatcher("../userinfo.jsp").forward(request,response);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
