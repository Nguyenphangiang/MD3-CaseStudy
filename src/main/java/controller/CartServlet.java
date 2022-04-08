package controller;

import DAO.Dish.DishDAO;
import DAO.Dish.IDishDAO;
import DAO.Tag.ITagDAO;
import DAO.Tag.TagDAO;
import DAO.TotalDAO;
import DAO.cart.CartDAO;
import DAO.cart.ICartDAO;
import DAO.restaurant.IRestaurantDAO;
import DAO.restaurant.RestaurantDAO;
import model.Cart;
import model.Dish;
import model.Total;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DealRestaurantServlet", urlPatterns = "/restaurantCustomer")
public class CartServlet extends HttpServlet {
    private IDishDAO dishDAO = new DishDAO();
    private IRestaurantDAO restaurantDAO = new RestaurantDAO();
    private ICartDAO cartDAO = new CartDAO();
    private ITagDAO tagDAO = new TagDAO();
    private TotalDAO totalDAO = new TotalDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action = "";
        }
        switch (action){
            case "cart":
                showCartList(request,response);
                break;
            case "buy" :
                insertToCart(request,response);
                break;
            case "editCart":
                showformEdit(request,response);
                break;
            case "deleteCart":
                deleteCart(request,response);
                break;
            case "showFormBuy":
                showFormBuy(request,response);
                break;
            case "confirm":
                showConfirm(request,response);
                break;
            default:
                showCustomerListDish(request,response);
                break;
        }
    }

    private void showConfirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/confirm.jsp");
        dispatcher.forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null ){
            action = "";
        }
        switch (action){
            case "editCart":
                editCart(request,response);
                break;
            case "deleteCart":
                deleteCart(request,response);
                break;

        }
    }

    private void showFormBuy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/formBuy.jsp");
        dispatcher.forward(request,response);
    }


    private void showCustomerListDish(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        request.setAttribute("restaurant",restaurantDAO.findAll());
        request.setAttribute("carts",cartDAO.findAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/customerDishList.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//                RequestDispatcher dispatcher1 = request.getRequestDispatcher("customer/customerDishList.jsp");
//        request.setAttribute("dishes",dishDAO.findAll());
//
//        dispatcher1.forward(request,response);
    }
    private void showCartList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("cart/cartList.jsp");
        request.setAttribute("tags",tagDAO.findAll());
        request.setAttribute("carts",cartDAO.findAll());
        request.setAttribute("dishes",dishDAO.findAll());
        Total total = totalDAO.sum();
        request.setAttribute("total",total);
        dispatcher.forward(request,response);
    }
    private void showformEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Cart existingCart = cartDAO.findById(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("cart/formEdit.jsp");
        request.setAttribute("cart",existingCart);
        requestDispatcher.forward(request,response);
    }

    private void insertToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Dish buyDish = dishDAO.findById(id);
        Cart cart = new Cart(buyDish,1);
        cartDAO.save(cart);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/customerDishList.jsp");
        request.setAttribute("dishes",dishDAO.findAll());
        request.setAttribute("restaurant",restaurantDAO.findAll());
        request.setAttribute("carts",cartDAO.findAll());
        dispatcher.forward(request,response);
    }
    private void deleteCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cartId = Integer.parseInt(request.getParameter("id"));
        cartDAO.delete(cartId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cart/cartList.jsp");
        request.setAttribute("total",totalDAO.sum());
        request.setAttribute("dishes",dishDAO.findAll());
        request.setAttribute("restaurant",restaurantDAO.findAll());
        request.setAttribute("carts",cartDAO.findAll());
        dispatcher.forward(request,response);
    }
    private void editCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cartId = Integer.parseInt(request.getParameter("id"));
        Cart cart = cartDAO.findById(cartId);
        int quantity =Integer.parseInt(request.getParameter("quantity"));
        Dish updateDish = cart.getDish();
        Cart updateCart = new Cart(cartId,updateDish,quantity);
        cartDAO.update(updateCart);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cart/cartList.jsp");
        request.setAttribute("total",totalDAO.sum());
        request.setAttribute("dishes",dishDAO.findAll());
        request.setAttribute("restaurant",restaurantDAO.findAll());
        request.setAttribute("carts",cartDAO.findAll());
        dispatcher.forward(request,response);
    }
}

