package cSessionServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SessionServlet",urlPatterns = "/session")
public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //session是域对象
        //获取Session对象
        HttpSession session = request.getSession();
        //设置过期时间,以秒为单位
        session.setMaxInactiveInterval(120);
        //让当前会话的session全部失效
        session.invalidate();
        //获取SessionId
        String id = session.getId();
        System.out.println("jsessionId="+id);
        PrintWriter writer = response.getWriter();
        writer.write(id);
        writer.flush();
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
