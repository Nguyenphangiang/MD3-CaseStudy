package model;

import java.sql.Time;
import java.time.LocalTime;

public class Restaurant {
    private int id;
    private String restaurantName;
    private String restaurantAddress;
    private String restaurantPhone;
    private Time openTime;
    private Time closeTime;

    public Restaurant(int id, String restaurantName, String restaurantAddress, String restaurantPhone, Time openTime, Time closeTime) {
        this.id = id;
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.restaurantPhone = restaurantPhone;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public Restaurant(String restaurantName, String restaurantAddress, String restaurantPhone, Time openTime, Time closeTime) {
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.restaurantPhone = restaurantPhone;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public Restaurant() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public String getRestaurantPhone() {
        return restaurantPhone;
    }

    public void setRestaurantPhone(String restaurantPhone) {
        this.restaurantPhone = restaurantPhone;
    }

    public Time getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Time openTime) {
        this.openTime = openTime;
    }

    public Time getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Time closeTime) {
        this.closeTime = closeTime;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantAddress='" + restaurantAddress + '\'' +
                ", restaurantPhone='" + restaurantPhone + '\'' +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                '}';
    }
}
