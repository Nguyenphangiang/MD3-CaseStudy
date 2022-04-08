package controller;

import DAO.DiscountCode.DiscountCodeDAO;
import DAO.DiscountCode.IDiscountCodeDAO;
import DAO.Dish.DishDAO;
import DAO.Dish.IDishDAO;
import DAO.Tag.ITagDAO;
import DAO.Tag.TagDAO;
import DAO.restaurant.IRestaurantDAO;
import DAO.restaurant.RestaurantDAO;
import model.Dish;
import model.Restaurant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RestaurantServlet", urlPatterns = "/restaurant")
public class RestaurantServlet extends HttpServlet {
    public static final int DEFAULT_VIEW = 0;
    public static final int DEFAULT_ADD = 0;
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
            case "create":
                showFormAddDish(request,response);
                break;
            case "editDish":
                showFormEditDish(request, response);
                break;
            case "deleteDish":
                showFormDeleteDish(request,response);
                break;
            case "createTag":
                showFormCreatTag(request,response);
                break;
            default:
                showAllDish(request, response);
                break;
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
                addNewDish(request,response);
                break;
            case "editDish" :
                editDish(request,response);
                break;
            case "deleteDish":
                deleteDish(request,response);
                break;
            case "createTag":
                addNewTag(request,response);
                break;
            default:
        }
    }




    private void showAllDish(HttpServletRequest request, HttpServletResponse response) {
        List<Dish> dishes1 = dishDAO.findAll();
        int page;
        int numPerPage = 3;
        int size = dishes1.size();
        int numPage = (size%numPerPage == 0? size/numPerPage : (size/numPerPage) + 1);
        String xpage = request.getParameter("page");
        if (xpage == null){
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }
        int start, end;
        start = (page-1)*numPerPage;
        end = Math.min(page*numPerPage, size);
        List<Dish> dishes = dishDAO.getListDishByPage(dishes1, start, end);

        request.setAttribute("page", page);
        request.setAttribute("numPage", numPage);
        request.setAttribute("dishes", dishes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("dish/listDish.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        RequestDispatcher dispatcher = request.getRequestDispatcher("dish/listDish.jsp");
//        List<Dish> dishes = dishDAO.findAll();
//        request.setAttribute("dishes", dishes);
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    private void showFormEditDish(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Dish existingDish = dishDAO.findById(id);
        RequestDispatcher rd = request.getRequestDispatcher("dish/editDishForm.jsp");
        request.setAttribute("dish", existingDish);
        request.setAttribute("tagList",tagDAO.findAll());
        request.setAttribute("restaurantList",restaurantDAO.findAll());
        rd.forward(request, response);

    }
    private void showFormAddDish(HttpServletRequest request, HttpServletResponse response)  {
        RequestDispatcher dispatcher = request.getRequestDispatcher("dish/create.jsp");
        request.setAttribute("tagList",tagDAO.findAll());
        request.setAttribute("restaurantList",restaurantDAO.findAll());
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showFormDeleteDish(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Dish existingDish = dishDAO.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("dish/deleteDish.jsp");
        request.setAttribute("dish",existingDish);
        request.setAttribute("tagList",tagDAO.findAll());
        request.setAttribute("restaurantList",restaurantDAO.findAll());
        dispatcher.forward(request,response);
    }
    private void showFormCreatTag(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("tag/createTag.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addNewDish(HttpServletRequest request, HttpServletResponse response) {
        String dishName = request.getParameter("dishName");
        String dishImage = request.getParameter("dishImage");
        String dishNote = request.getParameter("dishNote");
        int dishPrice = Integer.parseInt(request.getParameter("dishPrice"));

        String[] dishTag = request.getParameterValues("tags");
        int[] tag = new int[dishTag.length];
        for (int i = 0; i < dishTag.length; i++) {
            tag[i] = Integer.parseInt(dishTag[i]);
        }
        int res_id =Integer.parseInt(request.getParameter("restaurant")) ;
        Restaurant restaurant = restaurantDAO.findById(res_id);
        Dish dish = new Dish(dishName,dishImage,dishNote,dishPrice,restaurant);
        dishDAO.save(dish,tag);
    }
    private void editDish(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String dishName = request.getParameter("name");
        String dishImage = request.getParameter("image");
        String dishNote = request.getParameter("note");
        int dishPrice = Integer.parseInt(request.getParameter("price"));
        String[] tagStr = request.getParameterValues("tags");
        int[] tags = new int[tagStr.length];
        for (int i = 0; i < tagStr.length; i++) {
            tags[i] = Integer.parseInt(tagStr[i]);
        }
        Dish dish = dishDAO.findById(id);
        Restaurant restaurant = dish.getRestaurant();
//        String rest = request.getParameter("restaurant");
//        int id_restaurant = Integer.parseInt(rest);
//        restaurant = restaurantDAO.findById(id_restaurant);
        Dish updateDish = new Dish(id,dishName,dishImage,dishNote,dishPrice,restaurant);
        dishDAO.update(updateDish,tags);
    }
    private void deleteDish(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id")) ;
        dishDAO.delete(id);
    }
    private void addNewTag(HttpServletRequest request, HttpServletResponse response) {
        String tagName = request.getParameter("tagName");
        Tag newTag = new Tag(tagName, DEFAULT_ADD, DEFAULT_VIEW);
        tagDAO.save(newTag);
    }
}

