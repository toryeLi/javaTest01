package bCookieServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@WebServlet(name = "myServlet", urlPatterns = "/my")
public class myServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //设置缓存时间，get方法第一次可以访问到这里，后续就不在从后台拿数据了
        response.setHeader("Cache-Control", "max-age=7200");
        //获取请求头中key组成的集合
        Enumeration<String> headerNames = request.getHeaderNames();
        System.out.println("request.getHeaderNames()请求头中所有的集合为，开始：");
        while (headerNames.hasMoreElements()) {
            String s = headerNames.nextElement();
            System.out.println(s);
        }
        System.out.println("request.getHeaderNames()请求头中所有的集合为，结束");

        System.out.println("------------------------------------------");

        // 时间
        System.out.println(request.getDateHeader("If-Modified-Since"));
        long time = this.getLastModified(request);
        System.out.println(time + "=======================");

        System.out.println("POST");

        System.out.println("disable设置的值：" + request.getParameter("disabledTest"));
        System.out.println("readonly设置的值：" + request.getParameter("readonlyTest"));
        //获取下拉列表中多个选择的内容
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println("爱好是：" + Arrays.toString(hobbies));
        System.out.println("URL后面的参数：" + request.getParameter("token"));
        System.out.println("后续可以根据前端的name,也就是这个request.getParameterNames()或者request.getParameterMap()通过反射，映射到实体类");
        //后续听到容器，就是map集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println("request.getParameterMap()遍历开始：");

        for (Map.Entry<String, String[]> map : parameterMap.entrySet()) {
            String key = map.getKey();
            String[] value = map.getValue();
            System.out.println("key=" + key + "; values=" + Arrays.toString(value));
        }
        System.out.println("request.getParameterMap()遍历结束：");
        //获取客户端提交的数据对应key组成枚举类型
        Enumeration<String> parameterNames = request.getParameterNames();
        System.out.println("getParameterNames的值开始有：");
        while (parameterNames.hasMoreElements()) {
            String s = parameterNames.nextElement();
            System.out.println(s);
        }
        System.out.println("getParameterNames结束");
        System.out.println("后续可以根据前端的name,也就是这个request.getParameterNames()或者request.getParameterMap()通过反射，映射到实体类");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet请求");
        doPost(request, response);
    }
}
