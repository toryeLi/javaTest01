package cSessionServlet.thread;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 模拟servlet线程安全的问题
 *
 */
@WebServlet(name = "ThreadServlet",urlPatterns = "/ts")
public class ThreadServlet extends HttpServlet {
    /**
     * name 是实例变量，所有的实例共享这个name(所有方法的共享变量）,
     * 因为Servlet是第一次访问的时候才创建，后续再访问的时候，
     * 就不在创建了，单例的，所以这个name是所有方法的共享变量
     * 解决servlets线程安全的方法：
     * 1 在servlet中不要定义成员变量（最推荐的方式）
     * 2 加锁synchronized/lock(),是可以解决线程安全的问题，但是对于系统开销非常大
     * 3 实现SingleThreadModel接口，这个每次访问的时候都会开启一个新的Servlet线程来访问
     */
    //private String name;//

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
synchronized (this){
        //获取用户的名称
        String name = request.getParameter("name");
        //让线程出现安全问题
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < name.length(); i++) {
        char ch=name.charAt(i);
            System.out.print(ch+" ");
        }
        System.out.println();}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
