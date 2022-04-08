package controller;

import DAO.Dish.DishDAO;
import DAO.Dish.IDishDAO;
import DAO.collab.CollabDAO;
import DAO.deal.DealDAO;
import DAO.deal.IDealDAO;
import DAO.restaurant.IRestaurantDAO;
import DAO.restaurant.RestaurantDAO;
import model.Collab;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RegistrationCollab", value = "/RegistrationCollab")

public class RegistrationCollab extends HttpServlet{

    private IDealDAO dealDAO = new DealDAO();
    private IRestaurantDAO restaurantDAO = new RestaurantDAO();
    private IDishDAO dishDAO = new DishDAO();
    private CollabDAO collabDAO;
    public void init(){
        collabDAO = new CollabDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action="";
        }
        switch (action){
            case "create":
                showForm(request, response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
            default:
                listCollab(request, response);
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Collab collab = collabDAO.findById(id);
        RequestDispatcher requestDispatcher= request.getRequestDispatcher("collab/edit.jsp");
        request.setAttribute("collab1",collab);
        requestDispatcher.forward(request,response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        collabDAO.delete(id);
        List<Collab> collabList = collabDAO.selectAllCollab();
        request.setAttribute("collabList",collabList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("collab/list.jsp");
        dispatcher.forward(request,response);
    }

    private void listCollab(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Collab> collabList = collabDAO.selectAllCollab();
        request.setAttribute("collabList",collabList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("collab/list.jsp");
        dispatcher.forward(request,response);
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("collab/create.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action="";
        }
        switch (action){
            case "create":
               save(request, response);
               break;
            case "edit":
                updateCollab(request,response);
                break;

        }
    }

    private void deleteCollab(HttpServletRequest request, HttpServletResponse response) {

    }

    private void updateCollab(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Collab collab = new Collab(id,name,email,password);
        collabDAO.update(collab);
        request.setAttribute("messege","The collab was updated");
        RequestDispatcher dispatcher = request.getRequestDispatcher("collab/edit.jsp");
        dispatcher.forward(request,response);
    }

    private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String collabName = request.getParameter("name");
        String collabEmail = request.getParameter("email");
        String collabPassword = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        if (confirmPassword.equals(collabPassword)){
            Collab newCollab = new Collab(collabName, collabEmail, collabPassword);
            collabDAO.save(newCollab);
            request.setAttribute("deal", dealDAO.findAll());
            request.setAttribute("dishes", dishDAO.findAll());
            request.setAttribute("restaurantList", restaurantDAO.findAll());
            RequestDispatcher dispatcher= request.getRequestDispatcher("collab/success.jsp");
            request.setAttribute("messageSuccess", "New collab was created");
            dispatcher.forward(request,response);
        }else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("collab/createFailed.jsp");
            request.setAttribute("message", "Password does not match");
            dispatcher.forward(request,response);
        }
    }
}
