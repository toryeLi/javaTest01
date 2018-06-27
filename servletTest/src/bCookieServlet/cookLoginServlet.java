package bCookieServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 设置cookie
 */
@WebServlet(name = "cookLoginServlet",urlPatterns = "/cookLogin")
public class cookLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进sss入cookLogin");
        //设置编码格式
        request.setCharacterEncoding("UTF-8");
        //获取表单提交的数据
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String chk = request.getParameter("chk");
        if (chk != null) {//勾选了记住密码
            //创建一个Cookie对象保存用户名和密码，在实际开发中，应该加密
            Cookie cookie = new Cookie("sel", account + "_" + password);
            //设置cookie的有效时间，秒为单位
            cookie.setMaxAge(60);
            //设置域名，如果设置了域名，就可以根据域名来访问

            //访问路径,
            cookie.setPath("/vip");
            //把服务器端的cookie发送到客户端
            response.addCookie(cookie);
        }else {//未勾选
            //创建一个Cookie对象保存用户名和密码，在实际开发中，应该加密
            Cookie cookie2 = new Cookie("sel", null);//cookie马上失效

            //设置cookie的有效时间，秒为单位
            cookie2.setMaxAge(0);
            //访问路径,
            cookie2.setPath("/vip");
            //把服务器端的cookie发送到客户端
            response.addCookie(cookie2);
        }
        //登录成功,重定向到登录页面
      //  response.sendRedirect("bCookieServlet/login.html");
        response.sendRedirect("cookieSer");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
