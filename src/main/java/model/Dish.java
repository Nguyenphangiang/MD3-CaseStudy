package model;

import java.util.List;

public class Dish {
    private int id;
    private String dishName;
    private String dishImage;
    private String dishNote;
    private int dishPrice;
    private List<Tag> tag;
    private Restaurant restaurant;

    public Dish(int id, String dishName, String dishImage, String dishNote, int dishPrice, Restaurant restaurant) {
        this.id = id;
        this.dishName = dishName;
        this.dishImage = dishImage;
        this.dishNote = dishNote;
        this.dishPrice = dishPrice;
        this.restaurant = restaurant;
    }


    public Dish(int id, String dishName, String dishImage, String dishNote, int dishPrice , List<Tag> tag, Restaurant restaurant) {
        this.id = id;
        this.dishName = dishName;
        this.dishImage = dishImage;
        this.dishNote = dishNote;
        this.dishPrice = dishPrice;
        this.tag = tag;
        this.restaurant = restaurant;
    }

    public Dish(String dishName, String dishImage, String dishNote, int dishPrice, List<Tag> tag, Restaurant restaurant) {
        this.dishName = dishName;
        this.dishImage = dishImage;
        this.dishNote = dishNote;
        this.dishPrice = dishPrice;
        this.tag = tag;
        this.restaurant = restaurant;
    }

    public Dish() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishImage() {
        return dishImage;
    }

    public void setDishImage(String dishImage) {
        this.dishImage = dishImage;
    }

    public String getDishNote() {
        return dishNote;
    }

    public void setDishNote(String dishNote) {
        this.dishNote = dishNote;
    }

    public int getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(int dishPrice) {
        this.dishPrice = dishPrice;
    }


    public List<Tag> getTag() {
        return tag;
    }

    public void setTag(List<Tag> tag) {
        this.tag = tag;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", dishName='" + dishName + '\'' +
                ", dishImage='" + dishImage + '\'' +
                ", dishNote='" + dishNote + '\'' +
                ", dishPrice=" + dishPrice +
                ", tag=" + tag +
                ", restaurant=" + restaurant +
                '}';
    }
}
