package controller;

import DAO.DiscountCode.DiscountCodeDAO;
import DAO.DiscountCode.IDiscountCodeDAO;
import DAO.Dish.DishDAO;
import DAO.Dish.IDishDAO;
import DAO.Tag.ITagDAO;
import DAO.Tag.TagDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RestaurantServlet", urlPatterns = "/restaurant")
public class RestaurantServlet extends HttpServlet {
    private IDishDAO dishDAO = new DishDAO();
    private IDiscountCodeDAO discountCodeDAO = new DiscountCodeDAO();
    private ITagDAO tagDAO = new TagDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";}
        switch (action){
            case "create":

                break;
            case "edit":

                break;
            case "delete":

                break;
            case "find":

                break;
            default:
                listUser(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
