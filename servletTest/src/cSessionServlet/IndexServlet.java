package cSessionServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IndexServlet",urlPatterns = "/sessionIndex")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取访问的内容路径:/ 根路径
        String contextPath = request.getContextPath();
        System.out.println("根路径为："+contextPath);
        //URL地址重写
      //  String s = response.encodeURL(contextPath + "/session");
        String s = response.encodeRedirectURL(contextPath + "/session");
        System.out.println("URL地址重写后："+s);
        //重定向
        response.sendRedirect(s);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
