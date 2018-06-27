package apiFowordRedirect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InnerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("==========请求servlet的处理方法============");
        //获取请求对象的转发器对象
        /*  RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/inner.html");
        //转发请求和响应对象
        requestDispatcher.forward(req,resp);
        */
        //设置request的值
        req.setAttribute("inner","InnerServlet--->requestValue");
        System.out.println(req.getRequestURI());
        System.out.println(req);
        //重定向到外部页面显示
        req.getRequestDispatcher("ui").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
