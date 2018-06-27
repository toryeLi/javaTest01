package apiFowordRedirect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class uiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req);
        //<meta http-equiv="content-type" content="text/html;charset=utf-8">
        //设置请求对象的编码格式
       // req.setCharacterEncoding("utf-8");
        String str="转发中request中的数据:"+req.getAttribute("inner");
        String str2="sendRedirect重定向的request中的数据:"+req.getAttribute("req");
        System.out.println(str);
        System.out.println(str2);
        String contentType="resp.setContentType(\"text/html;charset=UTF-8\");//设置响应对象的编码格式,否则浏览器会有乱码";
        resp.setContentType("text/html;charset=UTF-8");//设置响应对象的编码格式
        //输出流
        PrintWriter out = resp.getWriter();
        out.write("<!DOCTYPE html><html lang=\"en\"><head>\n" +
                "<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\">" +
                "</head>");
        out.write(contentType+"<br>");
        out.write(str+"<br>"+str2);
        out.write("</html>");
        out.flush();
        out.close();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
