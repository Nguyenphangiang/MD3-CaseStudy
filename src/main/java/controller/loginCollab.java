package controller;

import DAO.Dish.DishDAO;
import DAO.Dish.IDishDAO;
import DAO.collab.CollabDAO;
import DAO.deal.DealDAO;
import DAO.deal.IDealDAO;
import DAO.restaurant.IRestaurantDAO;
import DAO.restaurant.RestaurantDAO;
import entity.Account;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginCollab", value = "/LoginCollab")
public class loginCollab extends HttpServlet {
    private IDealDAO dealDAO = new DealDAO();
    private IRestaurantDAO restaurantDAO = new RestaurantDAO();
    private IDishDAO dishDAO = new DishDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("collab/loginCollab.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String collabEmail = req.getParameter("collabEmail");
        String collabPassword = req.getParameter("collabPassword");
        CollabDAO collabDAO = new CollabDAO();
        Account a = collabDAO.checkLogin(collabEmail,collabPassword);
        if (a==null){
            req.setAttribute("message", "Incorrect email or password");
            RequestDispatcher dispatcher = req.getRequestDispatcher("collab/loginCollabFailed.jsp");
            dispatcher.forward(req, resp);
        }else {
            req.setAttribute("deal", dealDAO.findAll());
            req.setAttribute("dishes", dishDAO.findAll());
            req.setAttribute("restaurantList", restaurantDAO.findAll());
            RequestDispatcher dispatcher = req.getRequestDispatcher("restaurant/forCollab/listForCollab.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
