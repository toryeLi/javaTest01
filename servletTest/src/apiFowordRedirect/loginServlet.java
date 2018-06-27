package apiFowordRedirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet",urlPatterns = "/login")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

           System.out.println("请求login");
        // 设置请求对象的编码格式
        request.setCharacterEncoding("UTF-8");
        // 设置响应对象的编码格式
        // resp.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 获取页面输出流.
        PrintWriter out = response.getWriter();

        // 获取用户输入的账号和密码
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        System.out.println("账号:"+account+",密码:"+password);
        out.print("<script>alert('账号:"+account +",密码:"+password+"');</script>");

        out.flush();
        out.close();

    }
}
