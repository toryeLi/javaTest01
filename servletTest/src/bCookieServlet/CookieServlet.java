package bCookieServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet(name = "CookieServlet" ,urlPatterns = "/cookieSer")
public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入cookieSer");
        String admin = getValueByKey(request, "admin");
        if (admin != null) {
            System.out.println(URLDecoder.decode(admin,"UTF-8"));//URL加密
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }

    /**
     *根据key返回cookies中的value
     * @param request
     * @param key
     * @return
     */
    private String getValueByKey(HttpServletRequest request, String key){
        Cookie[] cookies = request.getCookies();
        if(null!=cookies&&cookies.length>0){
        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie=cookies[i];
            if(cookie.getName().equals(key)){
                return cookie.getValue();
            }
        }}
        return null;
    }

}
