package cSessionServlet.ses;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SuccessServlet",urlPatterns = "/success")
public class SuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        //获取当前登录的用户账号
        Object attribute = request.getSession().getAttribute("account");
        //session只与会话有关
        int maxInactiveInterval = request.getSession().getMaxInactiveInterval();
        // writer.write("|token:"+token);
        writer.write("<!DOCTYPE html><html lang=\"en\"><head>\n" +
                "<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\">" +
                "</head>");
        writer.write("account:"+attribute+"&nbsp;&nbsp缓存时间为"+maxInactiveInterval+"<br>");
        writer.write("token:"+request.getSession().getAttribute("token")+"<br>");
        writer.write("<a href=\"logout\">[安全退出]</a>");
        writer.write("</html>");
        writer.flush();
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
