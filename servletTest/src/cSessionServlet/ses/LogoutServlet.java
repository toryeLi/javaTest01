package cSessionServlet.ses;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogoutServlet",urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //获取当前会话的session
        HttpSession session = request.getSession();
       // session.setMaxInactiveInterval(5);
        System.out.println("logoutServlet进入");
        //移除指定key的元素
       // session.removeAttribute("account");
        //移除当前会话的所有session
        session.invalidate();
        response.sendRedirect("success");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
