package controller;

import DAO.collab.CollabDAO;
import model.Collab;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "RegistrationCollab", value = "/RegistrationCollab")
public class RegistrationCollab extends HttpServlet{
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
            default:
                listCollab(request, response);
                break;
        }
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
        }
    }

    private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String collabName = request.getParameter("name");
        String collabEmail = request.getParameter("email");
        String collabPassword = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        if (confirmPassword.equals(collabPassword)){
            Collab newCollab = new Collab(collabName, collabEmail, collabPassword);
            collabDAO.save(newCollab);
            RequestDispatcher dispatcher= request.getRequestDispatcher("collab/success.jsp");
            request.setAttribute("messageSuccess", "New collab was created");
            dispatcher.forward(request,response);
        }else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("collab/create.jsp");
            dispatcher.forward(request,response);
        }

//        RequestDispatcher dispatcher = request.getRequestDispatcher("collab/create.jsp");
//        dispatcher.forward(request,response);
    }
}
