package controller;

import DAO.Restaurant.RestaurantDAO;
import DAO.deal.DealDAO;
import DAO.deal.IDealDAO;
import DAO.Restaurant.IRestaurantDAO;

import model.Deal;
import model.Restaurant;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;

@WebServlet(name = "RestaurantServlet", urlPatterns = "/restaurant")
public class DealRestaurantServlet extends HttpServlet {
    private IDealDAO dealDAO = new DealDAO();
    private IRestaurantDAO restaurantDAO = new RestaurantDAO();
//    private IRestaurantDAO restaurantDAO = new DAO.Restaurant.RestaurantDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showCreateDealForm(request, response);
                break;
            case "edit":
                showUpdateForm(request, response);
                break;
            case "createRestaurant":
                showCreateRestaurantForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "deleteRestaurant":
                showDeleteFormRestaurant(request, response);
                break;
            case "listRestaurant":
                listRestaurant(request, response);
                break;
            case "editRestaurant":
                showUpdateFormRestaurant(request, response);
                break;
            default:
                listDeal(request, response);
                break;
        }
    }

    private void showUpdateFormRestaurant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Restaurant existingRestaurant = restaurantDAO.findById(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("restaurant/restaurant1/editRestaurant.jsp");
        request.setAttribute("restaurant", existingRestaurant);
        requestDispatcher.forward(request, response);
    }

    private void showDeleteFormRestaurant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Restaurant restaurant = this.restaurantDAO.findById(id);
        request.setAttribute("restaurant", restaurant);
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("restaurant/restaurant1/deleteRestaurant.jsp");
        dispatcher.forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Deal deal = this.dealDAO.findById(id);
        RequestDispatcher dispatcher;
        request.setAttribute("deal", deal);
        dispatcher = request.getRequestDispatcher("restaurant/deal/delete.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listRestaurant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("restaurantList", restaurantDAO.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("restaurant/restaurant1/listRestaurant.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showCreateRestaurantForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("restaurant/restaurant1/createRestaurant.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showCreateDealForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("restaurant", restaurantDAO.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("restaurant/deal/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Deal existingDeal = dealDAO.findById(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("restaurant/deal/edit.jsp");
        request.setAttribute("deal", existingDeal);
        request.setAttribute("restaurant", restaurantDAO.findAll());
        requestDispatcher.forward(request, response);
    }



    private void listDeal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                        request.setAttribute("deal", dealDAO.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("restaurant/deal/listDeal.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertDeal(request, response);
                break;
            case "edit":
                updateDeal(request, response);
                break;
            case "createRestaurant":
                try {
                    insertRestaurant(request, response);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "editRestaurant":
                updateRestaurant(request, response);
                break;
            case "delete":
                deleteDeal(request, response);

                break;
            case "deleteRestaurant":
                deleteRestaurant(request, response);
                break;
        }
    }

    private void updateRestaurant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        Time openTime = Time.valueOf(request.getParameter("openTime"));
        Time closeTime = Time.valueOf(request.getParameter("closeTime"));
        Restaurant restaurant = new Restaurant(id, name, address, phone, openTime, closeTime);
        restaurantDAO.update(restaurant);
        request.setAttribute("message", "This restaurant was updated");
        RequestDispatcher dispatcher = request.getRequestDispatcher("restaurant/restaurant1/displayEditRestaurant.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteRestaurant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        restaurantDAO.delete(id);
        request.setAttribute("message", "This restaurant was deleted");
        RequestDispatcher dispatcher = request.getRequestDispatcher("restaurant/restaurant1/displayDeleteRestaurant.jsp");
        dispatcher.forward(request, response);
    }

    private void insertRestaurant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        Time openTime = Time.valueOf(request.getParameter("openTime"));
        Time closeTime = Time.valueOf(request.getParameter("closeTime"));


        Restaurant restaurant = new Restaurant(name, address, phone, openTime, closeTime);
        restaurantDAO.save(restaurant);
        RequestDispatcher dispatcher = request.getRequestDispatcher("restaurant/restaurant1/displayCreateRestaurant.jsp");
        request.setAttribute("message", "New restaurant was created");
        dispatcher.forward(request, response);

    }


    private void insertDeal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        String idString = request.getParameter("restaurant");
        int idRestaurant = Integer.parseInt(idString);
        Restaurant restaurant = restaurantDAO.findById(idRestaurant);
        Deal deal = new Deal(name, image, description, price, restaurant);
        dealDAO.save(deal);
        RequestDispatcher dispatcher = request.getRequestDispatcher("restaurant/deal/displayCreate.jsp");
        request.setAttribute("message", "New deal was created");
        dispatcher.forward(request, response);
    }

    private void updateDeal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        String idString = request.getParameter("restaurant");
        int idRestaurant = Integer.parseInt(idString);
        Restaurant restaurant = restaurantDAO.findById(idRestaurant);
        Deal deal = new Deal(id, name, image, description, price, restaurant);
        dealDAO.update(deal);
        RequestDispatcher dispatcher = request.getRequestDispatcher("restaurant/deal/displayEdit.jsp");
        request.setAttribute("message", "This deal was updated");
        dispatcher.forward(request, response);

    }

    private void deleteDeal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        dealDAO.delete(id);
        request.setAttribute("message", "This deal was deleted");
        RequestDispatcher dispatcher = request.getRequestDispatcher("restaurant/deal/displayDelete.jsp");
        dispatcher.forward(request, response);
    }
}
