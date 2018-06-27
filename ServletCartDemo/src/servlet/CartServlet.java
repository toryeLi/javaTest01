package servlet;

import com.entity.Cart;
import com.entity.Items;
import dao.ItemDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CartServlet extends HttpServlet {
    private String action;//表示购物车的动作，add,show ,delete
    private ItemDAO itemDAO=new ItemDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        if (req.getParameter("action") != null) {//购物车的动作
             this.action = req.getParameter("action");
             //如果是添加商品
            if (action.equalsIgnoreCase("add")) {
                if (addToCart(req,resp)) {
                    //商品添加成功
                    req.getRequestDispatcher("/success.jsp").forward(req,resp);
                }else {
                    //商品添加失败
                    req.getRequestDispatcher("/failure.jsp").forward(req,resp);
                }
            }
            //如果是显示购物车
            if (action.equalsIgnoreCase("show")) {
                req.getRequestDispatcher("/car.jsp").forward(req,resp);
            }
            //如果是执行删除购物车中的商品
            if (action.equalsIgnoreCase("delete")) {
                if (deleteFromCart(req,resp)) {
                    req.getRequestDispatcher("/cart.jsp").forward(req,resp);
                }else {
                    req.getRequestDispatcher("/cart.jsp").forward(req,resp);
                }
            }
        }
    }

    /**
     * 添加商品进购物车
     * @param req
     * @param resp
     * @return
     */
    private boolean addToCart(HttpServletRequest req, HttpServletResponse resp){
        String id=req.getParameter("id");
        String number=req.getParameter("num");
        Items item=itemDAO.getItemsById(Integer.parseInt(id));
       // resp.addCookie("");

        //是否是第一次给购物车添加商品，需要给session中创建一个新的购物车对象
        if (req.getSession().getAttribute("cart")==null) {
            Cart cart=new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        Cart cart=(Cart) req.getSession().getAttribute("cart");
        if (cart.addGoodsInCart(item,Integer.parseInt(number))) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * 从购物车中删除商品
     * @param req
     * @param resp
     * @return
     */
    private boolean deleteFromCart(HttpServletRequest req, HttpServletResponse resp){
        String id=req.getParameter("id");
        Cart cart=(Cart)req.getSession().getAttribute("cart");
        Items itemsById = itemDAO.getItemsById(Integer.parseInt(id));
        if (cart.removeGoodsFromCart(itemsById)) {
            return true;
        }else {
            return false;
        }
    }
}
