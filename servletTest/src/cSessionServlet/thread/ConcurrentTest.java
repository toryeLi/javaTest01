package cSessionServlet.thread;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConcurrentTest",urlPatterns = "/threadTest")
public class ConcurrentTest extends HttpServlet {
   // PrintWriter  output;要保证servlet线程安全，最优的办法是尽量避免使用实例变量
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String username;
        res.setContentType("text/html;charset=gb2312");
        username=req.getParameter("username");
        PrintWriter  output=res.getWriter();
        try {
            Thread.sleep(100);
            output.println("用户名："+username+"<br>");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (output != null) {
                output.flush();
                output.close();
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
