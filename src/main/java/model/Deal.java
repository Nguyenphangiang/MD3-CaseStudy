package model;

public class Deal {
    private int id;
    private String dealName;
    private String dealImage;
    private String description;
    private int dealPrice;
    private Restaurant restaurant;

    public Deal(int id, String dealName, String dealImage, String description, int dealPrice, Restaurant restaurant) {
        this.id = id;
        this.dealName = dealName;
        this.dealImage = dealImage;
        this.description = description;
        this.dealPrice = dealPrice;
        this.restaurant = restaurant;
    }

    public Deal(String dealName, String dealImage, String description, int dealPrice, Restaurant restaurant) {
        this.dealName = dealName;
        this.dealImage = dealImage;
        this.description = description;
        this.dealPrice = dealPrice;
        this.restaurant = restaurant;
    }

    public Deal() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDealName() {
        return dealName;
    }

    public void setDealName(String dealName) {
        this.dealName = dealName;
    }

    public String getDealImage() {
        return dealImage;
    }

    public void setDealImage(String dealImage) {
        this.dealImage = dealImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(int dealPrice) {
        this.dealPrice = dealPrice;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Deal{" +
                "id=" + id +
                ", dealName='" + dealName + '\'' +
                ", dealImage='" + dealImage + '\'' +
                ", description='" + description + '\'' +
                ", dealPrice=" + dealPrice +
                ", restaurant=" + restaurant +
                '}';
    }
}
