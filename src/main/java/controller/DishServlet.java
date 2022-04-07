package controller;

import DAO.discountCode.DiscountCodeDAO;
import DAO.discountCode.IDiscountCodeDAO;
import DAO.dish.DishDAO;
import DAO.dish.IDishDAO;
import DAO.restaurant.IRestaurantDAO;
import DAO.restaurant.RestaurantDAO;
import DAO.tag.ITagDAO;
import DAO.tag.TagDAO;
import model.Dish;
import model.Restaurant;
import model.Tag;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RestaurantServlet", urlPatterns = "/restaurant")
public class DishServlet extends HttpServlet {
    private IDishDAO dishDAO = new DishDAO();
    private IDiscountCodeDAO discountCodeDAO = new DiscountCodeDAO();
    private ITagDAO tagDAO = new TagDAO();
    private IRestaurantDAO restaurantDAO = new RestaurantDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "createDish":
                insertNewDishForm(request, response);
                break;
            case "editDish":
                editDishForm(request, response);
                break;
            case "showMaxAddNumber":
                showMaxAddNumber(request, response);
                break;
            default:
                showAllDish(request, response);
                break;

        }
    }

    private void showMaxAddNumber(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("dish/maxAddNumber.jsp");
        List<Tag> tags = tagDAO.findMaxAddNumber();
        request.setAttribute("tags",tags );
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editDishForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Dish existingDish = dishDAO.findById(id);
        RequestDispatcher rd = request.getRequestDispatcher("dish/editDish.jsp");
        request.setAttribute("dish", existingDish);
        rd.forward(request, response);
    }

    private void insertNewDishForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("dish/insertDishForm.jsp");
        request.setAttribute("tags", tagDAO.findAll());
        request.setAttribute("restaurants", restaurantDAO.findAll());
        rd.forward(request, response);
    }

    private void showAllDish(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("dish/listDish.jsp");
        List<Dish> dishes = dishDAO.findAll();
        request.setAttribute("dishes", dishes);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                insertNewDish(request, response);
                break;
            case "edit":
                updateDish(request, response);
                break;
            default:
        }
    }

    private void updateDish(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String note = request.getParameter("note");
        int price = Integer.parseInt(request.getParameter("price"));

        String idString  = request.getParameter("restaurant");
        int id_restaurant = Integer.parseInt(idString);
        Restaurant restaurants = restaurantDAO.findById(id_restaurant);

        Dish dish = new Dish(name, image, note, price, restaurants);

        String[] tagsStr = request.getParameterValues("tags");
        int[] tags = new int[tagsStr.length];
        for (int i = 0; i < tagsStr.length; i++) {
            tags[i] = Integer.parseInt(tagsStr[i]);
        }


//        dishDAO.save(dish, tags);
//        RequestDispatcher rd = request.getRequestDispatcher("insertDishForm.jsp");
//        rd.forward(request, response);


//        User book = new User(id, name, email, country);
//        userDao.updateUser(book);
//        RequestDispatcher rd = request.getRequestDispatcher("edit.jsp");
//        rd.forward(request,response);

    }

    private void insertNewDish(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String note = request.getParameter("note");
        int price = Integer.parseInt(request.getParameter("price"));

        String idString  = request.getParameter("restaurant");
        int id_restaurant = Integer.parseInt(idString);
        Restaurant restaurants = restaurantDAO.findById(id_restaurant);

        Dish dish = new Dish(name, image, note, price, restaurants);

        String[] tagsStr = request.getParameterValues("tags");
        int[] tags = new int[tagsStr.length];
        for (int i = 0; i < tagsStr.length; i++) {
            tags[i] = Integer.parseInt(tagsStr[i]);
        }

        dishDAO.save(dish, tags);
        RequestDispatcher rd = request.getRequestDispatcher("insertDishForm.jsp");
        rd.forward(request, response);
    }
}
